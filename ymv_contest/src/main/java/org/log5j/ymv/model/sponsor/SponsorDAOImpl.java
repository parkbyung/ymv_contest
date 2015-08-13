package org.log5j.ymv.model.sponsor;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SponsorDAOImpl implements SponsorDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<BoardVO> findSponsorList(int pageNo){
		return sqlSessionTemplate.selectList("sponsor.findSponsorList",pageNo);
	}

	@Override
	public void updateSponsorByBoardNo(SponsorVO spvo){
		sqlSessionTemplate.update("sponsor.updateSponsorByBoardNo",spvo);
	}

	@Override
	public void registerSponsor(SponsorVO spvo){
		System.out.println("sponsorDAO-spvo:"+spvo);
		sqlSessionTemplate.insert("sponsor.registerSponsor",spvo);
	}

	@Override
	public void deleteSponsorByBoardNo(int boardNo){
		sqlSessionTemplate.delete("sponsor.deleteSponsorByBoardNo",boardNo);
	}

	@Override
	public int totalSponsorContent() {
		return sqlSessionTemplate.selectOne("sponsor.totalSponsorContent");
	}

	@Override
	public SponsorVO findSponsorByBoardNo(int boardNo) {
		return sqlSessionTemplate.selectOne("sponsor.findSponsorByBoardNo",boardNo);
	}

	@Override
	public void updateSponsorCurrentPrice(SponsorVO spvo) {
		sqlSessionTemplate.update("sponsor.updateSponsorCurrentPrice",spvo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		sqlSessionTemplate.insert("sponsor.registerPicture",pvo);
	}

	@Override
	public void deletePicture(int boardNo) {
		sqlSessionTemplate.delete("sponsor.deletePicture",boardNo);
	}

	@Override
	public List<PictureVO> findPictureList(int pageNo) {
		return sqlSessionTemplate.selectList("sponsor.findPictureList",pageNo);
	}

	@Override
	public void updatePicture(PictureVO pvo) {
		sqlSessionTemplate.update("sponsor.updatePicture",pvo);
	}
}
