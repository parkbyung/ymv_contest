package org.log5j.ymv.aop.model;

import java.sql.SQLException;

public interface CommonService {
	public void saveStatistics(int age, String field) throws SQLException;
	public String findIdentityNoByMemberNo(int memberNo);
	public String findFieldByRecruitNo(int RecruitNo);
}
