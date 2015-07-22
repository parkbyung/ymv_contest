package org.log5j.ymv.model.scheduler;

public class SchedulerVO {
	private int memberNo;
	private String field;
	private String location;
	private String startDate;
	private String endDate;
	public SchedulerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchedulerVO(int memberNo, String field, String location,
			String startDate, String endDate) {
		super();
		this.memberNo = memberNo;
		this.field = field;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "SchedulerVO [memberNo=" + memberNo + ", field=" + field
				+ ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}
