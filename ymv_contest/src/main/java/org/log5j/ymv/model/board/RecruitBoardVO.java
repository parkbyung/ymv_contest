package org.log5j.ymv.model.board;
//area => location
/*
 * recruitingStart 봉사 모집 시작 날짜
 * volunteeringStartDate 실제 봉사 시작 날짜
 * volunteeringStartTime 실제 봉사 시작 시간
 */
public class RecruitBoardVO implements BoardVO{
	private int recruitNo;
	private String title;
	private String field;
	private String location;
	private String age;
	private String recruitingStart;
	private String recruitingEnd;
	private String content;
	private int memberNo;
	private String postDate;
	private int hit;
	//확인하기
	private String checkDate;
	private String mojib;
	private String volunteeringStartDate;
	private String volunteeringEndDate;
	private String volunteeringStartTime;
	private String volunteeringEndTime;
	
	
	public RecruitBoardVO() {
		super();
	}


	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String recruitingStart,
			String recruitingEnd, String content, int memberNo,
			String postDate, int hit, String checkDate, String mojib,
			String volunteeringStartDate, String volunteeringEndDate,
			String volunteeringStartTime, String volunteeringEndTime) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.recruitingStart = recruitingStart;
		this.recruitingEnd = recruitingEnd;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
		this.checkDate = checkDate;
		this.mojib = mojib;
		this.volunteeringStartDate = volunteeringStartDate;
		this.volunteeringEndDate = volunteeringEndDate;
		this.volunteeringStartTime = volunteeringStartTime;
		this.volunteeringEndTime = volunteeringEndTime;
	}


	public int getRecruitNo() {
		return recruitNo;
	}


	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
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


	public String getRecruitingStart() {
		return recruitingStart;
	}


	public void setRecruitingStart(String recruitingStart) {
		this.recruitingStart = recruitingStart;
	}


	public String getRecruitingEnd() {
		return recruitingEnd;
	}


	public void setRecruitingEnd(String recruitingEnd) {
		this.recruitingEnd = recruitingEnd;
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


	public String getPostDate() {
		return postDate;
	}


	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}


	public String getMojib() {
		return mojib;
	}


	public void setMojib(String mojib) {
		this.mojib = mojib;
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
		return "RecruitBoardVO [recruitNo=" + recruitNo + ", title=" + title
				+ ", field=" + field + ", location=" + location + ", age="
				+ age + ", recruitingStart=" + recruitingStart
				+ ", recruitingEnd=" + recruitingEnd + ", content=" + content
				+ ", memberNo=" + memberNo + ", postDate=" + postDate
				+ ", hit=" + hit + ", checkDate=" + checkDate + ", mojib="
				+ mojib + ", volunteeringStartDate=" + volunteeringStartDate
				+ ", volunteeringEndDate=" + volunteeringEndDate
				+ ", volunteeringStartTime=" + volunteeringStartTime
				+ ", volunteeringEndTime=" + volunteeringEndTime + "]";
	}
	
}
