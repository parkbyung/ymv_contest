package org.log5j.ymv.model.voluntary;

public class ConfirmPageVO {
	private int memberNo;
	private int pageNo;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String toString() {
		return "CompanyVO [memberNo=" + memberNo + ", pageNo=" + pageNo + "]";
	}
	
}
