package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.QnABoardService;
import org.log5j.ymv.model.board.QnABoardVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.log5j.ymv.model.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * QnA 게시판-목록/수정/삭제/답글
 * @author KOSTA
 *
 */
@Controller
public class QnABoardController {
	@Resource(name="qnABoardServiceImpl")
	private QnABoardService qnABoardService;
	@Resource
	private CookieService cookieService;

/**
 * 
 *@param pageNo : 페이지번호를 받아온다.
 *@return ListVO:  페이지 번호에 해당하는 목록 list 를 return 한다.
 *@작성자 : 장지윤
 *@Method설명 : 페이지 번호를 받아와 해당하는 리스트를 뽑아 
 *qna_board.jsp로 보내준다.
 */
	@RequestMapping("qna_board.ymv")
	@NoLoginCheck
	public ModelAndView qnaBoard(String pageNo) {	
		ListVO lvo=qnABoardService.findQnABoardList(pageNo);
		return new ModelAndView("qna_board","lvo",lvo);
	}
/**
 * 	
 *@param request : 로그인 한 상태여야 글쓰기가 가능
 *@return :  null
 *@작성자 : 장지윤
 *@Method설명 : 글쓰는 뷰 jsp로 이동하기 위한 컨트롤러
 */
	@RequestMapping("qna_register_view.ymv")
	public ModelAndView qnaRegisterView(){
		return new ModelAndView("qna_register_view");
	}
/**
 * 	
 *@param request :  로그인 세션 받아온다.
 *@return qnaNo:  등록할 글을 상세글보기로 보여주기위해 qna 번호를 보낸다.
 *@작성자 : 장지윤
 *@Method설명 :제목,내용 등 적은 것들을 컨트롤러로 보내 
 *세션에 남아있는 회원의 이름,번호를 QnAVO에 set하여 등록하는 서비스로 전송한다.
 *그리고 저장된 게시판 번호를 상세글보기로 보내준다.
 */
	@RequestMapping("qna_register.ymv")
	public String qnaRegister(HttpServletRequest request,QnABoardVO qvo){
		HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		qvo.setWriter(mvo.getName());
		qvo.setMemberNo(mvo.getMemberNo());
		qnABoardService.registerQnABoard(qvo);
		return "redirect:qna_showContent.ymv?qnaNo=" + qvo.getQnaNo();
	}
/**
 * 
 *@param request :게시물 번호를 받아온다.
 *@return QnABoardVO:  상세글보기로 넘어가기 위해 qna를 보낸다
 *@작성자 : 장지윤
 *@Method설명 : 게시물 번호를 통해 게시물이 조회된 적이 있는지 
 *쿠키를 통해 확인을 한다. 조회된 적이 있다면 조회수를 높이고 그렇지 않다면 
 *조회수를 그대로 둔다. (쿠키 유무) 그리고 상세글보기로 qna를 넘겨준다
 */
	@RequestMapping("qna_showContent.ymv")
	@NoLoginCheck
	public ModelAndView qnaShowContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qnaNo=Integer.parseInt(request.getParameter("qnaNo"));
		QnABoardVO qvo = null;
		Cookie[] cookies = request.getCookies();
		Cookie cookie = cookieService.cookieSerivce(cookies, qnaNo,
				new QnABoardVO());
		response.addCookie(cookie);
		qvo = qnABoardService.findQnABoardByQnANo(qnaNo);
		return new ModelAndView("qna_show_content", "qvo", qvo);
	}
/**
 * 	
 *@param request :글 등록한 자와 session에 있는 멤버가 같을 때 수정 가능
 *@param qnaNo: 글번호를 가져와 해당하는 qvo를 받는다.
 *@return QnABoardVO: 수정폼으로 qvo를 보낸다.
 *@작성자 : 장지윤
 *@Method설명 : 수정할 글의 번호를 가지고 컨트롤러로 온다.
 *번호에 해당하는 글 요소들을 수정폼.jsp로 보내준다.
 */
	@RequestMapping("qna_board_update_view.ymv")
	   public ModelAndView qnaBoardUpdateView(int qnaNo) {
	  QnABoardVO qvo = (QnABoardVO) qnABoardService.findQnABoardByQnANo(qnaNo);
	  return new ModelAndView("qna_board_update_view","qvo",qvo);
	}
/**
 * 
 *@param QnABoardVO : 수정한 qvo를 가져온다.
 *@return :  수정된 글을 상세글보기로 보여주기 위해 qnaNo를 보낸다
 *@작성자 : 장지윤
 *@Method설명 :수정할 글을 서비스의 update를 이용해 수정하고 
 *글번호를 상세 글을 볼 수 있는 컨트롤러로 전송한다.
 */
	@RequestMapping("qna_board_update.ymv")
	   public ModelAndView qnaBoardUpdate(HttpServletRequest request, QnABoardVO qnABoardVO) {
	      System.out.println("수정받은 qnABoardVO "+qnABoardVO);
	      qnABoardService.updateQnABoard(qnABoardVO);
	      int qnaNo=qnABoardVO.getQnaNo();
	      QnABoardVO qvo=qnABoardService.findQnABoardByQnANo(qnaNo);
	      System.out.println("Qvo1234:"+qvo);
	      return new ModelAndView("qna_show_content","qvo",qvo);
	   }
/**
 * 	
 *@param request :글 등록한 자와 session에 있는 멤버가 같을 때 삭제 가능
 *@return :  페이지 번호를 글목록 jsp로 보내준다.
 *@작성자 : 장지윤
 *@Method설명 :삭제할 글 번호를 받아와  delete 서비스를 통해 삭제하고 
 * pageNo와 함께 qna_board로 이동한다
 */
	@RequestMapping("qna_delete.ymv")
	public ModelAndView qnaDelete(HttpServletRequest request) {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));		
		qnABoardService.deleteQnABoard(qnaNo);
		return new ModelAndView("redirect:/qna_board.ymv?pageNo=1");
	}
/**
 * 	
 *@param request :session이 관리자일 때만 답글을 등록할 수 있도록 되어있다.
 *@return  QnABoardVO: qna번호로 가져온다.
 *@작성자 : 장지윤
 *@Method설명 :답글 폼으로 이동하기 위해 qna번호를 통해 qna글을 
 *가져온다.
 */
	@RequestMapping("qna_reply_view.ymv")
	public ModelAndView qnaReplyView(QnABoardVO qvo) {
		qvo = qnABoardService.findQnABoardByQnANo(qvo.getQnaNo());
		return new ModelAndView("qna_reply_view", "qvo", qvo);
	}
/**
 * 	
 *@param MemberVO : session에 있는 관리자의 번호와 이름을 가져온다.
 *@param QnABoardVO : qna_reply_view에서 가져온 글제목과	
 *관리자가 입력한 글내용과 시간을 가져온다.
 *@return :  관리자가 입력한 글을 상세글보기 컨트롤러로 보내기 위해 qnaNo를 보낸다.
 *@작성자 : 장지윤
 *@Method설명 : 세션에 있는 멤버정보와 멤버가 적은 글 정보를 답글로 insert한다.
 *그 후 글번호를 통해 상세글보기로 이동한다.
 */
	@RequestMapping("qna_reply.ymv")
	public ModelAndView qnaReply(HttpServletRequest request,QnABoardVO qvo) throws Exception{		
		HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)session.getAttribute("mvo");
		qvo.setMemberNo(mvo.getMemberNo());
		qvo.setWriter(mvo.getName());
		qnABoardService.replyQnABoard(qvo);
		return new ModelAndView("redirect:/qna_showContent.ymv?qnaNo="+qvo.getQnaNo());
	}
	
}
