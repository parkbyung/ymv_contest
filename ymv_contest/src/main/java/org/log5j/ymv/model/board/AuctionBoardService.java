package org.log5j.ymv.model.board;


public interface AuctionBoardService {
	AuctionBoardVO findByAuctionNO(AuctionBoardVO vo);
	ListVO findBoardList(String pageNo);
	BoardVO findAuctionBoardByBoardNo(int boardNo);
	void updateAuctionBoard(AuctionBoardVO vo);
	void deleteAuctionBoard(String boardNo);
	void registerAuctionBoard(AuctionBoardVO vo);
	void registerPicture(PictureVO pvo);
	PictureVO findPicture(int pictureNo);
	void deletePicture(int pictureNo);	
	AuctionBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo);
	void updateCurrentPrice(AuctionBoardVO abvo);
	AuctionBoardVO setDate(AuctionBoardVO abvo);
	int updatePrice(AuctionBoardVO auvo);
	
}