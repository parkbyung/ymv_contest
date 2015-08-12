package org.log5j.ymv.model.board;

import java.sql.Date;

public class QnABoardVO implements BoardVO{
	private int qnaNo;
	private String title;
	private String writer;
	private String content;
	private int ref;
	private int restep;
	private int relevel;
	private int memberNo;
	private Date timePosted;
	private int hit;
	private String answer;
	public QnABoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnABoardVO(int qnaNo, String title, String writer, String content,
			int ref, int restep, int relevel, int memberNo, Date timePosted,
			int hit, String answer) {
		super();
		this.qnaNo = qnaNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.memberNo = memberNo;
		this.timePosted = timePosted;
		this.hit = hit;
		this.answer = answer;
	}
	
	
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "QnABoardVO [qnaNo=" + qnaNo + ", title=" + title + ", writer="
				+ writer + ", content=" + content + ", ref=" + ref
				+ ", restep=" + restep + ", relevel=" + relevel + ", memberNo="
				+ memberNo + ", timePosted=" + timePosted + ", hit=" + hit
				+ ", answer=" + answer + "]";
	}
	


}