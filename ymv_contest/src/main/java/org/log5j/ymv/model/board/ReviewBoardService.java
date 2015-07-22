package org.log5j.ymv.model.board;

import java.util.List;

public interface ReviewBoardService {

	ReviewBoardVO findByReviewNo(ReviewBoardVO vo);

	ListVO findReviewBoardList(String pageNo);

	BoardVO findReviewBoardByBoardNo(int boardNo);

	void registerReviewComment(CommentVO cmvo);

	List<CommentVO> findCommentListByBoardNo(String string);

	void deleteReviewComment(CommentVO cmvo);

	void updateReviewBoard(ReviewBoardVO vo);

	void deleteReviewBoardComment(String boardNo);

	void deleteReviewBoard(String boardNo);

	void registerReviewBoard(ReviewBoardVO vo);

	void registerPicture(PictureVO pvo);

	PictureVO findPicture(int pictureNo);

	void deletePicture(int pictureNo);
	
	ReviewBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo);

}