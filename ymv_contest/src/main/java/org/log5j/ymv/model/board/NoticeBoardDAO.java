package org.log5j.ymv.model.board;

import java.util.List;

public interface NoticeBoardDAO {
	List<BoardVO> findNoticeBoardList(String pageNo);
	int totalContent();
	void registerNoticeBoard(NoticeBoardVO vo);
	BoardVO findNoticeBoardByBoardNo(int boardNo);
	void noticeBoardUpdate(NoticeBoardVO vo);
	void noticeBoardDelete(String boardNo);
	void registerPicture(PictureVO pvo);
	PictureVO findPicture(int pictureNo);
	void deletePicture(int pictureNo);
	void updateHit(int boardNo);
}
