package org.log5j.ymv.model.board;

public class CommentVO {
	private int commentNo;
	private String writer;
	private String content;
	private String timePosted;
	private int boardNo;
	
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVO(int commentNo, String writer, String content,
			String timePosted, int boardNo) {
		super();
		this.commentNo = commentNo;
		this.writer = writer;
		this.content = content;
		this.timePosted = timePosted;
		this.boardNo = boardNo;
	}

	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	public String getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", writer=" + writer
				+ ", content=" + content + ", timePosted=" + timePosted
				+ ", boardNo=" + boardNo + "]";
	}

}
