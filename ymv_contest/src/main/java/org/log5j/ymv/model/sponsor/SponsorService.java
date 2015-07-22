package org.log5j.ymv.model.sponsor;

import java.util.List;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PictureVO;

public interface SponsorService {

	public abstract ListVO findSponsorList(String pageNo);

	public abstract void updateSponsorByBoardNo(SponsorVO spvo);

	public abstract void registerSponsor(SponsorVO spvo);

	public abstract void deleteSponsorByBoardNo(int boardNo);

	public abstract SponsorVO findSponsorByBoardNo(int boardNo);

	public abstract void updateSponsorCurrentPrice(SponsorVO spvo);

	public abstract void registerPicture(PictureVO pvo);

	public abstract void deletePicture(int boardNo);

	public abstract List<PictureVO> findPictureList(String pageNo);

}