package org.log5j.ymv.model.cookie;

import org.log5j.ymv.model.board.BoardVO;

public interface CookieDAO {

	void updateHit(int no, BoardVO bvo);

	/*BoardVO findRecruitBoardByNo(int no);*/

}
