package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class SchedulerDAOImpl implements SchedulerDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> findSchedulerList(SchedulerVO sdvo) {
		System.out.println("DAO Scheduler"+sdvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.findSchedulerList",sdvo);
		return list;
	}
	@Override
	public List<BoardVO> findSearchList(SearchVO scvo) {
		System.out.println("DAO Search"+scvo);
		List<BoardVO> list = sqlSessionTemplate.selectList("scheduler.findSearchList",scvo);
		return list;
	}

	@Override
	public int totalContent(SearchVO scvo) {
		return sqlSessionTemplate.selectOne("scheduler.totalContent",scvo);
	}
	@Override
	public List<HashMap> findDateList(SchedulerVO sdvo) {
		return sqlSessionTemplate.selectList("scheduler.findDateList",sdvo);
	}
	@Override
	public SchedulerVO checkScheduler(String memberNo) {
		
		return sqlSessionTemplate.selectOne("scheduler.checkScheduler",memberNo);
	}
	@Override
	public void registerScheduler(SchedulerVO sdvo) {
		sqlSessionTemplate.insert("scheduler.registerScheduler",sdvo);
	}
	@Override
	public void updateScheduler(SchedulerVO sdvo) {
		sqlSessionTemplate.update("scheduler.updateScheduler",sdvo);
	}

	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 목록 중에서 제목과 상세 내용중 검색한 단어가 포함 된 글의 목록을 가져온다.
	 * @param sebvo : 검색어와 페이지 번호를 같이 담기위해 사용
	 * @return list
	 */
	@Override
	public List<BoardVO> findRecruitBoardList(SearchBoardVO sebvo) {
		List<BoardVO> list =  sqlSessionTemplate.selectList("search.findRecruitBoardList",sebvo);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 목록 중에서 제목과 상세내용에 검색한 단어가 포함 된 글이 몇개 인지 보여준다.
	 * @param search : 검색된 단어
	 * @return int
	 */
	@Override
	public int findRecruitTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.findRecruitTotalContent",search);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 공지사항 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가져온다.
	 * @param sebvo : 검색어와 페이지 번호를 같이 담기위해 사용
	 * @return list
	 */
	@Override
	public List<BoardVO> findNoticeBoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.findNoticeBoardList",sebvo);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 공지사항 목록 중에서 제목과 작성자, 상세내용에 검색한 단어가 포함 된 글이 몇개 인지 보여준다.
	 * @param search : 검색된 단어
	 * @return int
	 */
	@Override
	public int findNoticeBoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.findNoticeBoardTotalContent",search);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사후기 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가져온다.
	 * @param sebvo : 검색어와 페이지 번호를 같이 담기위해 사용
	 * @return list
	 */
	@Override
	public List<BoardVO> findReviewBoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.findReviewBoardList",sebvo);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사후기 목록 중에서 제목과 작성자, 상세내용에 검색한 단어가 포함 된 글이 몇개 인지 보여준다.
	 * @param search : 검색된 단어
	 * @return int
	 */
	@Override
	public int findReviewBoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.findReviewBoardTotalContent",search);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : QnA 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가져온다.
	 * @param sebvo : 검색어와 페이지 번호를 같이 담기위해 사용
	 * @return list
	 */
	@Override
	public List<BoardVO> findQnABoardList(SearchBoardVO sebvo) {
		return sqlSessionTemplate.selectList("search.findQnABoardList",sebvo);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : QnA 목록 중에서 제목과 작성자, 상세내용에 검색한 단어가 포함 된 글이 몇개 인지 보여준다.
	 * @param search : 검색된 단어
	 * @return int
	 */
	@Override
	public int findQnABoardTotalContent(String search) {
		return sqlSessionTemplate.selectOne("search.findQnABoardTotalContent",search);
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 목록 중에서 제목과 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeRecruitBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.findThreeRecruitBoardList", search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 공지사항 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeNoticeBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.findThreeNoticeBoardList", search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : 봉사 후기 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeReviewBoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.findThreeReviewBoardList", search);
		return list;
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : QnA 목록 중에서 제목과 작성자, 상세 내용중 검색한 단어가 포함 된 글의 목록을 가장 최근 글 3개만 가져온다.
	 * @param search : 검색된 단어
	 * @return list
	 */
	@Override
	public List<BoardVO> findThreeQnABoardList(String search) {
		List<BoardVO> list = sqlSessionTemplate.selectList("search.findThreeQnABoardList", search);
		return list;
	}

}
