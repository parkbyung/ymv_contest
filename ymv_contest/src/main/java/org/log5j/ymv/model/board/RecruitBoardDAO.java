package org.log5j.ymv.model.board;

import java.util.List;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;

public interface RecruitBoardDAO {
	public  List<BoardVO> findBoardList(String pageNo);
	public  int totalContent();
	public BoardVO showContent(int recruitNo);
	public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo);
	public List<FieldVO> findFieldList();
	public List<LocationVO> findLocationList();
	public void registerVolunteer(RecruitBoardVO rbvo);
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo);
	public void updateBoard(BoardVO bvo);
	public void deleteRecruitVolunteer(int recruitNo);
	public void deleteVoluntaryServiceApplicateNo(int recruitNo);
	public List<BoardVO> findCompanyBoardList(CompanyVO cpvo);
	public int totalCompanyContent(int memberNo);
	public void deletePicture(int pictureNo);
	public List<BoardVO> findNormalBoardList(CompanyVO cpvo);
	public int totalNormalContent(int memberNo);
	public void registerApplicantOK(ApplicantListVO alvo);
	public List<ApplicantListVO> findApplicantOkList(int recruitNo);
	public MemberVO findMailAddressByMemberNo(int memberNo);
	public void registerConfirm(ConfirmVO confirmvo);
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo);
	public List<BoardVO> findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO);
	public int totalContentConfirm(int memberNo);
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo);
}
