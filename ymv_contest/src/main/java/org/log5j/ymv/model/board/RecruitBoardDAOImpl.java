package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantListVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RecruitBoardDAOImpl implements RecruitBoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> findBoardList(String pageNo){
		System.out.println(pageNo+"   RecruitBoardDAOImpl  findBoardList pageno");
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findBoardList", pageNo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("recruitboard.totalContent");
	}

	@Override
	public BoardVO showContent(int recruitNo) {
		return (BoardVO)sqlSessionTemplate.selectOne("recruitboard.showContent",recruitNo);
	}

	@Override
	public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo){
	      return sqlSessionTemplate.selectOne("recruitboard.findRecruitBoardByRecruitNo",recruitNo);
	   }

	@Override
	public List<FieldVO> findFieldList() {
		List<FieldVO> list = sqlSessionTemplate.selectList("recruitboard.findFieldList");
		return list;
	}

	@Override
	public List<LocationVO> findLocationList() {
		List<LocationVO> list = sqlSessionTemplate.selectList("recruitboard.findLocationList");
		return list;
	}

	@Override
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo) {
		return sqlSessionTemplate.selectOne("recruitboard.findRecruitBoardByrecruitNo", recruitNo);
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		System.out.println("dao register volunterr"+rbvo);
		sqlSessionTemplate.insert("recruitboard.registerVolunteer",rbvo);
		
	}

	@Override
	public void updateBoard(BoardVO bvo) {
		sqlSessionTemplate.update("recruitboard.updateBoard",bvo);
		
	}

	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		sqlSessionTemplate.delete("recruitboard.deleteRecruitVolunteer",recruitNo);
	}

	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		sqlSessionTemplate.delete("member.deleteVoluntaryServiceApplicateNo",recruitNo);		
	}

	@Override
	public List<BoardVO> findCompanyBoardList(CompanyVO cpvo) {
		// TODO Auto-generated method stub
		System.out.println("DAOImpl : "+cpvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findCompanyBoardList",cpvo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalCompanyContent(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("recruitboard.totalCompanyContent",memberNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("recruitboard.deletePicture",pictureNo);
	}
	
	@Override
	public List<BoardVO> findNormalBoardList(CompanyVO cpvo) {
		System.out.println("DAOImpl : "+cpvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findNormalBoardList",cpvo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalNormalContent(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("recruitboard.totalNormalContent",memberNo);
	}

	@Override
	public void registerApplicantOK(ApplicantListVO alvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("applicant.registerApplicantOK",alvo);
	}

	@Override
	public List<ApplicantListVO> findApplicantOkList(int recruitNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("applicant.findApplicantOkList",recruitNo);
	}
	@Override
	public MemberVO findMailAddressByMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("applicant.findMailAddressByMemberNo", memberNo);
	}

	@Override
	public void registerConfirm(ConfirmVO confirmvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("applicant.registerConfirm",confirmvo);
	}

	@Override
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("applicant.registerConfirmBoard",confirmbvo);
	}

	@Override
	public void deleteVoluntaryApplicantOK(int recruitNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("applicant.deleteVoluntaryApplicantOK",recruitNo);
	}

	@Override
	public void deleteVoluntaryServiceApplicateByRecruitNo(int recruitNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("applicant.deleteVoluntaryServiceApplicateByRecruitNo",recruitNo);
	}

	@Override
	public List<BoardVO> findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO) {
		// TODO Auto-generated method stub
		List<BoardVO> list=sqlSessionTemplate.selectList("applicant.findConfirmBoardListByMemberNo",confirmPageVO);
		return list;
	}

	@Override
	public int totalContentConfirm(int memberNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("applicant.totalContentConfirm",memberNo);
	}
	
	@Override
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo){
		return sqlSessionTemplate.selectOne("applicant.findConfirmBoardByConfirm",cvo);
	}




}
