package org.log5j.ymv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.sponsor.SponsorService;
import org.log5j.ymv.model.sponsor.SponsorVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 후원할 수 있는 게시판
 * @author jjh
 *
 */
@Controller
public class SponsorController {
	
	@Resource
	private SponsorService sponsorService;
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 현재 시간과 게시글의 시간을 비교하여 후원완료와 후원중으로 분류하고 페이지에 해당하는 후원글들을 반환한다. 
	 * @param pageNo : 페이지 번호를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_board.ymv")
	@NoLoginCheck
	public ModelAndView findSponsorList(String pageNo) {
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
		ListVO lvo = sponsorService.findSponsorList(pageNo);
		List<PictureVO> pvo = sponsorService.findPictureList(pageNo);
		for(int i = 0; i<lvo.getList().size(); i ++){
			int compare = today.compareTo(((SponsorVO) lvo.getList().get(i)).getEndDate());
			System.out.println(compare);
			System.out.println(today);
			if(compare > 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원완료");
			}else if(compare < 0){
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}else{
				((SponsorVO) lvo.getList().get(i)).setHoowon("후원중");
			}
		}
		return new ModelAndView("sponsor_board").addObject("lvo", lvo).addObject("pvo", pvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 :  후원글 등록 페이지로 이동한다.
	 * @return
	 */
	@RequestMapping("sponsor_register_view.ymv")
	public String sponsorRegisterView() {
		return "sponsor_register_view";
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 사진을 서버에 업로드하고 상세정보와 사진정보를 등록한다.
	 * @param spvo : 후원게시판 상세정보를 받아온다.
	 * @param pvo : 사진정보를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_register.ymv")
	public String sponsorRegister(SponsorVO spvo, PictureVO pvo, HttpServletRequest request) {
		sponsorService.registerSponsor(spvo);
		spvo = sponsorService.findSponsorByBoardNo(spvo.getBoardNo());
		HttpSession session=request.getSession(false);
		session.setAttribute("spvo", spvo);
		session.setAttribute("pvo", pvo);
		return "forward:upload_sponsor_path.ymv";
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글 번호로 조회하고 게시글의 정보를 수정페이지(sponsor_update_view.jsp)으로 반환한다.
	 * @param spvo : 해당 게시글의 글번호를 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_update_view.ymv")
	public ModelAndView updateSponsorView(SponsorVO spvo) {
		spvo = sponsorService.findSponsorByBoardNo(spvo.getBoardNo());
		return new ModelAndView("sponsor_update_view", "spvo", spvo);
	}
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : 게시물을 수정한 후 글번호를 이용해 update하고 업로드할 파일을 uploadpathcontroller로 보내줌
	 * @param spvo : 후원게시글의 수정된 상세 정보를 받아옴.
	 * @param pvo : 게시판의 사진정보를 받아온다.
	 * @return
	 */
	@RequestMapping("sponsor_update.ymv")
	public String updateSponsor(SponsorVO spvo, PictureVO pvo,HttpServletRequest request) {
		sponsorService.updateSponsorByBoardNo(spvo);
		spvo = sponsorService.findSponsorByBoardNo(spvo.getBoardNo());
		HttpSession session=request.getSession(false);
		session.setAttribute("spvo", spvo);
		session.setAttribute("pvo", pvo);
		session.setAttribute("hidden", "update");
		//String ispicture =request.getParameter("ispicture");
		//System.out.println(ispicture+"널일까요?");
		//System.out.println(pvo.getFileName());
		return "forward:upload_sponsor_path.ymv";
	}
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : 
	 * @param request
	 * @return
	 */
	@RequestMapping("sponsor_update_file.ymv")
	public ModelAndView sponsorUpdate(HttpServletRequest request) {
		PictureVO pvo = (PictureVO) request.getSession().getAttribute("pvo");
		System.out.println("사진등록"+pvo);
		sponsorService.updatePicture(pvo);
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : 
	 * @param pvo
	 * @return
	 */
	@RequestMapping("sponsor_register_file.ymv")
	public ModelAndView sponsorRegister(HttpServletRequest request) {
		PictureVO pvo = (PictureVO) request.getSession().getAttribute("pvo");
		System.out.println("사진등록"+pvo);
		sponsorService.registerPicture(pvo);
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글을 삭제한다. 해당 글을 참조하고 있는 사진도 삭제한다.
	 * @param spvo : 해당 게시글의 글번호를 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_delete.ymv")
	public ModelAndView deleteSponsorByBoardNo(SponsorVO spvo) {
		System.out.println(spvo);
		sponsorService.deleteSponsorByBoardNo(spvo.getBoardNo());
		sponsorService.deletePicture(spvo.getBoardNo());
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 해당 게시글의 현재 모집액을 입력된 모집액과 합산하여 수정한다.
	 * @param spvo : 해당 게시글의 글번호와 현재 모집액을 받아오기 위해 사용
	 * @return
	 */
	@RequestMapping("sponsor_update_currentPrice.ymv")
	public ModelAndView updateSponsorCurrentPrice(SponsorVO spvo) {
		sponsorService.updateSponsorCurrentPrice(spvo);
		return new ModelAndView("redirect:sponsor_board.ymv");
	}
}
