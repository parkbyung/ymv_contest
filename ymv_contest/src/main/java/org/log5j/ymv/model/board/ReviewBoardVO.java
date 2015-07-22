package org.log5j.ymv.model.board;

import java.sql.Date;

public class ReviewBoardVO implements BoardVO{
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private int memberNo;
	private Date timePosted;
	private int hit;
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
	public ReviewBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewBoardVO(int boardNo, String title, String writer,
			String content, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.memberNo = memberNo;
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
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "ReviewBoardVO [boardNo=" + boardNo + ", title=" + title
				+ ", writer=" + writer + ", content=" + content + ", memberNo="
				+ memberNo + ", timePosted=" + timePosted + ", hit=" + hit
				+ "]";
	}

	
}
