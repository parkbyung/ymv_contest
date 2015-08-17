package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

@Service
public class AuctionBoardServiceImpl implements AuctionBoardService {
@Resource
private AuctionBoardDAO auctionBoardDAO;

@Override
public AuctionBoardVO findByAuctionNO(AuctionBoardVO vo){
	return auctionBoardDAO.findByAuctionNO(vo);
}

@Override
public ListVO findBoardList(String pageNo) {
	if (pageNo == null || pageNo == "")
		pageNo = "1";
	List<BoardVO> list =auctionBoardDAO.findBoardList(pageNo);
	int total = auctionBoardDAO.totalContent();
	PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
	ListVO lvo = new ListVO(list, paging);
	return lvo;
}

@Override
public BoardVO findAuctionBoardByBoardNo(int boardNo) {
	return auctionBoardDAO.findAuctionBoardByBoardNo(boardNo);
}


@Override
public void updateAuctionBoard(AuctionBoardVO vo) {
	auctionBoardDAO.auctionBoardUpdate(vo);
}

@Override
public void deleteAuctionBoard(String boardNo) {
	auctionBoardDAO.auctionBoardDelete(boardNo);
}



@Override
public void registerAuctionBoard(AuctionBoardVO abvo) {
	auctionBoardDAO.registerAuctionBoard(abvo);
}

@Override
public void registerPicture(PictureVO pvo) {
	auctionBoardDAO.registerPicture(pvo);
}

@Override
public PictureVO findPicture(int pictureNo) {
	return auctionBoardDAO.findPicture(pictureNo);
}

@Override
public void deletePicture(int pictureNo) {
	// TODO Auto-generated method stub
	auctionBoardDAO.deletePicture(pictureNo);
}

@Override
public AuctionBoardVO getPostingByNoticeBoardNoUpdateHit(int boardNo) {
	auctionBoardDAO.updateHit(boardNo);
	return (AuctionBoardVO) auctionBoardDAO.findAuctionBoardByBoardNo(boardNo);
}

@Override
public void updateCurrentPrice(AuctionBoardVO abvo) {
	auctionBoardDAO.updateCurrentPrice(abvo);
}
@Override
public AuctionBoardVO setDate(AuctionBoardVO abvo) {      
      String EndDate[] = abvo.getEndDate().split(" ");
      abvo.setEndDate(EndDate[0]);
      abvo.setEndTime(EndDate[1]);
      return abvo;
   }

@Override
public int updatePrice(AuctionBoardVO auvo) {
	auctionBoardDAO.updateCurrentPrice(auvo);
	auctionBoardDAO.findAuctionBoardByBoardNo(auvo.getBoardNo());
	int NewPrice = auvo.getCurrentPrice();
	return NewPrice;
}

@Override
public void updatePicture(PictureVO pvo) {
	auctionBoardDAO.updatePicture(pvo);
	
}





}




























