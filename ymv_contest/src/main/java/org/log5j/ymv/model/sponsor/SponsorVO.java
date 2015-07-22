package org.log5j.ymv.model.sponsor;

import org.log5j.ymv.model.board.BoardVO;

public class SponsorVO implements BoardVO{
	private int boardNo;
	private String title;
	private String content;
	private int targetPrice;
	private int currentPrice;
	private int percentage;
	private String startDate;
	private String endDate;
	private String hoowon;
	public SponsorVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SponsorVO(int boardNo, String title, String content,
			int targetPrice, int currentPrice) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.targetPrice = targetPrice;
		this.currentPrice = currentPrice;
	}
	public SponsorVO(int boardNo, String title, String content,
			int targetPrice, int currentPrice, int percentage,
			String startDate, String endDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.targetPrice = targetPrice;
		this.currentPrice = currentPrice;
		this.percentage = percentage;
		this.startDate = startDate;
		this.endDate = endDate;
		
	}
	public SponsorVO(int boardNo, String title, String content,
			int targetPrice, int currentPrice, int percentage,
			String startDate, String endDate, String hoowon) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.targetPrice = targetPrice;
		this.currentPrice = currentPrice;
		this.percentage = percentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hoowon = hoowon;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(int targetPrice) {
		this.targetPrice = targetPrice;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
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
	public String getHoowon() {
		return hoowon;
	}

	public void setHoowon(String hoowon) {
		this.hoowon = hoowon;
	}
	@Override
	public String toString() {
		return "SponsorVO [boardNo=" + boardNo + ", title=" + title
				+ ", content=" + content + ", targetPrice=" + targetPrice
				+ ", currentPrice=" + currentPrice + ", percentage="
				+ percentage + ", startDate=" + startDate + ", endDate="
				+ endDate + ", hoowon=" + hoowon + "]";
	}
}
