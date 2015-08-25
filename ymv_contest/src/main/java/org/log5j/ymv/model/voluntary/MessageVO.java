package org.log5j.ymv.model.voluntary;

import java.util.Date;

public class MessageVO {
	private int messageNo;
	private String messageType;
	private String title;
	private String content;
	private int receiveNo;
	private String receiverName;
	private Date timePosted;
	private int recruitNo;
	
	public MessageVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageVO(String messageType, String title, String content,
			int receiveNo, String receiverName, int recruitNo) {
		super();
		this.messageType = messageType;
		this.title = title;
		this.content = content;
		this.receiveNo = receiveNo;
		this.receiverName = receiverName;
		this.recruitNo = recruitNo;
	}



	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
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

	public int getReceiveNo() {
		return receiveNo;
	}

	public void setReceiveNo(int receiveNo) {
		this.receiveNo = receiveNo;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Date getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}

	public int getRecruitNo() {
		return recruitNo;
	}

	public void setRecruitNo(int recruitNo) {
		this.recruitNo = recruitNo;
	}

	@Override
	public String toString() {
		return "MessageVO [messageNo=" + messageNo + ", messageType="
				+ messageType + ", title=" + title + ", content=" + content
				+ ", receiveNo=" + receiveNo + ", receiverName=" + receiverName
				+ ", timePosted=" + timePosted + ", recruitNo=" + recruitNo
				+ "]";
	}

}
