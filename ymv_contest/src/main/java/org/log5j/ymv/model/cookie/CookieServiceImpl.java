package org.log5j.ymv.model.cookie;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.log5j.ymv.model.board.BoardVO;
import org.springframework.stereotype.Service;
@Service
public class CookieServiceImpl implements CookieService {
	@Resource
	private CookieDAO cookieDAO;
	@Override
	public Cookie cookieSerivce(Cookie[] cookies, int No, BoardVO bvo) {
		// 개별 게시물 조회 ( 조회수 증가 )
				// 사용자의 쿠키를 받아온다.
				Cookie cookie = null;
				//사용자의 쿠키가 없을 때 쿠키를 추가한다.
				if (cookies == null || cookies.length == 0) {
					cookie = new Cookie("myboard", "|" + No + "|");
					cookieDAO.updateHit(No,bvo);
				}
				// 쿠키가 존재한다면 그 쿠키들이 myboard라는 것이 있는 지 확인하고 있다면 조회수를 높이지 않기 위해 우리가 생성한
				// 쿠키에 입력시킨다.
				//만약에 myboard라는 쿠키가 없다면 쿠키를 추가한다.
				else {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("myboard")) {
							cookie = cookies[i];
							break;
						}
					}
					if (cookie == null) {
						// 쿠키가 존재하는데 myboard가 없을때
						cookie = new Cookie("myboard", "|" + No + "|");
						//조회수를 올려준다.
						cookieDAO.updateHit(No,bvo);
					} 
					// 쿠키가 존재하는데 myboard가 있을때
					else {
						String value = cookie.getValue();
						//myboard가 있는데 게시물의 번호가 존재할 때 조회수를 증가시키지 않는다.
						if (value.indexOf("|" + No + "|") != -1) {
							
						} else {
							// myboard cookie의 value 정보에서 해당 게시글 번호가 존재하지 않은 상태 조회수 증가
							value += "|" + No + "|";
							cookieDAO.updateHit(No,bvo);
							//쿠키 'myboard' 에 게시글 번호를 등록한다.
							cookie= new Cookie("myboard", value);
						}// else1
					}// else2
				}// else3
				return cookie;
	}
}
