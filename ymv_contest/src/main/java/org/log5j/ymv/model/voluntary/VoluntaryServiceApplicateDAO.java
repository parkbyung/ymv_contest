package org.log5j.ymv.model.voluntary;

import java.util.List;
import java.util.Map;

public interface VoluntaryServiceApplicateDAO {
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo);
	public Integer checkVolunteerApplicant(Map<String,Object> map);
	public List<ApplicantListVO> findApplicantList(int recruitNo);
}
