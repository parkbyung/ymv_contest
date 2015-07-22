package org.log5j.ymv.model.cookie;

import javax.servlet.http.Cookie;

import org.log5j.ymv.model.board.BoardVO;

public interface CookieService {

	Cookie cookieSerivce(Cookie[] cookies, int recruitNo, BoardVO revo);


}
