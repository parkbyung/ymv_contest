package org.log5j.ymv.model.board;

public interface QnABoardService {

	public ListVO findQnABoardList(String pageNo);

	public void registerQnABoard(QnABoardVO qvo);

	public QnABoardVO findQnABoardByQnANo(int qnaNo);

	public void updateQnABoard(QnABoardVO qnABoardVO);

	public void deleteQnABoard(int qnaNo);

	public void replyQnABoard(QnABoardVO qvo);
	
	public void findQnABoardByQnaNoNotHit(int qnaNo);

	public QnABoardVO findQnABoardByQnaNoUpdateHit(int qnaNo);

}