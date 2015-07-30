package org.log5j.ymv.model.member;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.PictureVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 작성자 : 백지영
	 * 내용 : id와 password가 일치하는 회원을 찾아 회원정보를 반환한다.
	 * @param vo : id와 password를 같이 받아오기 위해 사용
	 * @return MemverVO : id와 password가 일치하는 회원정보를 vo에 담아서 반환
	 */
	@Override
	public MemberVO login(MemberVO vo){
		return sqlSessionTemplate.selectOne("member.login",vo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 받아온 id가 몇 개 있는지 반환해 준다.
	 * 				만약 id가 0이면 사용할 수 있다는 뜻의 ok를 반환, 0이 아니라면 fail을 반환한다.
	 * @param id : id 중복체크를 하기위해 사용
	 * @return String : 조건에 따라 ok와 fail을 반환
	 */
	@Override
	public String checkId(String id) {
		int flag=sqlSessionTemplate.selectOne("member.checkId",id);
		System.out.println(flag+" 이 값이 아디 갯수");
		return (flag==0) ? "ok":"fail"; 	
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 회원가입 폼에서 정보들을 받아와서 insert 해준다.
	 * @param memberVO : 회원가입을 위한 정보들을 같이 처리하기 위해 사용
	 */
	@Override
	public void registerMember(MemberVO memberVO) {
		sqlSessionTemplate.insert("member.registerMember",memberVO);
	}

	/*@Override
	public void registerPicture(PictureVO pvo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("member.registerPicture",pvo);
	}*/

	/**
	 * 작성자 : 백지영
	 * 내용 : memberNo를 받아와서 해당 번호와 일치하는 회원의 filePath를 변경한다.
	 * @param memberVO : 프로필 사진 업로드를 위해 memberNo와 filePath를 같이 담아오기 위해 사용
	 */
	@Override
	public void updateProfile(MemberVO memberVO) {
		System.out.println("파일 패쓰랑 맴버넘버 보기"+memberVO);
		sqlSessionTemplate.update("member.updateProfile",memberVO);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 회원정보 수정 폼에서 정보들을 받아와서 update해준다.
	 * @param memberVO : 회원정보 수정을 위한 정보를 같이 처리하기 위해 사용
	 */
	@Override
	public void updateMember(MemberVO memberVO) {
		sqlSessionTemplate.update("member.updateMember",memberVO);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : memberNo를 이용해 해당 회원을 찾아 회원정보를 반환한다.
	 * @param memberNo : 해당하는 회원의 회원정보를 찾기 위해 사용
	 * @return MemberVO : memberNo가 일치하는 회원정보를 vo에 담아서 반환
	 */
	@Override
	public MemberVO findMemberByMemberNo(int memberNo) {
		return sqlSessionTemplate.selectOne("member.findMemberByMemberNo",memberNo);
	}
}
