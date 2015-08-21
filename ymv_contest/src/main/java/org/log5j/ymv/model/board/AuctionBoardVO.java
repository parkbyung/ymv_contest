package org.log5j.ymv.model.board;


public class AuctionBoardVO implements BoardVO{
	private int boardNo;
	private String title;
	private String content;
	private String article;
	private String timePosted;
	private int firstPrice;
	private int currentPrice;
	private String endDate;	
	private String endTime;
	private String bidder;
	private String gyeongmae;
	
	public AuctionBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuctionBoardVO(int boardNo, String title, String content,
			String article, String timePosted, int firstPrice,
			int currentPrice, String endDate, String endTime, String bidder,
			String gyeongmae) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.article = article;
		this.timePosted = timePosted;
		this.firstPrice = firstPrice;
		this.currentPrice = currentPrice;
		this.endDate = endDate;
		this.endTime = endTime;
		this.bidder = bidder;
		this.gyeongmae = gyeongmae;
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

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public int getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(int firstPrice) {
		this.firstPrice = firstPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBidder() {
		return bidder;
	}

	public void setBidder(String bidder) {
		this.bidder = bidder;
	}

	public String getGyeongmae() {
		return gyeongmae;
	}

	public void setGyeongmae(String gyeongmae) {
		this.gyeongmae = gyeongmae;
	}

	@Override
	public String toString() {
		return "AuctionBoardVO [boardNo=" + boardNo + ", title=" + title
				+ ", content=" + content + ", article=" + article
				+ ", timePosted=" + timePosted + ", firstPrice=" + firstPrice
				+ ", currentPrice=" + currentPrice + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", bidder=" + bidder
				+ ", gyeongmae=" + gyeongmae + "]";
	}
	
}