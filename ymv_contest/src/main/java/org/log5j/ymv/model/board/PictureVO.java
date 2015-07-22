package org.log5j.ymv.model.board;

import org.springframework.web.multipart.MultipartFile;


public class PictureVO {
	private int pictureNo;
	private MultipartFile fileName;
	private String filePath;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public PictureVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPictureNo() {
		return pictureNo;
	}
	public void setPictureNo(int pictureNo) {
		this.pictureNo = pictureNo;
	}

	public MultipartFile getFileName() {
		return fileName;
	}
	public void setFileName(MultipartFile fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "PictureVO [pictureNo=" + pictureNo + ", fileName=" + fileName
				+ ", filePath=" + filePath + "]";
	}

	
}
