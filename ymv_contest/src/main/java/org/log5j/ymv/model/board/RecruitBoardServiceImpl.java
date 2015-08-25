package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.springframework.stereotype.Service;
@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {
	@Resource(name="recruitBoardDAOImpl")
	private RecruitBoardDAO recruitBoardDAO;
	@Override
	public ListVO findBoardList(String pageNo){
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<BoardVO> list=recruitBoardDAO.findBoardList(pageNo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalContent();
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public BoardVO showContent(int no) {
		return recruitBoardDAO.showContent(no);
	}
	@Override
	public void updateBoard(BoardVO bvo) {
		recruitBoardDAO.updateBoard(bvo);
		
	}
	@Override
	public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo){
	      return recruitBoardDAO.findRecruitBoardByRecruitNo(recruitNo);
	   }
	@Override
	public List<FieldVO> findFieldList() {
		
		return recruitBoardDAO.findFieldList();
	}
	@Override
	public List<LocationVO> findLocationList() {
		
		return recruitBoardDAO.findLocationList();
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		recruitBoardDAO.registerVolunteer(rbvo);
	}
	
	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		recruitBoardDAO.deleteRecruitVolunteer(recruitNo);
	}
	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		recruitBoardDAO.deleteVoluntaryServiceApplicateNo(recruitNo);
	}
	@Override
	public ListVO findCompanyBoardList(CompanyVO cpvo) {
		// TODO Auto-generated method stub
		
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.findCompanyBoardList(cpvo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalCompanyContent(cpvo.getMemberNo());
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		recruitBoardDAO.deletePicture(pictureNo);
	}
	@Override
	public ListVO findNormalBoardList(CompanyVO cpvo) {
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.findNormalBoardList(cpvo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalNormalContent(cpvo.getMemberNo());
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}
	@Override
	public void registerApplicantOK(ApplicantListVO alvo) {
		recruitBoardDAO.registerApplicantOK(alvo);
	}
	@Override
	public List<ApplicantListVO> findApplicantOkList(int recruitNo) {
		// TODO Auto-generated method stub
		return recruitBoardDAO.findApplicantOkList(recruitNo);
	}
	@Override
	public MemberVO findMailAddressByMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return recruitBoardDAO.findMailAddressByMemberNo(memberNo);
	}
	@Override
	public void registerConfirm(ConfirmVO confirmvo) {
		// TODO Auto-generated method stub
		recruitBoardDAO.registerConfirm(confirmvo);
	}
	@Override
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo) {
		recruitBoardDAO.registerConfirmBoard(confirmbvo);
	}
	@Override
	public ListVO findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO) {
		// TODO Auto-generated method stub
		 if (confirmPageVO.getPageNo() == 0)
	         confirmPageVO.setPageNo(1);
	      List<BoardVO> list = recruitBoardDAO.findConfirmBoardListByMemberNo(confirmPageVO);
	      int total = recruitBoardDAO.totalContentConfirm(confirmPageVO.getMemberNo());
	      PagingBean paging = new PagingBean(total,confirmPageVO.getPageNo());
	      ListVO lvo = new ListVO(list, paging);
	      return lvo;
	}
	@Override
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo){
		return recruitBoardDAO.findConfirmBoardByConfirm(cvo);
	}

}
