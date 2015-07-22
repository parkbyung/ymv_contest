package org.log5j.ymv.model.board;

import java.util.List;

public interface ReviewBoardDAO {
	ReviewBoardVO findByReviewNo(ReviewBoardVO vo);
	List<BoardVO> findReviewBoardList(String pageNo);
	int totalContent();
	BoardVO findReviewBoardByBoardNo(int boardNo);
	void registerReviewComment(CommentVO cmvo);
	List<CommentVO> findCommentListByBoardNo(String boardNo);
	void deleteReviewComment(CommentVO cmvo);
	void updateReviewBoard(ReviewBoardVO vo);
	void deleteReviewBoard(String boardNo);
	void deleteReviewBoardComment(String boardNo);
	void registerReviewBoard(ReviewBoardVO vo);
	void registerPicture(PictureVO pvo);
	PictureVO findPicture(int pictureNo);
	void deletePicture(int pictureNo);
	void updateHit(int boardNo);
}
