package org.log5j.ymv.model.voluntary;

public class VoluntaryServiceApplicateVO {
	private int recruitNo;
	private int memberNo;
	private String motivate;
	
	public VoluntaryServiceApplicateVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoluntaryServiceApplicateVO(int recruitNo, int memberNo,
			String motivate) {
		super();
		this.recruitNo = recruitNo;
		this.memberNo = memberNo;
		this.motivate = motivate;
	}

	public int getRecruitNo() {
		return recruitNo;
	}

	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMotivate() {
		return motivate;
	}

	public void setMotivate(String motivate) {
		this.motivate = motivate;
	}

	@Override
	public String toString() {
		return "VoluntaryServiceApplicateVO [recruitNo=" + recruitNo
				+ ", memberNo=" + memberNo + ", motivate=" + motivate + "]";
	}
	

}
