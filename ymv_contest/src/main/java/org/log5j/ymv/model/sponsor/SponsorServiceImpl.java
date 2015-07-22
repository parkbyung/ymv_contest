package org.log5j.ymv.model.sponsor;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PagingBean;
import org.log5j.ymv.model.board.PictureVO;
import org.springframework.stereotype.Service;

@Service
public class SponsorServiceImpl implements SponsorService {
	@Resource
	private SponsorDAO sponsorDAO;

	@Override
	public ListVO findSponsorList(String pageNo){
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = sponsorDAO.findSponsorList( Integer.parseInt(pageNo));
		int total = sponsorDAO.totalSponsorContent();
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo),3);
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}
	
	@Override
	public void updateSponsorByBoardNo(SponsorVO spvo){
		sponsorDAO.updateSponsorByBoardNo(spvo);
	}

	@Override
	public void registerSponsor(SponsorVO spvo){
		sponsorDAO.registerSponsor(spvo);
	}

	@Override
	public void deleteSponsorByBoardNo(int boardNo){
		sponsorDAO.deleteSponsorByBoardNo(boardNo);
	}

	@Override
	public SponsorVO findSponsorByBoardNo(int boardNo) {
		return sponsorDAO.findSponsorByBoardNo(boardNo);
	}

	@Override
	public void updateSponsorCurrentPrice(SponsorVO spvo) {
		sponsorDAO.updateSponsorCurrentPrice(spvo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		sponsorDAO.registerPicture(pvo);
	}

	@Override
	public void deletePicture(int boardNo) {
		sponsorDAO.deletePicture(boardNo);
	}

	@Override
	public List<PictureVO> findPictureList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<PictureVO> pvo=sponsorDAO.findPictureList(Integer.parseInt(pageNo));
		return pvo;
	}
}
