package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<BoardVO> findNoticeBoardList(String pageNo) {
		// TODO Auto-generated method stub
		List<BoardVO> list=sqlSessionTemplate.selectList("noticeBoard.findNoticeBoardList",Integer.parseInt(pageNo));
		System.out.println("DAOImpl list: "+ list);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("noticeBoard.totalContent");
	}

	@Override
	public void registerNoticeBoard(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("noticeBoard.registerNoticeBoard",vo);
	}

	@Override
	public BoardVO findNoticeBoardByBoardNo(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("noticeBoard.findNoticeBoardByBoardNo",boardNo);
	}

	@Override
	public void noticeBoardUpdate(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("noticeBoard.noticeBoardUpdate",vo);
	}

	@Override
	public void noticeBoardDelete(String boardNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("noticeBoard.noticeBoardDelete",boardNo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("noticeBoard.registerPicture",pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("noticeBoard.findPicture",pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("noticeBoard.deletePicture",pictureNo);
	}
	


	@Override
	public void updateHit(int boardNo) {
		sqlSessionTemplate.update("noticeBoard.updateHit", boardNo);
		
	}


}
