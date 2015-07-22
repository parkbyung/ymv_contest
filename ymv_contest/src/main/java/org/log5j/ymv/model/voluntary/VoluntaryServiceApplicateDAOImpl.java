package org.log5j.ymv.model.voluntary;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoluntaryServiceApplicateDAOImpl implements VoluntaryServiceApplicateDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 글번호, 회원번호, 신청사유를 가져와 봉사활동 신청자DB에 insert 한다.
	 * @param vsavo : 글 번호, 회원번호, 신청사유를 같이 담기 위해 사용
	 */
	@Override
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo) {
		sqlSessionTemplate.insert("member.registerVoluntaryApplicant",vsavo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 글번호와 회원번호가 일치하는 봉사 신청자의 수를 반환한다.
	 * @param map : vsavo에 글번호와 회원번호를 담아주기 위해서 사용
	 * @return Integer : 글번호와 회원번호가 일치하는 봉사 신청자의 수 반환
	 */
	@Override
	public Integer checkVolunteerApplicant(Map<String,Object> map) {
		System.out.println("checkVolunteerApplicant - dao");
		/*VoluntaryServiceApplicateVO vsvo = new VoluntaryServiceApplicateVO();
		vsvo.setRecruitNo(recruitNo);
		vsvo.setMemberNo(memberNo);
		System.out.println(vsvo);*/
		System.out.println("map   "+map);
		return sqlSessionTemplate.selectOne("member.checkVolunteerApplicant",map);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 현재 글번호에 해당하는 글에 봉사 신청을 한 사람들의 
	 * 				회원번호, 신청사유, id, 이름, 메일주소 등을 반환해 List에 담는다.
	 * @param recruitNo : 현재 글번호에 해당하는 글에 봉사 신청을 한 회원의 정보를 찾기위해 사용
	 * @return List
	 */
	@Override
	public List<ApplicantListVO> findApplicantList(int recruitNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("applicant.findApplicantList",recruitNo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 해당 글번호와 회원번호에 일치하는 회원을 신청자 리스트DB에서 삭제한다.
	 * @param alvo : 글번호, 회원번호, 신청사유, id, 이름, 메일주소등을 같이 담기위해 사용
	 */
	@Override
	public void deleteApplicant(ApplicantListVO alvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("applicant.deleteApplicant",alvo);
	}

}
