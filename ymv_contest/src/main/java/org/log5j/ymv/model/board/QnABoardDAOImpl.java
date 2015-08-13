package org.log5j.ymv.model.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class QnABoardDAOImpl implements QnABoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 
	 *@param pageNo : 페이지번호를 받아온다.
	 *@return ListVO:  페이지 번호에 해당하는 목록 list 를 return 한다.
	 *@작성자 : 장지윤
	 *@Method설명 : 페이지 번호를 받아와 해당하는 리스트를 뽑는다.
	 */
	@Override
	public List<BoardVO> findQnABoardList(String pageNo){
		List<BoardVO> list = sqlSessionTemplate.selectList("qnaBoard.findQnABoardList",pageNo);
		return list;
	}
	/**
	 * 
	 *@작성자 : 장지윤
	 *@Method설명 : 전체 글 수를 return 해온다.
	 */
	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("qnaBoard.totalQnABoardContent");
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :쓴 내용을 가져와 QnABoard에 등록한다.
	 */
	@Override
	public void registerQnABoard(QnABoardVO qvo){
		sqlSessionTemplate.delete("qnaBoard.registerQnABoard",qvo);
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :qna 번호를 통해 글을 찾아 return 한다.
	 */
	@Override
	public QnABoardVO findQnABoardByQnANo(int qnaNo){
		return sqlSessionTemplate.selectOne("qnaBoard.findQnABoardByQnANo",qnaNo);
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :수정된 글을 불러와 수정한다.
	 */
	@Override
	public void updateQnABoard(QnABoardVO qnABoardVO){
		sqlSessionTemplate.update("qnaBoard.updateQnABoard",qnABoardVO);
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :qna 글번호를 통해 글을 삭제한다
	 */
	@Override
	public void deleteQnABoard(int qnaNo){
		sqlSessionTemplate.delete("qnaBoard.deleteQnABoard",qnaNo);
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :ref와 restep을 가져와 map에 넣어 count를 늘린다.
	 */
	@Override
    public void updateRestep(int ref, int restep){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("qnaBoard.updateRestep", map);		
	}
	/**
	 *@작성자 : 장지윤
	 *@Method설명 :쓴 내용을 가져와 QnABoard에 등록한다.
	 */
	@Override
	public void replyQnABoard(QnABoardVO qvo){
		sqlSessionTemplate.insert("qnaBoard.replyQnABoard", qvo);		
	}
	
	@Override
	public void findQnABoardByQnaNoNotHit(int qnaNo) {
		sqlSessionTemplate.selectOne("qnaBoard.findQnABoardByQnANo",qnaNo);
	}

	@Override
	public void updateHit(int qnaNo) {
		sqlSessionTemplate.update("qnaBoard.updateHit",qnaNo);
		
	}
	
	@Override
	public int checkReply(int qnaNo){
		return sqlSessionTemplate.selectOne("qnaBoard.checkReply",qnaNo);
	}
}
