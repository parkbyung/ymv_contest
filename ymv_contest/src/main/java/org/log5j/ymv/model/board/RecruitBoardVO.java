package org.log5j.ymv.model.board;
//area => location
// timeHr,date ??�� ?�시 ?�각
public class RecruitBoardVO implements BoardVO{
	private int recruitNo;
	private String title;
	private String field;
	private String location;
	private String age;
	private String startDate;
	private String endDate;
	private String content;
	private int memberNo;
	private String postDate;
	private int hit;
	//확인하기
	private String checkDate;
	private String mojib;
	private String playStart;
	private String playEnd;

	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content, int memberNo, String postDate, int hit,
			String checkDate, String mojib, String playStart, String playEnd) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
		this.checkDate = checkDate;
		this.mojib = mojib;
		this.playStart = playStart;
		this.playEnd = playEnd;
	}
	
	public String getPlayStart() {
		return playStart;
	}

	public void setPlayStart(String playStart) {
		this.playStart = playStart;
	}

	public String getPlayEnd() {
		return playEnd;
	}

	public void setPlayEnd(String playEnd) {
		this.playEnd = playEnd;
	}

	public RecruitBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecruitBoardVO(String title, String field, String location, String age,
			String startDate, String endDate, String content) {
		super();
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
	}

	public RecruitBoardVO(String title, String field, String location,
			String age, String startDate, String endDate, String content,
			int memberNo, String postDate, int hit) {
		super();
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
	}

	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
	}

	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content, int memberNo, String postDate, int hit) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
	}
	
	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content, int memberNo, String postDate, int hit,
			String checkDate) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
		this.checkDate = checkDate;
	}
	
	public RecruitBoardVO(int recruitNo, String title, String field,
			String location, String age, String startDate, String endDate,
			String content, int memberNo, String postDate, int hit,
			String checkDate, String mojib) {
		super();
		this.recruitNo = recruitNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.memberNo = memberNo;
		this.postDate = postDate;
		this.hit = hit;
		this.checkDate = checkDate;
		this.mojib = mojib;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public String getMojib() {
		return mojib;
	}

	public void setMojib(String mojib) {
		this.mojib = mojib;
	}

	@Override
	public String toString() {
		return "RecruitBoardVO [recruitNo=" + recruitNo + ", title=" + title
				+ ", field=" + field + ", location=" + location + ", age="
				+ age + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", content=" + content + ", memberNo=" + memberNo
				+ ", postDate=" + postDate + ", hit=" + hit + ", checkDate="
				+ checkDate + ", mojib=" + mojib + ", playStart=" + playStart
				+ ", playEnd=" + playEnd + "]";
	}



}
