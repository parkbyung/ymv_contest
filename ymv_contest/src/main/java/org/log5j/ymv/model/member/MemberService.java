package org.log5j.ymv.model.member;


public interface MemberService {
	public MemberVO login(MemberVO vo);

	public String checkId(String id);

	public void registerMember(MemberVO memberVO);

	/*public void registerPicture(PictureVO pvo);*/

	public void updateProfile(MemberVO memberVO);
	
	public void updateMember(MemberVO memberVO);
	
	public MemberVO findMemberByMemberNo(int memberNo);

}