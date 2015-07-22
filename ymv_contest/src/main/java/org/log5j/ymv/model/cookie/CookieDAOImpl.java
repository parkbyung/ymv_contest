package org.log5j.ymv.model.cookie;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class CookieDAOImpl implements CookieDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;	

	@Override
	public void updateHit(int no,BoardVO boardVO) {
		String temp = boardVO.getClass().getName();
		if(temp.equals("org.log5j.ymv.model.board.RecruitBoardVO")){
			sqlSessionTemplate.update("recruitboard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.ReviewBoardVO")){
			sqlSessionTemplate.update("reviewBoard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.NoticeBoardVO")){
			sqlSessionTemplate.update("noticeBoard.updateHit",no);
		}else if (temp.equals("org.log5j.ymv.model.board.QnABoardVO")){
			sqlSessionTemplate.update("qnaBoard.updateHit",no);
		}
	}
}
