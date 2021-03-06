package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardService;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @작성자 : 임영학
 * @내용 : 공지사항을 관리하는 컨트롤러
 *
 */
@Controller
public class NoticeBoardController {
	@Resource
	private CookieService cookieService;
	@Resource
	private NoticeBoardService noticeBoardService;
	
	/**
	 * 
	 * @작성자 : 임영학
	 * @내용 : Board DB에서 공지사항 게시글을 조회하고 넘겨받은 
	 * pageNo를 통해 페이징 처리를 하여 notice_board.jsp 로 보내준다.
	 *
	 * @param pageNo
	 * @return 
	 */
	@RequestMapping("notice_board.ymv")
	@NoLoginCheck
	public ModelAndView noticeBoard(String pageNo) {	
		ListVO lvo = noticeBoardService.findNoticeBoardList(pageNo);
		return new ModelAndView("notice_board","lvo",lvo);
	}
	/**
	 * 
	 * @작성자 : 임영학
	 * @내용 : NoticeBoard 글을 등록하기 위한 글 입력폼을 제공하기 위해 notice_register_view.jsp 로 보내준다.
	 *
	 * @return
	 */
   @RequestMapping("notice_register_view.ymv")
   public ModelAndView noticeRegisterView(){
	   return new ModelAndView("notice_register_view");
   }
   /**
    * 
    * @작성자 : 임영학
    * @내용 : notice_register_view.jsp 에서 전달받은 공지사항 글 정보를 Board DB에 insert한다. 
    * 사진 업로드가 필요할 경우 사진을 지정한 경로에 업로드 시키고 그 경로와  Picture DB에 저장한다. 
    *
    * @param vo 
    * @param pvo 
    * @return
    */
   @RequestMapping("notice_register.ymv")
   public String noticeRegister(NoticeBoardVO nvo,PictureVO pvo){
	   noticeBoardService.registerNoticeBoard(nvo);
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("nvo",nvo).addObject("pvo",pvo);
	   return "forward:upload_notice_path.ymv";
   }
	/**
	 * 
	 * 작성자 : 박병준
	 * 내용 : UploadPathController로 부터 받은 PictureVO 정보를 통해 File을 업로드해준다.
	 * @param pvo : 업로드하기 위한 기초 정보
	 * @return
	 */
   @RequestMapping("notice_register_file.ymv")
   public ModelAndView noticeRegisterPicture(PictureVO pvo){
	   noticeBoardService.registerPicture(pvo);
	   return new ModelAndView("redirect:notice_board.ymv");
   }
   /**
    * 
    * @작성자 : 임영학
    * @내용 : 게시글 번호를 전달받아 번호에 해당하는 게시글을 board DB에서 조회한다.
    * 쿠키가 존재하지 않으면 조회수를 증가시키고 
    * 쿠키가 존재하면 조회수를 증가시키지 않는다.
    * 게시글 번호에 해당하는 PictureNo로 Picture DB를 조회하여 사진이 존재하는 경우 사진의 경로를 받아주고
    * notice_show_context.jsp 로 보내준다.
    *
    * @param request
    * @param response
    * @return
    * @throws Exception
    */
   @RequestMapping("notice_showContent.ymv")
   @NoLoginCheck
   public ModelAndView noticeShowContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		 int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		 int pictureNo=boardNo;
		BoardVO bvo=null;
		Cookie[] cookies = request.getCookies();
		Cookie cookie = cookieService.cookieSerivce(cookies, boardNo,
				new NoticeBoardVO());
		response.addCookie(cookie);
		bvo=noticeBoardService.findNoticeBoardByBoardNo(boardNo);//vo = BoardDAO.getInstance().getPostingByNo(boardNo);
		PictureVO pvo=noticeBoardService.findPicture(pictureNo);
		if(pvo!=null){
			mv.addObject("pvo",pvo);
	    }
		mv.addObject("rvo", bvo);
		mv.setViewName("notice_show_content");
		 return mv;
   }
	
   /**
    * 
    * @작성자 : 임영학
    * @내용 : 게시글 번호에 해당하는 글 정보를 notice_board_update_view 로 보내준다.
    *
    * @param boardNo
    * @return
    */
   @RequestMapping("notice_board_update_view.ymv")
	public ModelAndView noticeBoardUpdateView(int boardNo) {
		NoticeBoardVO noticebvo = (NoticeBoardVO) noticeBoardService.findNoticeBoardByBoardNo(boardNo);
		return new ModelAndView("notice_board_update_view","rvo"
				,noticebvo);
	}
   /**
    * 
    * @작성자 : 임영학
    * @내용 : 전달받은 업데이트 글 정보를 board DB에 update 시켜주고 notice_showContent.ymv 로 redirect 처리하여 보내준다.
    *
    * @param vo
    * @return
    */
   @RequestMapping("notice_board_update.ymv")
	public ModelAndView noticeBoardUpdate(NoticeBoardVO vo){
		ModelAndView mv=new ModelAndView();
		noticeBoardService.noticeBoardUpdate(vo);
		mv.setViewName("redirect:notice_showContent.ymv?boardNo="+vo.getBoardNo());
		mv.addObject("rvo", vo);
		return mv;
	}
   
   /**
    * 
    * @작성자 : 임영학
    * @내용 : 전달받은 게시글 번호로 board DB의 데이터를 삭제한 뒤 notice_board.ymv 로 redirect 처리하여 보내준다.
    *
    * @param boardNo
    * @return
    */
   @RequestMapping("notice_board_delete.ymv")
	public ModelAndView noticeBoardDelete(String boardNo){
		noticeBoardService.noticeBoardDelete(boardNo);
		int pictureNo=Integer.parseInt(boardNo);
		noticeBoardService.deletePicture(pictureNo);
		return new ModelAndView("redirect:notice_board.ymv");
	}
}
