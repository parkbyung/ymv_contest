package org.log5j.ymv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.log5j.ymv.model.scheduler.SchedulerService;
import org.log5j.ymv.model.scheduler.SchedulerVO;
import org.log5j.ymv.model.scheduler.SearchBoardVO;
import org.log5j.ymv.model.scheduler.SearchVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 회원 scheduler 및 통합검색을 위한 클래스
 * @author 전진한,백지영
 *
 */
@Controller
public class SchedulerController {
	@Resource 
	private SchedulerService schedulerService; 
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 :  상세정보 조건에 대한 검색 결과 list와 모집상태, 각각의 날짜정보 dateList를 반환한다.
	 * @param sdvo : 스케쥴러 검색 조건을 받아온다.
	 * @return
	 */
	@RequestMapping("scheduler_board.ymv")
	@ResponseBody
	public HashMap findSchedulerList(SchedulerVO sdvo){
		if(sdvo.getField().equals("null")){
			sdvo.setField("");
		}
		if(sdvo.getLocation().equals("null")){
			sdvo.setLocation("");
		}
		if(sdvo.getVolunteeringStartTime().equals("null")){
			sdvo.setVolunteeringStartTime("");
		}
		if(sdvo.getVolunteeringEndTime().equals("null")){
			sdvo.setVolunteeringEndTime("");
		}
		List<BoardVO> list= schedulerService.findSchedulerList(sdvo);
		List<HashMap> dateList=schedulerService.findDateList(sdvo);
		System.out.println("SchedulerController List,dateList"+list+"\n"+dateList);
		HashMap schedulerMap=new HashMap();
		schedulerMap.put("list", list);
		schedulerMap.put("dateList", dateList);
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		for(int i = 0; i<list.size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) list.get(i)).getRecruitingEnd());
			if(compare > 0){
				((RecruitBoardVO)list.get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)list.get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)list.get(i)).setMojib("모집중");
			}
		}
		System.out.println("SchedulerController 종료전");
		return schedulerMap;
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 봉사게시판 검색, 검색 결과와 페이지 정보 검색 조건을 반환한다.
	 * @param scvo : 검색 조건들을 받아온다.
	 * @return
	 */
	@RequestMapping("search_board.ymv")
	@NoLoginCheck
	public ModelAndView findSearchList(SearchVO scvo){
		ModelAndView mv = new ModelAndView("search_recruit_result");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		ListVO lvo = schedulerService.findSearchList(scvo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getRecruitingEnd());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo).addObject("scvo", scvo);
		return mv;
		
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : DB에 저장된 유형 목록과 지역 목록을 받아와 반환한다. // recruitBoardService.findFieldList() 수정
	 * @return
	 */
	@RequestMapping("search_view.ymv")
	@NoLoginCheck
	public ModelAndView searchView(){
	     List<FieldVO> Flist = recruitBoardService.findFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.findLocationList();
		return new ModelAndView("search_view").addObject("fieldlist", Flist).addObject("locationlist", Llist);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 회원의 스케쥴러 정보가 존재하면 스케쥴러 정보를 아니면 null을 반환한다.
	 * @param request : 해당 회원의 회원번호를 받아온다.
	 * @return
	 */
	@RequestMapping("scheduler_Check")
	@ResponseBody
	public Object checkScheduler(HttpServletRequest request){
		SchedulerVO sdvo=schedulerService.checkScheduler(request.getParameter("memberNo"));
		if(sdvo==null){
			return sdvo=new SchedulerVO();
		}
		return sdvo;
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : DB에 저장된 유형 목록과 지역 목록을 받아와 반환하며 스케쥴러 등록을 위한 뷰로 이동
	 * @return
	 */
	@RequestMapping("scheduler_register_view")
	public ModelAndView schedulerRegisterView(){
		 List<FieldVO> Flist = recruitBoardService.findFieldList(); 
	      List<LocationVO> Llist = recruitBoardService.findLocationList();
		return new ModelAndView("scheduler_register_view","fieldlist",Flist).addObject("locationlist", Llist);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 스케쥴러 설정 정보를 DB에 등록하고 redirect 방식으로 홈으로 이동한다.
	 * @param sdvo : 스케쥴러 설정 정보를 받아온다.
	 * @return
	 */
	@RequestMapping("scheduler_register")
	public String schedulerRegister(SchedulerVO sdvo){
		schedulerService.registerScheduler(sdvo);
		return "redirect:testTiles.ymv";
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 설정된 회원의 스케쥴러 정보와 유형 목록과 지역 목록을 수정페이지로 반환한다.
	 * @param request : 해당 회원의 회원번호를 받아온다.
	 * @return
	 */
	@RequestMapping("scheduler_update_view")
	public ModelAndView schedulerUpdateView(HttpServletRequest request){
		SchedulerVO sdvo=schedulerService.checkScheduler(request.getParameter("memberNo"));
		 List<FieldVO> Flist = recruitBoardService.findFieldList(); 
	     List<LocationVO> Llist = recruitBoardService.findLocationList();
		return new ModelAndView("scheduler_update_view","sdvo",sdvo).addObject("fieldlist", Flist).addObject("locationlist", Llist);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 수정된 정보를 DB에 업데이트 하고 redirect 방식으로 홈으로 이동한다.
	 * @param sdvo : 수정한 스케쥴러 정보와 회원번호를 받아온다.
	 * @return
	 */
	@RequestMapping("scheduler_update")
	public String schdulerUpdate(SchedulerVO sdvo){
		schedulerService.updateScheduler(sdvo);
		return "redirect:testTiles.ymv";
	}
	
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 검색어를 받아와서 각 게시판 별로 해당 검색어가 들어가는 글을 게시판 당 3개씩 찾아준다.
	 * 				글이 3개 이상 있을 경우 더보기 라는 링크가 생겨 그 검색어에 해당하는 결과를 더 볼 수 있다.
	 * @param search : 검색한 단어
	 * @return "search_result"
	 */
	@RequestMapping("search_boards.ymv")
	@NoLoginCheck
	public ModelAndView searchBoard(String search){
		ModelAndView mv = new ModelAndView("search_result");

		List rvo = schedulerService.findThreeRecruitBoardList(search);
		mv.addObject("rvo", rvo);//recruit
		
		List nvo = schedulerService.findThreeNoticeBoardList(search);
		mv.addObject("nvo", nvo);//notice
		
		List revo = schedulerService.findThreeReviewBoardList(search);
		mv.addObject("revo",revo);//review
		
		List qvo = schedulerService.findThreeQnABoardList(search);
		mv.addObject("qvo", qvo);//QnA
		
		mv.addObject("search", search);
		return mv;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 검색 목록에서 더보기를 누를경우 실행된다.
	 * 				검색 된 단어를 가지고 제목, 상세내용 중 해당하는 단어가 있으면 그 글의 정보를 ListVO에 담아주고
	 * 				검색 된 단어를 포함하고 있는 목록만 보여지는 페이지("search_detail_recruit.jsp")로 보내준다.
	 * @param sebvo : 검색된 단어와 페이지 번호를 같이 담기 위해서 사용 
	 * @return
	 */
	@RequestMapping("search_boards_recruit.ymv")
	@NoLoginCheck
	public ModelAndView searchBoardsRecruit(SearchBoardVO sebvo){
		ModelAndView mv = new ModelAndView("search_detail_recruit");
		
		ListVO rvo = schedulerService.findRecruitBoardList(sebvo);
		mv.addObject("rvo", rvo).addObject("sebvo", sebvo);
		
		return mv;
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 공지사항 검색 목록에서 더보기를 누를 경우 실행된다.
	 * 				검색 된 단어가 제목, 상세내용 중 해당하는 단어가 있으면 그 글의 정보를 ListVO에 담아주고
	 * 				검색 된 단어를 포함하고 있는 목록만 보여지는 페이지("search_detail_notice.jsp")로 보내준다.
	 * @param sebvo : 검색된 단어와 페이지 번호를 같이 담기 위해서 사용
	 * @return
	 */
	@RequestMapping("search_boards_notice.ymv")
	@NoLoginCheck
	public ModelAndView searchBoardsNotice(SearchBoardVO sebvo){
		ModelAndView mv = new ModelAndView("search_detail_notice");
		
		ListVO nvo = schedulerService.findNoticeBoardList(sebvo);
		mv.addObject("nvo", nvo).addObject("sebvo", sebvo);
		
		return mv;
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 후기 검색 목록에서 더보기를 누를 경우 실행된다.
	 * 				검색 된 단어를 가지고 제목, 작성자, 상세내용 중 해당하는 단어가 있으면 그 글의 정보를 ListVO에 담아주고
	 * 				검색 된 단어를 포함하고 있는 목록만 보여지는 페이지("search_detail_review.jsp")로 보내준다.
	 * @param sebvo : 검색된 단어와 페이지 번호를 같이 담기 위해서 사용
	 * @return
	 */
	@RequestMapping("search_boards_review.ymv")
	@NoLoginCheck
	public ModelAndView searchBoardsReview(SearchBoardVO sebvo){
		ModelAndView mv = new ModelAndView("search_detail_review");
		
		ListVO revo = schedulerService.findReviewBoardList(sebvo);
		mv.addObject("revo", revo).addObject("sebvo", sebvo);
		
		return mv;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : QnA 검색 목록에서 더보기를 누를 경우 실행된다.
	 * 				검색 된 단어를 가지고 제목, 작성자, 상세내용 중 해당하는 단어가 있으면 그 글의 정보를 ListVO에 담아주고
	 * 				검색 된 단어를 포함하고 있는 목록만 보여지는 페이지("search_detail_QnA.jsp")로 보내준다.
	 * @param sebvo : 검색된 단어와 페이지 번호를 같이 담기 위해서 사용
	 * @return
	 */
	@RequestMapping("search_boards_QnA.ymv")
	@NoLoginCheck
	public ModelAndView searchBoardsQnA(SearchBoardVO sebvo){
		ModelAndView mv = new ModelAndView("search_detail_QnA");
		
		ListVO qvo = schedulerService.findQnABoardList(sebvo);
		mv.addObject("qvo", qvo).addObject("sebvo", sebvo);
		
		return mv;
	}
}
