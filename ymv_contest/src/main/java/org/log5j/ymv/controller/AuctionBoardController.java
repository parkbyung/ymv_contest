package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.AuctionBoardService;
import org.log5j.ymv.model.board.AuctionBoardVO;
import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuctionBoardController {
	
	@Resource
	private AuctionBoardService auctionBoardService;

/*	@RequestMapping("auctionTiles.ymv")
	@NoLoginCheck
	public String auctionTiles(){
		return "home";
	}*/
	@RequestMapping("auction_board.ymv")
	@NoLoginCheck
	public ModelAndView auctionBoard(String pageNo) {	
		ListVO auvo = auctionBoardService.findBoardList(pageNo);
		System.out.println(auvo+"컨틀롤러");
		return new ModelAndView("auction_board","auvo",auvo);
	}

	@RequestMapping("auction_showContent.ymv")
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
	public ModelAndView auctionBoardUpdate(AuctionBoardVO abvo){
		auctionBoardService.updateAuctionBoard(abvo);
		return new ModelAndView("redirect:auction_showContent.ymv?boardNo="+abvo.getBoardNo(),"abvo",abvo);
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
	public String auctionRegister(AuctionBoardVO abvo,PictureVO pvo){
		System.out.println("등록할 정보 입니다. " + abvo +"pvo 입니다  " + pvo);
		abvo.setEndDate(abvo.getEndDate());
		auctionBoardService.registerAuctionBoard(abvo);		
		ModelAndView mav = new ModelAndView();
		mav.addObject("abvo",abvo).addObject("pvo",pvo);
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
	public ModelAndView memberProfileUpdate(AuctionBoardVO abvo, PictureVO pvo) {
		auctionBoardService.registerPicture(pvo);
		return new ModelAndView("redirect:auction_show_content.ymv?boardNo="+abvo.getBoardNo());
	}

	@RequestMapping("auction_update_currentPrice.ymv")
	public ModelAndView updateCurrentPrice(AuctionBoardVO abvo) {
		auctionBoardService.updateCurrentPrice(abvo);
		return new ModelAndView("redirect:auction_showContent.ymv?boardNo="
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
