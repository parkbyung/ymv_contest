package org.log5j.ymv.model.voluntary;

public class ApplicantListVO {
	private int recruitNo;
	private int memberNo;
	private String motivate;
	private String id;
	private String name;
	private String mailAddress;
	@Override
	public String toString() {
		return "ApplicantListVO [recruitNo=" + recruitNo + ", memberNo="
				+ memberNo + ", motivate=" + motivate + ", id=" + id
				+ ", name=" + name + ", mailAddress=" + mailAddress + "]";
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}
