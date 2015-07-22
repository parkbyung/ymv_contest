package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDAOImpl implements StatisticDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 신청자 수가 많은 봉사 분야별로 순위를 매긴 정보를 가져온다.
	 * @return List : 통계DB에서 신청자 수가 많은 봉사 분야별로 순위를 매긴 정보를 담기 위해 사용
	 */
	public List findStatisticsList() throws SQLException {
		return sqlSessionTemplate.selectList("statistics.findStatisticsList");
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 나이대를 받아와서 그 나이에 해당하는 신청자 수가 많은 봉사를 분야별로 순위를 3위까지 매겨 가져온다.
	 * @param age : 신청한 봉사 순위 정보를 나이대 별로 찾아오기 위해 사용
	 * @return List : 통계DB에서 신청자 수가 많은 봉사를 분야별, 나이대별로 순위를 매긴 정보를 담기 위해 사용
	 */
	@Override
	public List findStatisticsListByAge(int age) {
		List list = sqlSessionTemplate.selectList("statistics.findStatisticsListByAge", age);
		return list;
	}
}
