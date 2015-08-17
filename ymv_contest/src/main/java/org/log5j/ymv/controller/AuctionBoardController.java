package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.AuctionBoardService;
import org.log5j.ymv.model.board.AuctionBoardVO;
import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuctionBoardController {
	
	@Resource
	private AuctionBoardService auctionBoardService;

	@RequestMapping("auction_board.ymv")
	@NoLoginCheck
	public ModelAndView auctionBoard(String pageNo) {	
		ListVO auvo = auctionBoardService.findBoardList(pageNo);
		System.out.println(auvo+"컨틀롤러");
		return new ModelAndView("auction_board","auvo",auvo);
	}

	@RequestMapping("auction_show_content.ymv")
	@NoLoginCheck
	 public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView("auction_show_content");
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		System.out.println("auction_showContent boardNo: " + boardNo);
		int pictureNo=boardNo;
		BoardVO auvo=auctionBoardService.findAuctionBoardByBoardNo(boardNo);
		PictureVO pvo=auctionBoardService.findPicture(pictureNo);
		if(pvo!=null){
			mv.addObject("pvo",pvo);
	    }
		System.out.println("showContent : "+auvo+" picture:"+pvo);
		 return mv.addObject("auvo", auvo);
}	
	
	@RequestMapping("auction_update_view.ymv")
	public ModelAndView auctionBoardUpdateView(int boardNo) {		
		AuctionBoardVO abvo = (AuctionBoardVO) auctionBoardService.findAuctionBoardByBoardNo(boardNo);
		/*abvo=auctionBoardService.setDate(abvo);*/
		return new ModelAndView("auction_update_view","abvo",abvo);
	}

	@RequestMapping("auction_board_update.ymv")
	public String auctionBoardUpdate(AuctionBoardVO abvo, PictureVO pvo, HttpServletRequest request,String hidden){
		auctionBoardService.updateAuctionBoard(abvo);
		abvo = (AuctionBoardVO) auctionBoardService.findAuctionBoardByBoardNo(abvo.getBoardNo());
		HttpSession session=request.getSession(false);
		System.out.println(pvo);
		int hid = Integer.parseInt(hidden);
		session.setAttribute("abvo", abvo);
		session.setAttribute("pvo", pvo);
		session.setAttribute("hidden", "update");
		if(hid==2){
			return "redirect:auction_show_content.ymv?boardNo="+abvo.getBoardNo();
		}
		return "forward:upload_auction_path.ymv";
	}
	@RequestMapping("auction_update_file.ymv")
	public ModelAndView sponsorUpdate(HttpServletRequest request) {
		PictureVO pvo = (PictureVO) request.getSession().getAttribute("pvo");
		auctionBoardService.updatePicture(pvo);
		return new ModelAndView("redirect:auction_show_content.ymv?boardNo="+pvo.getPictureNo());
	}
	
	@RequestMapping("auction_board_delete.ymv")
	public ModelAndView auctionBoardDelete(String boardNo){
	
		auctionBoardService.deleteAuctionBoard(boardNo);
		int pictureNo=Integer.parseInt(boardNo);
		auctionBoardService.deletePicture(pictureNo);
		return new ModelAndView("redirect:auction_board.ymv");
	}
	
	@RequestMapping("auction_register_view.ymv")
	public ModelAndView auctionRegisterView(){		
		return new ModelAndView("auction_register_view");
	}

	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : 
	 * @param abvo
	 * @param pvo
	 * @return
	 */
	@RequestMapping("auction_register.ymv")
	public String auctionRegister(AuctionBoardVO abvo,PictureVO pvo,HttpServletRequest request){
		System.out.println("등록할 정보 입니다. " + abvo +"pvo 입니다  " + pvo);
		abvo.setEndDate(abvo.getEndDate());
		auctionBoardService.registerAuctionBoard(abvo);
		AuctionBoardVO avo = (AuctionBoardVO) auctionBoardService.findAuctionBoardByBoardNo(abvo.getBoardNo());
		HttpSession session=request.getSession(false);
		session.setAttribute("abvo", avo);
		session.setAttribute("pvo", pvo);
		session.setAttribute("hidden", "register");
		return "forward:upload_auction_path.ymv";
	}
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : 
	 * @param pvo
	 * @return
	 */
	@RequestMapping("auction_register_file.ymv")
	public ModelAndView memberProfileUpdate(HttpServletRequest request) {
		PictureVO pvo=(PictureVO)request.getSession().getAttribute("pvo");
		auctionBoardService.registerPicture(pvo);
		AuctionBoardVO abvo=(AuctionBoardVO)request.getSession().getAttribute("abvo");
		return new ModelAndView("redirect:auction_show_content.ymv?boardNo="+abvo.getBoardNo());
	}

	@RequestMapping("auction_update_currentPrice.ymv")
	public ModelAndView updateCurrentPrice(AuctionBoardVO abvo) {
		auctionBoardService.updateCurrentPrice(abvo);
		return new ModelAndView("redirect:auction_show_content.ymv?boardNo="
				+ abvo.getBoardNo());
	}
	
	@RequestMapping("auction_update_price.ymv")
	@ResponseBody
	@NoLoginCheck
	public int updatePrice(AuctionBoardVO auvo){
		System.out.println("경매 시작 "+auvo);
		int result = auctionBoardService.updatePrice(auvo);
		return result;
	}

}
