package org.log5j.ymv.model.board;

import java.util.List;

public interface AuctionBoardDAO {
	AuctionBoardVO findByAuctionNO(AuctionBoardVO vo);

	List<BoardVO> findBoardList(String pageNo);

	int totalContent();

	BoardVO findAuctionBoardByBoardNo(int boardNo);

	void auctionBoardUpdate(AuctionBoardVO vo);

	void auctionBoardDelete(String boardNo);

	void registerAuctionBoard(AuctionBoardVO vo);

	void registerPicture(PictureVO pvo);

	PictureVO findPicture(int pictureNo);

	void deletePicture(int pictureNo);

	void updateHit(int boardNo);

	void updateCurrentPrice(AuctionBoardVO abvo);
}