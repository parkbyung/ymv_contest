package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionBoardDAOImpl implements AuctionBoardDAO  {
@Resource
private SqlSessionTemplate sqlSessionTemplate;

@Override
public AuctionBoardVO findByAuctionNO(AuctionBoardVO vo){
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.findByAuctionNo", vo.getBoardNo());	
}

@Override
public List<BoardVO> findBoardList(String pageNo){
	// TODO Auto-generated method stub
	List<BoardVO> list=sqlSessionTemplate.selectList("auctionBoard.findBoardList",Integer.parseInt(pageNo));
	return list;
}

@Override
public int totalContent(){
	return sqlSessionTemplate.selectOne("auctionBoard.totalContent");	
}

@Override
public BoardVO findAuctionBoardByBoardNo(int boardNo){
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.findAuctionBoardByBoardNo",boardNo);	
}





@Override
public void auctionBoardUpdate(AuctionBoardVO vo) {
	sqlSessionTemplate.update("auctionBoard.auctionBoardUpdate",vo);
}

@Override
public void auctionBoardDelete(String boardNo) {
	sqlSessionTemplate.delete("auctionBoard.auctionBoardDelete",Integer.parseInt(boardNo));
}


@Override
public void registerAuctionBoard(AuctionBoardVO vo) {
	System.out.println("DAO"+vo);
	sqlSessionTemplate.insert("auctionBoard.registerAuctionBoard",vo);
}

@Override
public void registerPicture(PictureVO pvo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.insert("auctionBoard.registerPicture",pvo);
}

@Override
public PictureVO findPicture(int pictureNo) {
	// TODO Auto-generated method stub
	return sqlSessionTemplate.selectOne("auctionBoard.findPicture",pictureNo);
}

@Override
public void deletePicture(int pictureNo) {
	// TODO Auto-generated method stub
	sqlSessionTemplate.delete("auctionBoard.deletePicture",pictureNo);
}

@Override
public void updateHit(int boardNo) {
	sqlSessionTemplate.update("auctionBoard.updateHit",boardNo);	
}

@Override
public void updateCurrentPrice(AuctionBoardVO abvo) {
	sqlSessionTemplate.update("auctionBoard.updateCurrentPrice",abvo);
}

@Override
public void updatePrice(int boardNo) {
	sqlSessionTemplate.update("auctionBoard.updatePrice",boardNo);
	
}

@Override
public void updatePicture(PictureVO pvo) {
	sqlSessionTemplate.update("auctionBoard.updatePicture",pvo);
}


}


































