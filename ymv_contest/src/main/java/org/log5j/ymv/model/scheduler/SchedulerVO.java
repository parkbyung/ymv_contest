package org.log5j.ymv.model.scheduler;

public class SchedulerVO {
	private int memberNo;
	private String field;
	private String location;
	private String volunteeringStartTime;
	private String volunteeringEndTime;
	public SchedulerVO() {
		super();
	}
	public SchedulerVO(int memberNo, String field, String location,
			String volunteeringStartTime, String volunteeringEndTime) {
		super();
		this.memberNo = memberNo;
		this.field = field;
		this.location = location;
		this.volunteeringStartTime = volunteeringStartTime;
		this.volunteeringEndTime = volunteeringEndTime;
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
	public String getVolunteeringStartTime() {
		return volunteeringStartTime;
	}
	public void setVolunteeringStartTime(String volunteeringStartTime) {
		this.volunteeringStartTime = volunteeringStartTime;
	}
	public String getVolunteeringEndTime() {
		return volunteeringEndTime;
	}
	public void setVolunteeringEndTime(String volunteeringEndTime) {
		this.volunteeringEndTime = volunteeringEndTime;
	}
	@Override
	public String toString() {
		return "SchedulerVO [memberNo=" + memberNo + ", field=" + field
				+ ", location=" + location + ", volunteeringStartTime="
				+ volunteeringStartTime + ", volunteeringEndTime="
				+ volunteeringEndTime + "]";
	}
	
	
	
}
