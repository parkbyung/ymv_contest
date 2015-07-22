package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	@Resource(name="statisticsDAOImpl")
	private StatisticDAO statisticDAO;
	
	/**
	 * 작성자 : 백지영
	 * 내용 : statisticDAO에서 findStatisticsList메서드 수행한 것을 list에 담아서 return해준다.
	 * 				통계DB에서 신청자 수가 많은 봉사를 분야별로 순위를 매겨 list에 담아서 보여준다.
	 * @return list : 통계DB에서 신청자 수가 많은 봉사 분야별로 순위를 매긴 정보를 담기 위해 사용
	 */
	@Override
	public List findStatisticsList() throws SQLException {
		return statisticDAO.findStatisticsList();
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : statisticDAO에서 findStatisticsListByAge 메서드를 수행한 값을 list에 담아서 return해준다.
	 * 				통계DB에서 신청자 수가 많은 봉사를 분야별로 나누어 순위를 매기는데 
	 * 				age를 이용해 나이대 별로 분야를 나누어 3위까지만 보여준다.
	 * @return list : 통계DB에서 신청자 수가 많은 봉사를 분야별, 나이대별로 순위를 매긴 정보를 담기 위해 사용
	 * @param age : 신청한 봉사 순위 정보를 나이대 별로 나눠서 찾아오기 위해 사용
	 */
	@Override
	public List findStatisticsListByAge(int age) {
		return statisticDAO.findStatisticsListByAge(age);
	}
}
