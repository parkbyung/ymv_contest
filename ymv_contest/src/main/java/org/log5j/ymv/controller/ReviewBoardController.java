package org.log5j.ymv.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.CommentVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.board.ReviewBoardService;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.log5j.ymv.model.upload.UploadPathService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
/**
 * 후기게시판
 * @author jjh
 *
 */
@Controller
public class ReviewBoardController {
	@Resource
	private ReviewBoardService reviewBoardService;
	@Resource
	private UploadPathService uploadPathService;
	@Resource
	private CookieService cookieService;

	@Resource(name="uploadReviewPath")
	private String reviewPath;
	
	@Resource(name="uploadNoticePath")
	private String noticePath;
	
	@Resource(name="uploadProfilePath")
	private String profilePath;
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : pageNo를 이용하여 해당하는 페이지의 후기 게시글과 페이지 정보를 반환한다. 
	 * @param pageNo : 현재 페이지 번호를 받아온다.
	 * @return
	 */
	@RequestMapping("review_board.ymv")
	@NoLoginCheck
	public ModelAndView reviewBoard(String pageNo) {	
		ListVO lvo = reviewBoardService.findReviewBoardList(pageNo);
		return new ModelAndView("review_board","lvo",lvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 쿠키를 사용하여 조회수를 개인당 한번만 허용하고 게시판 상세정보,사진정보,댓글 정보를 반환한다.
	 * @param request : boardNo를 받아오고 쿠키 정보를 받기 위해 사용
	 * @param response : 쿠키를 사용자에게 생성하기 위해 사용
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("review_showContent.ymv")
	@NoLoginCheck
	 public ModelAndView reviewShowContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView("review_show_content");
		 int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		 int pictureNo=boardNo;
		BoardVO bvo=null;
		Cookie[] cookies = request.getCookies();
		Cookie cookie = cookieService.cookieSerivce(cookies, boardNo,new NoticeBoardVO());
		response.addCookie(cookie);
		bvo=reviewBoardService.findReviewBoardByBoardNo(boardNo);
		List<CommentVO> commentList=reviewBoardService.findCommentListByBoardNo(request.getParameter("boardNo"));
		PictureVO pvo=reviewBoardService.findPicture(pictureNo);
		if(pvo!=null){
			mv.addObject("pvo",pvo);
	    }
		mv.addObject("rvo", bvo).addObject("commentList", commentList);
		 return mv;
}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : review 게시판에 작성한 댓글을 등록하고 해당 페이지로 다시 이동
	 * @param cmvo : 댓글의 정보를 받아오기 위해 사용(댓글번호,글번호,작성자,내용)
	 * @return
	 */
	@RequestMapping("register_review_comment.ymv")
	public String registerReviewComment(CommentVO cmvo){
		reviewBoardService.registerReviewComment(cmvo);
		return "redirect:review_showContent.ymv?boardNo="+cmvo.getBoardNo();
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 
	 * @param cmvo : 댓글의 정보를 받아오기 위해 사용(댓글 번호,글번호)
	 * @return
	 */
	@RequestMapping("delete_review_comment.ymv")
	public String deleteReviewComment(CommentVO cmvo){
		reviewBoardService.deleteReviewComment(cmvo);
		return "redirect:review_showContent.ymv?boardNo="+cmvo.getBoardNo();
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글 번호로 조회하고 게시글의 정보를 수정페이지(review_board_update_view.jsp)으로 반환한다.
	 * @param boardNo : 해당 게시글 번호를 받아오기위해 사용.
	 * @return
	 */
	@RequestMapping("review_board_update_view.ymv")
	public ModelAndView reviewBoardUpdateView(int boardNo) {
		ReviewBoardVO reviewbvo = (ReviewBoardVO) reviewBoardService.findReviewBoardByBoardNo(boardNo);
		return new ModelAndView("review_board_update_view","rvo",reviewbvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시물을 수정한 후 글번호를 이용해 redirect 사용하여 상세글보기로 이동
	 * @param rbvo : 후기게시글의 수정된 상세 정보를 받아옴.
	 * @return
	 */
	@RequestMapping("review_board_update.ymv")
	public ModelAndView reviewBoardUpdate(ReviewBoardVO rbvo){
		reviewBoardService.updateReviewBoard(rbvo);
		return new ModelAndView("redirect:review_showContent.ymv?boardNo="+rbvo.getBoardNo(),"rvo",rbvo);
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글을 삭제하는 메서드, 해당 글을 참조하고 있는 사진 및 댓글도 삭제한다.
	 * @param boardNo : 해당 게시판의 번호를 받아온다.
	 * @return
	 */
	@RequestMapping("review_board_delete.ymv")
	public ModelAndView reviewBoardDelete(String boardNo){
		reviewBoardService.deleteReviewBoard(boardNo);
		return new ModelAndView("redirect:review_board.ymv");
	}
	/**
	 * 
	 * 작성자 : 전진한
	 * 내용 : 게시글 작성 페이지로 이동한다.
	 * @return
	 */
	@RequestMapping("review_register_view.ymv")
	public ModelAndView reviewRegisterView(){
		return new ModelAndView("review_register_view");
	}
	/**
	 * 
	 * 작성자 : 전진한, 임영학
	 * 내용 : 입력받은 상세정보와 사진정보를 등록하는 메서드
	 * @param rbvo : 게시판의 상세 정보를 받아온다.
	 * @param pvo : 게시판의 사진정보를 받아온다.
	 * @return
	 */
	@RequestMapping("review_register.ymv")
	public ModelAndView reviewRegister(ReviewBoardVO rbvo,PictureVO pvo){
		reviewBoardService.registerReviewBoard(rbvo);
		PictureVO pictureVO = uploadPathService.registerReviewFilePath(rbvo,pvo);
		reviewBoardService.registerPicture(pictureVO);
		return new ModelAndView("redirect:review_board.ymv");
	}
}
