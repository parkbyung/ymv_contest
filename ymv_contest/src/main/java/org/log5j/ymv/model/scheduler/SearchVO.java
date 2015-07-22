package org.log5j.ymv.model.scheduler;

public class SearchVO {
	private String field;
	private String location;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private String pageNo;
	private String title;
	public SearchVO() {
		super();
	}

	public SearchVO(String field, String location, String startDate,
			String startTime, String endDate, String endTime, String pageNo,
			String title) {
		super();
		this.field = field;
		this.location = location;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.pageNo = pageNo;
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SearchVO [field=" + field + ", location=" + location
				+ ", startDate=" + startDate + ", startTime=" + startTime
				+ ", endDate=" + endDate + ", endTime=" + endTime + ", pageNo="
				+ pageNo + ", title=" + title + "]";
	}
	
	
}
