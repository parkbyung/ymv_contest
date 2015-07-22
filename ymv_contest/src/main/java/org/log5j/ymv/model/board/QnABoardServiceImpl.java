package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class QnABoardServiceImpl implements QnABoardService {
	@Resource(name="qnABoardDAOImpl")
	private QnABoardDAO qnABoardDAO;
	@Override
	public ListVO findQnABoardList(String pageNo) {
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<BoardVO> list=qnABoardDAO.findQnABoardList(pageNo);
		int total=qnABoardDAO.totalContent();
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		ListVO lvo=new ListVO(list,paging);
		return lvo;
	}
	@Override
	public void registerQnABoard(QnABoardVO qvo){
		qnABoardDAO.registerQnABoard(qvo);
	}
	@Override
	public QnABoardVO findQnABoardByQnANo(int qnaNo){
		return qnABoardDAO.findQnABoardByQnANo(qnaNo);
	}
	@Override
	public void updateQnABoard(QnABoardVO qnABoardVO){
		qnABoardDAO.updateQnABoard(qnABoardVO);
	}
	@Override
	public void deleteQnABoard(int qnaNo){
		qnABoardDAO.deleteQnABoard(qnaNo);
	}
	@Override
	public void replyQnABoard(QnABoardVO qvo){
		int ref = qvo.getRef();
		int restep = qvo.getRestep();
		int relevel = qvo.getRelevel();
		qnABoardDAO.updateRestep(ref, restep);
		//update 처리 후
		//원본 글의 것보다 restep과 relevel이 1씩 커야 하므로
		//입력 전에 restep값 과 relevel의 값을 1씩 증가하여 insert시킨다.
		qvo.setRestep(restep+1);
		qvo.setRelevel(relevel+1);
		qnABoardDAO.replyQnABoard(qvo);//답변 글 입력								
	}
	
	@Override
	public void findQnABoardByQnaNoNotHit(int qnaNo) {
		// TODO Auto-generated method stub
		qnABoardDAO.findQnABoardByQnaNoNotHit(qnaNo);
	}
	@Override
	public QnABoardVO findQnABoardByQnaNoUpdateHit(int qnaNo) {
		qnABoardDAO.updateHit(qnaNo);
		return qnABoardDAO.findQnABoardByQnANo(qnaNo);
	}
}
