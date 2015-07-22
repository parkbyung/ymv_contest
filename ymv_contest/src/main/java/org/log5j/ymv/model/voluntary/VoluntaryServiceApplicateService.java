package org.log5j.ymv.model.voluntary;

import java.util.List;

public interface VoluntaryServiceApplicateService {
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo);
	public boolean checkVolunteerApplicant(int recruitNo, int memberNo);
	public List<ApplicantListVO> findApplicantList(int recruitNo);
	public void deleteApplicant(ApplicantListVO alvo);
}