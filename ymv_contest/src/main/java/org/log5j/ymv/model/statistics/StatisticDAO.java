package org.log5j.ymv.model.statistics;

import java.sql.SQLException;
import java.util.List;

public interface StatisticDAO {
	public List findStatisticsList() throws SQLException;
	public List findStatisticsListByAge(int age);
}