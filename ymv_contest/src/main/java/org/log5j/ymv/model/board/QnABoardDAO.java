package org.log5j.ymv.model.board;

import java.util.List;

public interface QnABoardDAO {
	
	public List<BoardVO> findQnABoardList(String pageNo);

	public  int totalContent();

	public void registerQnABoard(QnABoardVO qvo);

	public QnABoardVO findQnABoardByQnANo(int qnaNo);

	public void updateQnABoard(QnABoardVO qnABoardVO);

	public void deleteQnABoard(int qnaNo);

	public void updateRestep(int ref, int restep);

	public void replyQnABoard(QnABoardVO qvo);
	
	public void findQnABoardByQnaNoNotHit(int qnaNo);

	public void updateHit(int qnaNo);
}
