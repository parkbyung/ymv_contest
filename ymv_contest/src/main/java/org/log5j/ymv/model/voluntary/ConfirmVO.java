package org.log5j.ymv.model.voluntary;

public class ConfirmVO {
	private int boardNo;
	private int memberNo;
	public ConfirmVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ConfirmVO(int boardNo, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "ConfirmVO [boardNo=" + boardNo + ", memberNo=" + memberNo + "]";
	}
	
}
