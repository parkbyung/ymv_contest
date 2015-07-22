package org.log5j.ymv.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.AuctionBoardService;
import org.log5j.ymv.model.board.AuctionBoardVO;
import org.log5j.ymv.model.board.BoardVO;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuctionBoardController {
	@Resource
	private AuctionBoardService auctionBoardService;
	@Resource(name="uploadPath")
	private String path;
	@RequestMapping("auctionTiles.ymv")
	@NoLoginCheck
	public String auctionTiles(){
		return "home";
	}
	@RequestMapping("auction_board.ymv")
	@NoLoginCheck
	public ModelAndView auctionBoard(String pageNo) {	
		ListVO lvo = auctionBoardService.findBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		return new ModelAndView("auction_board","lvo",lvo);
	}

	@RequestMapping("auction_showContent.ymv")
	@NoLoginCheck
	 public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView("auction_show_content");
		 int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		 System.out.println("auction_showContent boardNo: " + boardNo);
		 int pictureNo=boardNo;
		BoardVO 	abvo=auctionBoardService.findAuctionBoardByBoardNo(boardNo);
		PictureVO pvo=auctionBoardService.findPicture(pictureNo);
		if(pvo!=null){
			mv.addObject("pvo",pvo);
	    }
		System.out.println("showContent : "+abvo+" picture:"+pvo);
		 return mv.addObject("AuctionBoard", abvo);
}	
	@RequestMapping("auction_board_update_view.ymv")
	public ModelAndView auctionBoardUpdateView(int boardNo) {		
		AuctionBoardVO abvo = (AuctionBoardVO) auctionBoardService.findAuctionBoardByBoardNo(boardNo);
		abvo=auctionBoardService.setDate(abvo);		
		return new ModelAndView("auction_board_update_view","abvo",abvo);
	}

	@RequestMapping("auction_board_update.ymv")
	public ModelAndView auctionBoardUpdate(AuctionBoardVO abvo){
		abvo.setEndDate(abvo.getEndDate()+" "+abvo.getEndTime());
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
	@RequestMapping("auction_register.ymv")
	public ModelAndView auctionRegister(AuctionBoardVO abvo,PictureVO pvo){	
		abvo.setEndDate(abvo.getEndDate()+" "+abvo.getEndTime());
		System.out.println(abvo);
		auctionBoardService.registerAuctionBoard(abvo);		
		MultipartFile file=pvo.getFileName();
			String fileName="["+abvo.getBoardNo()+"]"+file.getOriginalFilename();			
			String filePath="upload\\"+fileName;
			pvo.setFilePath(filePath);
			pvo.setPictureNo(abvo.getBoardNo());
			if(!fileName.equals("")){
				try {
					file.transferTo(new File(path+fileName));
					// 픽쳐 디비에 파일정보 저장					
					auctionBoardService.registerPicture(pvo);
					/*nameList.add(fileName);*/
					} catch (Exception e) {					
					e.printStackTrace();
				}
			}
		return new ModelAndView("redirect:auction_board.ymv");
}
		@RequestMapping("auction_update_currentPrice.ymv")
		public ModelAndView updateCurrentPrice(AuctionBoardVO abvo){
			auctionBoardService.updateCurrentPrice(abvo);
			return new ModelAndView("redirect:auction_showContent.ymv?boardNo="+abvo.getBoardNo());
		}
	
}
