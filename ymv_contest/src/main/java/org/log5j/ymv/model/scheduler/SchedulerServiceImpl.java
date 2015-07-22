package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PagingBean;
import org.springframework.stereotype.Service;
@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Resource
	private SchedulerDAO schedulerDAO;
	@Override
	public List<BoardVO> findSchedulerList(SchedulerVO sdvo){
		List<BoardVO> list=schedulerDAO.findSchedulerList(sdvo);
		return list;
	}
	@Override
	public ListVO findSearchList(SearchVO scvo){
		if(scvo.getPageNo()==null||scvo.getPageNo()=="") 
			scvo.setPageNo("1");
		List<BoardVO> list=schedulerDAO.findSearchList(scvo);
		int total=schedulerDAO.totalContent(scvo);
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,Integer.parseInt(scvo.getPageNo()));
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public List<HashMap> findDateList(SchedulerVO sdvo) {
		return schedulerDAO.findDateList(sdvo);
	}
	@Override
	public SchedulerVO checkScheduler(String memberNo) {
		return schedulerDAO.checkScheduler(memberNo);
	}
	@Override
	public void registerScheduler(SchedulerVO sdvo) {
		schedulerDAO.registerScheduler(sdvo);
	}
	@Override
	public void updateScheduler(SchedulerVO sdvo) {
		schedulerDAO.updateScheduler(sdvo);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 페이지 번호를 받아오는데 만약 페이지번호가 null이거나 공백이면 1로 설정을 해준다.
	 * 				findRecruitBoardList를 사용해 검색 된 단어가 포함 된 봉사 목록을 가져온다.
	 * 				findRecruitTotalContent를 사용해 검색 된 단어가 포함 된 게시글의 수를 가져온다.
	 * 				PagingBean에 총 게시글 수와 페이지 번호를 PagingBean에 담아서 페이징 할 수 있도록 한다.
	 * 				ListVO에 list와 paging한 것을 담아서 컨트롤러로 보내준다.
	 * @param sebvo : 검색 된 단어와 페이지번호 를 같이 담기 위해 사용
	 * @return ListVO : 검색 된 List와 페이지번호 를 같이 담기 위해 사용
	 */
	@Override
	public ListVO findRecruitBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.findRecruitBoardList(sebvo);
		int total=schedulerDAO.findRecruitTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO rvo = new ListVO(list, paging);
		System.out.println("rvo: "+rvo);
		return rvo;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 페이지 번호를 받아오는데 만약 페이지번호가 null이거나 공백이면 1로 설정을 해준다.
	 * 				findNoticeBoardList를 사용해 검색 된 단어가 포함 된 봉사 목록을 가져온다.
	 * 				findNoticeBoardTotalContent를 사용해 검색 된 단어가 포함 된 게시글의 수를 가져온다.
	 * 				PagingBean에 총 게시글 수와 페이지 번호를 PagingBean에 담아서 페이징 할 수 있도록 한다.
	 * 				ListVO에 list와 paging한 것을 담아서 컨트롤러로 보내준다.
	 * @param sebvo : 검색 된 단어와 페이지번호 를 같이 담기 위해 사용
	 * @return ListVO : 검색 된 List와 페이지번호 를 같이 담기 위해 사용
	 */
	@Override
	public ListVO findNoticeBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.findNoticeBoardList(sebvo);
		int total=schedulerDAO.findNoticeBoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO nvo = new ListVO(list, paging);
		System.out.println("nvo: "+nvo);
		return nvo;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 페이지 번호를 받아오는데 만약 페이지번호가 null이거나 공백이면 1로 설정을 해준다.
	 * 				findReviewBoardList를 사용해 검색 된 단어가 포함 된 봉사 목록을 가져온다.
	 * 				findReviewBoardTotalContent를 사용해 검색 된 단어가 포함 된 게시글의 수를 가져온다.
	 * 				PagingBean에 총 게시글 수와 페이지 번호를 PagingBean에 담아서 페이징 할 수 있도록 한다.
	 * 				ListVO에 list와 paging한 것을 담아서 컨트롤러로 보내준다.
	 * @param sebvo : 검색 된 단어와 페이지번호 를 같이 담기 위해 사용
	 * @return ListVO : 검색 된 List와 페이지번호 를 같이 담기 위해 사용
	 */
	@Override
	public ListVO findReviewBoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.findReviewBoardList(sebvo);
		int total=schedulerDAO.findReviewBoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO revo = new ListVO(list, paging);
		System.out.println("revo: "+revo);
		return revo;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 페이지 번호를 받아오는데 만약 페이지번호가 null이거나 공백이면 1로 설정을 해준다.
	 * 				findQnABoardList를 사용해 검색 된 단어가 포함 된 봉사 목록을 가져온다.
	 * 				findQnABoardTotalContent를 사용해 검색 된 단어가 포함 된 게시글의 수를 가져온다.
	 * 				PagingBean에 총 게시글 수와 페이지 번호를 PagingBean에 담아서 페이징 할 수 있도록 한다.
	 * 				ListVO에 list와 paging한 것을 담아서 컨트롤러로 보내준다.
	 * @param sebvo : 검색 된 단어와 페이지번호 를 같이 담기 위해 사용
	 * @return ListVO : 검색 된 List와 페이지번호 를 같이 담기 위해 사용
	 */
	@Override
	public ListVO findQnABoardList(SearchBoardVO sebvo) {
		if (sebvo.getPageNo() == null || sebvo.getPageNo() == ""){
			sebvo.setPageNo("1");
		}
		List<BoardVO> list = schedulerDAO.findQnABoardList(sebvo);
		int total=schedulerDAO.findQnABoardTotalContent(sebvo.getSearch());
		PagingBean paging=new PagingBean(total, Integer.parseInt(sebvo.getPageNo()));
		ListVO qvo = new ListVO(list, paging);
		System.out.println("qvo: "+qvo);
		return qvo;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : schedulerDAO에서 findThreeRecruitBoardList를 수행한 값을 return 해준다.
	 * 				봉사 목록 중에서 제목과 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색 된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeRecruitBoardList(String search) {
		List<BoardVO> list = schedulerDAO.findThreeRecruitBoardList(search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : schedulerDAO에서 findThreeNoticeBoardList를 수행한 값을 return 해준다.
	 * 				공지사항 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeNoticeBoardList(String search) {
		List<BoardVO> list = schedulerDAO.findThreeNoticeBoardList(search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : schedulerDAO에서 findThreeReviewBoardList를 수행한 값을 return 해준다.
	 * 				봉사 후기 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeReviewBoardList(String search) {
		List<BoardVO> list = schedulerDAO.findThreeReviewBoardList(search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : schedulerDAO에서 findThreeQnABoardList를 수행한 값을 return 해준다.
	 * 				QnA 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeQnABoardList(String search) {
		List<BoardVO> list = schedulerDAO.findThreeQnABoardList(search);
		return list;
	}
}
