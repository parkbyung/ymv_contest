package org.log5j.ymv.model.member;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVO {
	private int memberNo;
	@Size(min=4,max=10)
	private String id;
	@Size(min=4,max=10)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	private String identityNo;
	@Email
	@NotEmpty
	private String mailAddress;
	private String memberType;
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MemberVO() {
		super();
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public MemberVO(int memberNo, String id, String password, String name,
			String address, String identityNo, String mailAddress,
			String memberType) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.identityNo = identityNo;
		this.mailAddress = mailAddress;
		this.memberType = memberType;
	}

	

	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", id=" + id + ", password="
				+ password + ", name=" + name + ", address=" + address
				+ ", identityNo=" + identityNo + ", mailAddress=" + mailAddress
				+ ", memberType=" + memberType + ", filePath=" + filePath + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}