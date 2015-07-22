package org.log5j.ymv.model.board;

import java.util.List;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;

public interface RecruitBoardService {
	public ListVO findBoardList(String pageNo);
	public BoardVO showContent(int no);
	public void updateBoard(BoardVO bvo);
	 public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo);
	public List<FieldVO> findFieldList();
	public List<LocationVO> findLocationList();
	public void registerVolunteer(RecruitBoardVO rbvo);
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo);
	public void deleteRecruitVolunteer(int recruitNo);
	public void deleteVoluntaryServiceApplicateNo(int recruitNo);
	public ListVO findCompanyBoardList(CompanyVO cpvo);
	public void deletePicture(int pictureNo);
	public ListVO findNormalBoardList(CompanyVO cpvo);
	public void registerApplicantOK(ApplicantListVO alvo);
	public List<ApplicantListVO> findApplicantOkList(int recruitNo);
	public MemberVO findMailAddressByMemberNo(int memberNo);
	public void registerConfirm(ConfirmVO confirmvo);
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo);
	public void deleteVoluntaryApplicantOK(int recruitNo);
	public void deleteVoluntaryServiceApplicateByRecruitNo(int recruitNo);
	public ListVO findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO);
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo);
	public RecruitBoardVO setDate(RecruitBoardVO recruitbvo);
}
