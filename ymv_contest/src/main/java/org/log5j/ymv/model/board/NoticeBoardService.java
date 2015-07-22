package org.log5j.ymv.model.board;

public interface NoticeBoardService {

	ListVO findNoticeBoardList(String pageNo);

	void registerNoticeBoard(NoticeBoardVO vo);

	BoardVO findNoticeBoardByBoardNo(int boardNo);

	void noticeBoardUpdate(NoticeBoardVO vo);

	void noticeBoardDelete(String boardNo);

	void registerPicture(PictureVO pvo);

	PictureVO findPicture(int pictureNo);

	void deletePicture(int pictureNo);

	NoticeBoardVO findPostingByNoticeBoardNoUpdateHit(int boardNo);

	void findPostingByNoticeBoardNoNotHit(int boardNo);
}