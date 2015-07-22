package org.log5j.ymv.model.voluntary;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class VoluntaryServiceApplicateServiceImpl implements VoluntaryServiceApplicateService {
	@Resource(name="voluntaryServiceApplicateDAOImpl")
	private VoluntaryServiceApplicateDAO voluntaryServiceApplicateDAO;
	
	/**
	 * 작성자 : 백지영
	 * 내용 : voluntaryServiceApplicateDAO에서 registerVolunteerApplicant를 수행한 값을 return한다.
	 * 				글번호, 회원번호, 신청사유를 가져와 봉사활동 신청자DB에 insert 한다.
	 * @param vsavo : 글 번호, 회원번호, 신청사유를 같이 담기 위해 사용
	 */
	@Override
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo) {
		System.out.println("register service 시작" + vsavo);
		voluntaryServiceApplicateDAO.registerVolunteerApplicant(vsavo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 글번호와 회원번호를 map에 담아 
	 * 				voluntaryServiceApplicateDAO에서 checkVolunteerApplicant를 수행한 값을 return 한다. 
	 * 				만약 checkVolunteerApplicant를 수행한 값이 0보다 크면 true를 반환하고
	 * 				0이거나 0보다 작으면 false를 반환한다.
	 * @param recruitNo
	 * @param memberNo
	 * @return boolean : 글번호와 회원번호가 일치하는 봉사 신청자가 있는지 없는지 확인하기 위해 사용
	 */
	@Override
	public boolean checkVolunteerApplicant(int recruitNo, int memberNo) {
		System.out.println("checkVolunteerApplicant - service");
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("recruitNo", recruitNo);
		map.put("memberNo", memberNo);
		System.out.println("map   "+map);
		int count=voluntaryServiceApplicateDAO.checkVolunteerApplicant(map);
		System.out.println("service    check  "+count);
		boolean flag=false;
		if(count>0)
			flag=true;
		return flag;
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : voluntaryServiceApplicateDAO에서 findApplicantList를 수행한 값을 return한다.
	 * 				현재 글번호에 해당하는 글에 봉사 신청을 한 사람들의 
	 * 				회원번호, 신청사유, id, 이름, 메일주소 등을 반환해 List에 담는다.
	 * @param recruitNo : 현재 글번호에 해당하는 글에 봉사 신청을 한 회원의 정보를 찾기위해 사용
	 * @return List
	 */
	@Override
	public List<ApplicantListVO> findApplicantList(int recruitNo) {
		// TODO Auto-generated method stub
		return voluntaryServiceApplicateDAO.findApplicantList(recruitNo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : voluntaryServiceApplicateDAO에서 deleteApplicant를 수행한 값을 return한다.
	 * 				해당 글번호와 회원번호에 일치하는 회원을 신청자 리스트DB에서 삭제한다.
	 * @param alvo : 글번호, 회원번호, 신청사유, id, 이름, 메일주소등을 같이 담기위해 사용
	 */
	@Override
	public void deleteApplicant(ApplicantListVO alvo) {
		// TODO Auto-generated method stub
		voluntaryServiceApplicateDAO.deleteApplicant(alvo);
	}

}
