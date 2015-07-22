package org.log5j.ymv.aop.model;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.log5j.ymv.model.statistics.StatisticsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 작성자 : 백지영
	 * 내용 : age와 field를 받아와 통계DB에 넣어준다. 
	 * 				age와 field를 한 번에 넣어줄 수 없으므로 vo에 담아서 넣어준다.
	 * 				insert시 신청자 수는 자동으로 1이 입력된다.
	 * @param age 
	 * @param field
	 */
	public void registerStatistics(int age, String field) throws SQLException {
		StatisticsVO stvo = new StatisticsVO();
		stvo.setAge(age);
		stvo.setField(field);
		sqlSessionTemplate.insert("statistics.registerStatistics", stvo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 통계DB에 이미 age와 field가 있는 경우 0이 반환된다.(age, field는 복합PK)
	 * 				그 외 다른 수가 반환되면 해당하는 age와 field의를 찾아 신청자 수를 +1 해준다.
	 * @param age
	 * @param field
	 * @return int : update가 성공되면 성공한 row 수가 반환되고, 실패하면 0이 반환된다.
	 */
	public int updateStatistics(int age, String field) throws SQLException {
		StatisticsVO stvo = new StatisticsVO();
		stvo.setAge(age);
		stvo.setField(field);
		return sqlSessionTemplate.update("statistics.updateStatistics",stvo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : memberNo를 이용해 해당 회원의 생년월일을 가져온다.
	 * @param memberNo : 회원의 생년 월일을 찾기 위해 사용
	 * @return String : 생년월일
	 */
	@Override
	public String findIdentityNoByMemberNo(int memberNo) {
		return sqlSessionTemplate.selectOne("statistics.findIdentityNoByMemberNo",memberNo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : RecruitNo를 이용해 해당 글의 분야를 가져온다.
	 * @param RecruitNo : 해당 글의 분야를 찾기 위해 사용
	 * @return String : 분야
	 */
	@Override
	public String findFieldByRecruitNo(int RecruitNo) {
		return sqlSessionTemplate.selectOne("statistics.findFieldByRecruitNo",RecruitNo);
	}

	
}
