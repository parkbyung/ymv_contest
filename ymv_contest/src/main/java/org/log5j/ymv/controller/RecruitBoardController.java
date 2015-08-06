package org.log5j.ymv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.CompanyVO;
import org.log5j.ymv.model.board.FieldVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.LocationVO;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.log5j.ymv.model.member.Email;
import org.log5j.ymv.model.member.EmailSender;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 *  봉사와 관련된 모든 일들이 RecruitBoardController를 통해 control된다.
 * @author KOSTA_07_012
 *
 */
@Controller
public class RecruitBoardController {
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	@Resource(name="voluntaryServiceApplicateServiceImpl")
	private VoluntaryServiceApplicateService voluntaryServiceApplicateService;
	@Resource
	private MemberService memberService;
	@Resource
	private CookieService cookieService;
	@Autowired
    private EmailSender emailSender;
	/**
	 * 
	 * 작성자 : 박병준, 백지영
	 * 내용 : recruitboard db에 있는 페이징 처리된 Voluntary Board List를 불러온다. 
	 * 현재 날짜와 봉사 신청이 마감하는 날을 비교 하여 
	 * ListVO에 모집중인지 아닌지를 판단하여 준다.
	 * @param pageNo
	 * @return voluntary_board.jsp
	 */
	@RequestMapping("voluntary_board.ymv")
	@NoLoginCheck
	public ModelAndView list(String pageNo) {	
		ModelAndView mv = new ModelAndView("voluntary_board");
		//현재 날짜를 YYYY-MM-DD 포맷으로 받아옴
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		//pageNo로 리스트들과 paging 처리 하는 LISTVO로 가져옴
		ListVO lvo = recruitBoardService.findBoardList(pageNo);
		//lvo안에 있는 list들의 모집기한 마지막 날과 현재 날과 비교 함
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			//비교해서 today가 enddate보다 크면 compare가 0보다 크다.
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : voluntary_board.jsp에서 상세 내용을 보려 할 때 실행되는 메소드
	 * 기업과 사용자와 비사용자를 나누어서 .jsp로 보내준다.
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("voluntary_show_content_recruit_vol_type.ymv")
	public ModelAndView showContentRecruitVolType(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String url = "voluntary_show_content";
		int recruitNo = Integer.parseInt(request.getParameter("recruitNo"));
		if (mvo.getMemberType().equals("normal")) {
			url = "voluntary_show_content_normal";
		} else if (mvo.getMemberType().equals("company")) {
			url = "voluntary_show_content_company";
		}
		Cookie[] cookies = request.getCookies();
		Cookie cookie = cookieService.cookieSerivce(cookies, recruitNo,
				new NoticeBoardVO());
		response.addCookie(cookie);
		RecruitBoardVO rvo = recruitBoardService
				.findRecruitBoardByRecruitNo(recruitNo);
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
        int compare = today.compareTo(rvo.getEndDate());
        if(compare > 0){
        	rvo.setMojib("모집완료");
			}else if(compare < 0){
				rvo.setMojib("모집중");
			}else{
				rvo.setMojib("모집중");
			}
		// RecruitBoardVO에 있는 memberNo로 MemberVO의 정보를 찾아 model로 보냄
		MemberVO vo = memberService.findMemberByMemberNo(rvo.getMemberNo());
		return new ModelAndView(url, "rvo", rvo).addObject("vo", vo);
	}

    /**
     * 
     * 작성자 : 박병준, 임영학
     * 내용 : 
     * @param request
     * @return
     */
    @RequestMapping("find_applicant_list.ymv")
    @ResponseBody
    public List getApplicantList(HttpServletRequest request){
    	HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
		List<ApplicantListVO> list=null;
    	if(mvo.getMemberType().equals("company")){
    		list=voluntaryServiceApplicateService.findApplicantList(recruitNo);
    		System.out.println("getApplicantList list: "+list);
    	}
    	return list;
    }
    /**
     * 
     * 작성자 : 박병준
     * 내용 : Recruit Board 내 글을 수정하는 view를 제공하는 메소드. 
     * @param recruitNo
     * @param request
     * @return
     */
	@RequestMapping("voluntary_board_update_view.ymv")
	public ModelAndView updateView(int recruitNo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// recruitNo를 가지고 RecruitBoard 정보를 불러옴
		RecruitBoardVO rvo = (RecruitBoardVO) recruitBoardService
				.findRecruitBoardByRecruitNo(recruitNo);
		// 분야 리스트
		List<FieldVO> Flist = recruitBoardService.findFieldList();
		// 지역 리스트
		List<LocationVO> Llist = recruitBoardService.findLocationList();
		String command = request.getParameter("command");
		mv.setViewName("voluntary_board_update_view");
		//Model에 필요한 데이터들을 추가시킨다.
		mv.addObject("fieldlist", Flist).addObject("locationlist", Llist)
				.addObject("rvo", rvo).addObject("command", command);
		return mv;
	}
/**
 * 
 * 작성자 : 박병준
 * 내용 : 함께
 * @param request
 * @param rbvo
 * @return
 */
	@RequestMapping("voluntary_board_update.ymv")
	   public ModelAndView voluntary_board_update(HttpServletRequest request, RecruitBoardVO rbvo) {
	      ModelAndView mv=new ModelAndView();
         recruitBoardService.updateBoard(rbvo);
         rbvo=recruitBoardService.findRecruitBoardByRecruitNo(rbvo.getRecruitNo());
         String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
         int compare = today.compareTo(rbvo.getEndDate());
         if(compare > 0){
				rbvo.setMojib("모집완료");
			}else if(compare < 0){
				rbvo.setMojib("모집중");
			}else{
				rbvo.setMojib("모집중");
			}
	      String command=request.getParameter("command");
	      if(command.equals("company")){
	    	  mv.setViewName("voluntary_show_content_company");
	      }else if(command.equals("normal")){
	    	  mv.setViewName("voluntary_show_content_normal");
	      }else{
	    	  mv.setViewName("voluntary_show_content");
	      }
	      mv.addObject("rvo",rbvo);
	      return mv;
	   }
	/**
	 * 
	 * 작성자 : 박병준, 백지영
	 * 내용 : RecruitBoard의 글쓰기를 눌렀을 때 작동하는 메소드.
	 * 분야와 지역의 DB에서 리스트를 가져와 voluntary_register_view.jsp로 보내준다.
	 * @return Model : voluntary_register_view.jsp
	 */
	@RequestMapping("voluntary_register_view.ymv")
	public ModelAndView RegisterVolunteerForm() {
		// 분야 DB에서 리스트를 받아온다.
		List<FieldVO> Flist = recruitBoardService.findFieldList();
		// 지역 DB에서 리스트를 받아온다.
		List<LocationVO> Llist = recruitBoardService.findLocationList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voluntary_register_view");
		mv.addObject("fieldlist", Flist);
		mv.addObject("locationlist", Llist);
		return mv;
	}
	/**
	 * 
	 * 작성자 : 박병준, 백지영
	 * 내용 : RecruitBoard 글 등록해주는 메소드.
	 * @param request : 시작시간과 끝시간을 RecruitBoardVO에 셋팅해준다.
	 * @param rbvo : RecruitBoardVO
	 * @return voluntary_show_content_recruit_vol_type.ymv : recruitNo도 함께 리다이렉트 시켜준다.
	 */
	@RequestMapping("volunteer_register.ymv")
	public String RegisterVolunteer_result(HttpServletRequest request,RecruitBoardVO rbvo){
		//vo가 데이트 타입이여야 하지 않을까?
		rbvo.setStartDate(rbvo.getStartDate());
		rbvo.setEndDate(rbvo.getEndDate());
		rbvo.setPlayStart(request.getParameter("playStart"));
		rbvo.setPlayEnd(request.getParameter("playEnd"));
		//글 등록
		recruitBoardService.registerVolunteer(rbvo);
		System.out.println("등록전에 확인해보자 rbvo"+rbvo);
		return "redirect:voluntary_show_content_recruit_vol_type.ymv?recruitNo=" + rbvo.getRecruitNo();
	}
	/**
	 * 
	 * 작성자 : 장지윤
	 * 내용 : RecruitBoard의 글을 삭제해주는 메소드. 
	 * @param request :recruitNo를 받는다.
	 * @return
	 */
	@RequestMapping("voluntary_delete.ymv")
	   public ModelAndView DeleteRecruitVol(HttpServletRequest request){
	         int recruitNo=Integer.parseInt(request.getParameter("recruitNo"));
	         int pictureNo=recruitNo;
	         //recruitNo를 가진 데이터를 voluntary_service_applicate DB에서 삭제
	         recruitBoardService.deleteVoluntaryServiceApplicateNo(recruitNo);
	         //recruitNo를 가진 데이터를 recruit DB에서 삭제
	         recruitBoardService.deleteRecruitVolunteer(recruitNo);
	         //recruitNo를 가진 데이터를 picture DB에서 삭제
	         recruitBoardService.deletePicture(pictureNo);
	      return new ModelAndView("redirect:/voluntary_board.ymv?pageNo=1");
	   }
	/**
	 * 
	 * 작성자 : 박병준, 백지영
	 * 내용 : 같이
	 * @param request
	 * @param cpvo
	 * @return
	 */
	@RequestMapping("voluntary_board_company.ymv")
	public ModelAndView voluntaryBoardCompany(HttpServletRequest request,CompanyVO cpvo){
		//세션에 들어있는 멤버넘버로 등록된 글 조회 
		ModelAndView mv = new ModelAndView("voluntary_board_company");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.findCompanyBoardList(cpvo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	/**
	 * 
	 * 작성자 : 박병준, 백지영
	 * 내용 : 같이
	 * @param request
	 * @param cpvo
	 * @return
	 */
	@RequestMapping("voluntary_board_normal.ymv")
	@NoLoginCheck
	public ModelAndView voluntaryBoardNormal(HttpServletRequest request, CompanyVO cpvo){
		ModelAndView mv = new ModelAndView("voluntary_board_normal");
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
		cpvo.setMemberNo(mvo.getMemberNo());
		ListVO lvo = recruitBoardService.findNormalBoardList(cpvo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((RecruitBoardVO) lvo.getList().get(i)).getEndDate());
			if(compare > 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집완료");
			}else if(compare < 0){
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}else{
				((RecruitBoardVO)lvo.getList().get(i)).setMojib("모집중");
			}
		}
		mv.addObject("lvo", lvo);
		return mv;
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @param request
	 * @param alvo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("voluntary_applicantOK.ymv")
	@NoLoginCheck
	@Transactional
	public ModelAndView applicantOK(HttpServletRequest request,ApplicantListVO alvo) throws Exception{
		Email email = new Email();
		String memberList=request.getParameter("memberList");
		String title=request.getParameter("title");
		String member[]=memberList.split(",");
		for(int i=0;i<member.length;i++){
			alvo.setMemberNo(Integer.parseInt(member[i]));
			recruitBoardService.registerApplicantOK(alvo);
			voluntaryServiceApplicateService.deleteApplicant(alvo);
			//선정된 인원에게 메일 발송 memberNo로 메일 뽑아오기
			MemberVO mailList=recruitBoardService.findMailAddressByMemberNo(Integer.parseInt(member[i]));
			String reciver = mailList.getMailAddress(); //받을사람의 이메일입니다.
	        String subject = "안녕하세요. 너나봉 관리자입니다";
	        String content = mailList.getName()+"님 봉사활동인원으로 선정되었습니다.\n"
	        		+ "홈페이지에서 신청하신 ["+title+"] 봉사활동의 일시와 장소를 확인해주세요.";
	        email.setReciver(reciver);
	        email.setSubject(subject);
	        email.setContent(content);
	        emailSender.SendEmail(email);
		}
			List<ApplicantListVO> list=recruitBoardService.findApplicantOkList(alvo.getRecruitNo());
		return new ModelAndView("voluntary_applicantOK","list",list);
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @param request
	 * @param alvo
	 * @return
	 */
	@RequestMapping("voluntary_OKList.ymv")
	public ModelAndView voluntary_OKList(HttpServletRequest request,ApplicantListVO alvo){
		//String recruitNo=request.getParameter("recruitNo");
		List<ApplicantListVO> list=recruitBoardService.findApplicantOkList(alvo.getRecruitNo());
		return new ModelAndView("voluntary_OKList","list",list);
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @param request
	 * @param alvo
	 * @return
	 */
	@RequestMapping("voluntary_confirm.ymv")
	public ModelAndView voluntary_confirm(HttpServletRequest request,ApplicantListVO alvo){
		//선택된 인원들 새로운 디비에 저장(confirm)
		String memberList=request.getParameter("memberList");
		String member[]=memberList.split(",");
		for(int i=0;i<member.length;i++){
			alvo.setMemberNo(Integer.parseInt(member[i]));
			ConfirmBoardVO confirmbvo=new ConfirmBoardVO();
			RecruitBoardVO recruitbvo=recruitBoardService.findRecruitBoardByRecruitNo(alvo.getRecruitNo());
			confirmbvo.setBoardNo(recruitbvo.getRecruitNo());
			confirmbvo.setTitle(recruitbvo.getTitle());
			confirmbvo.setField(recruitbvo.getField());
			confirmbvo.setLocation(recruitbvo.getLocation());
			confirmbvo.setAge(recruitbvo.getAge());
			confirmbvo.setStartDate(recruitbvo.getStartDate());
			confirmbvo.setEndDate(recruitbvo.getEndDate());
			confirmbvo.setContent(recruitbvo.getContent());
			confirmbvo.setMemberNo(recruitbvo.getMemberNo());
			recruitBoardService.registerConfirmBoard(confirmbvo);
			//글등록 먼저하고나서 컨펌등록
			ConfirmVO confirmvo=new ConfirmVO();
			confirmvo.setBoardNo(alvo.getRecruitNo());
			confirmvo.setMemberNo(alvo.getMemberNo());
			recruitBoardService.registerConfirm(confirmvo);
			recruitBoardService.deleteVoluntaryApplicantOK(recruitbvo.getRecruitNo());
			recruitBoardService.deleteVoluntaryServiceApplicateByRecruitNo(recruitbvo.getRecruitNo());
			recruitBoardService.deleteRecruitVolunteer(recruitbvo.getRecruitNo());
			
		}
		//해당 글 삭제.
		return new ModelAndView("voluntary_confirm");
	}
	/**
	 * 
	 * 작성자 : 장지윤
	 * 내용 : 
	 * @param request
	 * @param cpvo
	 * @return
	 */
	@RequestMapping("voluntary_board_normal_confirmList.ymv")
	   @NoLoginCheck
	   public ModelAndView voluntaryBoardNormalConfirmList(HttpServletRequest request, CompanyVO cpvo){
	      MemberVO mvo=(MemberVO) request.getSession().getAttribute("mvo");
	      System.out.println("mvo11111:"+mvo);
	      cpvo.setMemberNo(mvo.getMemberNo());
	      //멤버넘버로 컨펌을 찾아와서 컨펌에 있는 보드넘버로 그 보드넘버에 해당하는 컨펌보드글들을 불러와야지
	      //List<ConfirmVO> confirmList=recruitBoardService.getConfirmListByMemberNo(mvo.getMemberNo());
	      //System.out.println("confirmList:"+confirmList);
	      ConfirmPageVO confirmPageVO=new ConfirmPageVO();
	      confirmPageVO.setMemberNo(mvo.getMemberNo());
	      //confirmPageVO.setPageNo(Integer.parseInt(pageNo));
	      ListVO lvo=recruitBoardService.findConfirmBoardListByMemberNo(confirmPageVO);
	      
	      return new ModelAndView("voluntary_board_normal_confirmList","lvo",lvo);
	   }
	/**
	 * 
	 * 작성자 : 장지윤, 전진한
	 * 내용 : 
	 * @param request
	 * @param cvo
	 * @return
	 */
	@RequestMapping("voluntary_confirm_normal.ymv")
	   @NoLoginCheck
	   public ModelAndView voluntaryConfirmNormal(HttpServletRequest request, ConfirmVO cvo){
		System.out.println("cvo:"+cvo);
		ConfirmBoardVO cbvo= recruitBoardService.findConfirmBoardByConfirm(cvo);
		System.out.println("cbvo:"+cbvo);
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		String arr[]= today.split("-");
		HashMap map=new HashMap();
		map.put("year",arr[0] );
		map.put("month",arr[1] );
		map.put("date",arr[2] );
		return new ModelAndView("voluntary_confirm_show_content","cbvo",cbvo).addObject("today",map);
	   }
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @return
	 */
	@RequestMapping("voluntary_print.ymv")
	@NoLoginCheck
	public ModelAndView voluntaryPrint(){
		return new ModelAndView("voluntaryboard/print");
	}
}
