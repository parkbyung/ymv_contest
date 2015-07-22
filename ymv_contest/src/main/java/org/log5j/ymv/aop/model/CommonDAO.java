package org.log5j.ymv.aop.model;

import java.sql.SQLException;

public interface CommonDAO {
	public void registerStatistics(int age, String field) throws SQLException;	
	public int updateStatistics(int age, String field) throws SQLException;
	public String findIdentityNoByMemberNo(int memberNo);
	public String findFieldByRecruitNo(int RecruitNo);

}
