package org.log5j.ymv.model.scheduler;

public class SearchVO {
	private String field;
	private String location;
	private String volunteeringStartDate;
	private String volunteeringEndDate;
	private String pageNo;
	private String title;
	public SearchVO() {
		super();
	}
	public SearchVO(String field, String location,
			String volunteeringStartDate, String volunteeringEndDate,
			String pageNo, String title) {
		super();
		this.field = field;
		this.location = location;
		this.volunteeringStartDate = volunteeringStartDate;
		this.volunteeringEndDate = volunteeringEndDate;
		this.pageNo = pageNo;
		this.title = title;
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
	public String getVolunteeringStartDate() {
		return volunteeringStartDate;
	}
	public void setVolunteeringStartDate(String volunteeringStartDate) {
		this.volunteeringStartDate = volunteeringStartDate;
	}
	public String getVolunteeringEndDate() {
		return volunteeringEndDate;
	}
	public void setVolunteeringEndDate(String volunteeringEndDate) {
		this.volunteeringEndDate = volunteeringEndDate;
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
				+ ", volunteeringStartDate=" + volunteeringStartDate
				+ ", volunteeringEndDate=" + volunteeringEndDate + ", pageNo="
				+ pageNo + ", title=" + title + "]";
	}

	
}
