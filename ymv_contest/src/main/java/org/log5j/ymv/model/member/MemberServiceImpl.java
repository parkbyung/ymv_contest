package org.log5j.ymv.model.member;

import java.io.File;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.PictureVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class MemberServiceImpl implements MemberService {
	@Resource(name="memberDAOImpl")
	private MemberDAO memberDAO;
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 login을 수행한 값을 return 한다.
	 * 				id와 password가 일치하는 회원을 찾아 회원정보를 반환한다.
	 * @param vo : id와 password를 같이 받아오기 위해 사용
	 * @return MemberVO : id와 password가 일치하는 회원정보를 vo에 담아서 반환
	 */
	@Override
	public MemberVO login(MemberVO vo){
		return memberDAO.login(vo);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 checkId를 수행한 값을 return 한다.
	 * 				받아온 id가 몇 개 있는지 반환해 준다.
	 * 				만약 id가 0이면 사용할 수 있다는 뜻의 ok를 반환, 0이 아니라면 fail을 반환한다.
	 * @param id : id 중복체크를 하기위해 사용
	 * @return String : 조건에 따라 ok와 fail을 반환
	 */
	@Override
	public String checkId(String id) {
		return memberDAO.checkId(id);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 registerMember를 수행한 값을 return 해준다.
	 * 				회원가입 폼에서 정보들을 받아와서 insert 해준다.
	 * @param memberVO : 회원가입을 위한 정보들을 같이 처리하기 위해 사용
	 */
	@Override
	public void registerMember(MemberVO memberVO) {
		/*memberDAO.idCheck(memberVO.getId());*/
		memberDAO.registerMember(memberVO);		
	}
	
	
	/*@Override
	public void registerPicture(PictureVO pvo) {
		// TODO Auto-generated method stub
		memberDAO.registerPicture(pvo);
	}*/
	
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 updateProfile를 수행한 값을 return 해준다.
	 * 				memberNo를 받아와서 해당 번호와 일치하는 회원의 filePath를 변경한다.
	 * @param memberVO : 프로필 사진 업로드를 위해 memberNo와 filePath를 같이 담아오기 위해 사용
	 */
	@Override
	public void updateProfile(MemberVO memberVO) {
		memberDAO.updateProfile(memberVO);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 updateMember를 수행한 값을 return 해준다.
	 * 				회원정보 수정 폼에서 정보들을 받아와서 update해준다.
	 * @param memberVO : 회원정보 수정을 위한 정보를 같이 처리하기 위해 사용
	 */
	@Override
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : memberDAO에서 findMemberByMemberNo를 수행한 값을 return한다.
	 * 				memberNo를 이용해 해당 회원을 찾아 회원정보를 반환한다.
	 * @param memberNo : 해당하는 회원의 회원정보를 찾기 위해 사용
	 * @return MemberVO : memberNo가 일치하는 회원정보를 vo에 담아서 반환
	 */
	@Override
	public MemberVO findMemberByMemberNo(int memberNo) {
		return memberDAO.findMemberByMemberNo(memberNo);
	}

	@Override
	public void updateProfilePath(MemberVO mvo, PictureVO pvo,
			String profilePath) {
		MultipartFile file=pvo.getFileName();
		/*
		 *  파일 얻는 메서드  : list.get(i) 을 호출하면 File이 반환 
		 *  실제 디렉토리로 전송(업로드) 메서드 : 파일.transferTo(파일객체)
		 *  ModelAndView 에서 결과 페이지로 업로드한 파일 정보를 문자열배열로
		 *  할당해 jsp에서 사용하도록 한다. 
		*/ 
		/*ArrayList<String> nameList=new ArrayList<String>();
		for(int i=0;i<list.size();i++){*/
			//System.out.println(list.get(i).getOriginalFilename().equals(""));
			String fileName="[memberNo"+mvo.getMemberNo()+"]"+file.getOriginalFilename();			
			String filePath="profileupload\\"+fileName;
/*			memberVO.setFilePath(filePath);
			pvo.setPictureNo(memberVO.getMemberNo());*/
			if(!fileName.equals("")/*&&(fileName.contains(".jpg")||fileName.contains(".png") )*/){
				try {
					mvo.setFilePath(filePath);
					pvo.setPictureNo(mvo.getMemberNo());
					file.transferTo(new File(profilePath+fileName));
					// 픽쳐 디비에 파일정보 저장
					System.out.println("PictureNo: "+pvo.getPictureNo()+" fileName: "+pvo.getFileName());
					/*memberService.updateProfile(mvo);*/
					/*nameList.add(fileName);*/
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
		
	}
	
}
