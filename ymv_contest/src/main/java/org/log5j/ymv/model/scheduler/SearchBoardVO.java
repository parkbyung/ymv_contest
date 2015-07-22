package org.log5j.ymv.model.scheduler;

public class SearchBoardVO {

	private String Search;
	private String pageNo;
	
	public SearchBoardVO() {
		super();
	}
	
	public SearchBoardVO(String search, String pageNo) {
		super();
		Search = search;
		this.pageNo = pageNo;
	}
	public String getSearch() {
		return Search;
	}
	public void setSearch(String search) {
		Search = search;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	@Override
	public String toString() {
		return "SearchBoardVO [Search=" + Search + ", pageNo=" + pageNo + "]";
	}
	
}
