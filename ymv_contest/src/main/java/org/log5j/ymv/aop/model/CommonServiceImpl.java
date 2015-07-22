package org.log5j.ymv.aop.model;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
	@Resource(name="commonDAOImpl")
	private CommonDAO commonDAO;

	/**
	 * 작성자 : 백지영
	 * 내용 : commonDAO에서 findIdentityNoByMemberNo를 수행한 값을 return 해 준다.
	 * 				memberNo를 가지고 해당하는 회원번호를 가진 회원의 생년월일을 가져온다.
	 * @param memberNo : 회원의 생년 월일을 찾기 위해 사용
	 * @return String : 생년월일
	 */
	@Override
	public String findIdentityNoByMemberNo(int memberNo) {
		return commonDAO.findIdentityNoByMemberNo(memberNo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 생년월일을 받아오면 메서드 수행전에 조건에 따라 ageTemp에 값을 담아준다.
	 * 				변경된 age와 field를 가지고 update를 수행하는데 
	 * 				만약 return값이 0이면 registerStatistics 메서드를 수행하고
	 * 				0이 아닌 다른 수라면 신청자 수를 updateStatistics 메서드를 수행한다. 
	 * @param age : 생년월일
	 * @param field
	 */
	@Override
	public void saveStatistics(int age, String field) throws SQLException {
		int ageTemp = (115-(age/10000))+1;
		//(올해년도(115)-일반회원 태어난연도(age/10000))+1 == 일반회원 나이
		if(ageTemp>=10 && ageTemp<20){
			ageTemp = 10;
		}else if(ageTemp>=20 && ageTemp<30){
			ageTemp=20;
		}else if(ageTemp>=30 && ageTemp<40){
			ageTemp=30;
		}else if(ageTemp>=40 && ageTemp<50){
			ageTemp=40;
		}else if(ageTemp>=50 && ageTemp<60){
			ageTemp=50;
		}else{
			ageTemp=0;
			//age가 0이면 기타
		}
		System.out.println("ageTemp    "+ageTemp);
		int result=commonDAO.updateStatistics(ageTemp, field);
		if(result==0)
			commonDAO.registerStatistics(ageTemp, field);	
		
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : commonDAO에서 findFieldByRecruitNo를 수행한다.
	 * 				RecruitNo를 이용해 해당하는 글번호를 가진 글의 봉사분야를 가져온다.
	 * @param RecruitNo : 해당 글의 분야를 찾기 위해 사용
	 * @return String : 분야
	 */
	@Override
	public String findFieldByRecruitNo(int RecruitNo) {
		return commonDAO.findFieldByRecruitNo(RecruitNo);
	}

}
