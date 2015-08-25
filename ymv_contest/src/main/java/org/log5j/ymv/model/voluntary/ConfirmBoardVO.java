package org.log5j.ymv.model.voluntary;

public class ConfirmBoardVO {
	private int boardNo;
	private String title;
	private String field;
	private String location;
	private String age;
	private String startDate;
	private String endDate;
	private String content;
	private int memberNo;
	private String timePosted;
	private int hit;
	
	public ConfirmBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ConfirmBoardVO(int boardNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "ConfirmBoardVO [boardNo=" + boardNo + ", title=" + title
				+ ", field=" + field + ", location=" + location + ", age="
				+ age + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", content=" + content + ", memberNo=" + memberNo
				+ ", timePosted=" + timePosted + ", hit=" + hit + "]";
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
