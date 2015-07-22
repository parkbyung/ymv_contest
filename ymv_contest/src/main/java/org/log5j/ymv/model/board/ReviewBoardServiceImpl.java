package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {
	@Resource
	private ReviewBoardDAO reviewBoardDAO;

	@Override
	public ReviewBoardVO findByReviewNo(ReviewBoardVO vo) {
		// TODO Auto-generated method stub
		return reviewBoardDAO.findByReviewNo(vo);
	}

	@Override
	public ListVO findReviewBoardList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = reviewBoardDAO.findReviewBoardList(pageNo);
		int total = reviewBoardDAO.totalContent();
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}

	@Override
	public BoardVO findReviewBoardByBoardNo(int boardNo) {
		return reviewBoardDAO.findReviewBoardByBoardNo(boardNo);
	}

	@Override
	public void registerReviewComment(CommentVO cmvo) {
		reviewBoardDAO.registerReviewComment(cmvo);
	}

	@Override
	public List<CommentVO> findCommentListByBoardNo(String boardNo) {
		return reviewBoardDAO.findCommentListByBoardNo(boardNo);
	}

	@Override
	public void deleteReviewComment(CommentVO cmvo) {
		reviewBoardDAO.deleteReviewComment(cmvo);
	}

	@Override
	public void updateReviewBoard(ReviewBoardVO vo) {
		reviewBoardDAO.updateReviewBoard(vo);
	}

	@Override
	public void deleteReviewBoard(String boardNo) {
		reviewBoardDAO.deleteReviewBoard(boardNo);
		reviewBoardDAO.deleteReviewBoardComment(boardNo);
		int pictureNo=Integer.parseInt(boardNo);
		reviewBoardDAO.deletePicture(pictureNo);
	}

	@Override
	public void deleteReviewBoardComment(String boardNo) {
		reviewBoardDAO.deleteReviewBoardComment(boardNo);
	}

	@Override
	public void registerReviewBoard(ReviewBoardVO vo) {
		reviewBoardDAO.registerReviewBoard(vo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		reviewBoardDAO.registerPicture(pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		return reviewBoardDAO.findPicture(pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		reviewBoardDAO.deletePicture(pictureNo);
	}

	@Override
	public ReviewBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo) {
		reviewBoardDAO.updateHit(boardNo);
		return (ReviewBoardVO) reviewBoardDAO.findReviewBoardByBoardNo(boardNo);
	}

}