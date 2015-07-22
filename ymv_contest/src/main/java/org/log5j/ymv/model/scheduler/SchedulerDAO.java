package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import org.log5j.ymv.model.board.BoardVO;

public interface SchedulerDAO {

	List<BoardVO> findSchedulerList(SchedulerVO sdvo);

	int totalContent(SearchVO scvo);

	List<BoardVO> findSearchList(SearchVO scvo);

	List<HashMap> findDateList(SchedulerVO sdvo);

	SchedulerVO checkScheduler(String memberNo);

	void registerScheduler(SchedulerVO sdvo);

	void updateScheduler(SchedulerVO sdvo);

	int findRecruitTotalContent(String search);

	List<BoardVO> findRecruitBoardList(SearchBoardVO sebvo);

	int findNoticeBoardTotalContent(String search);

	List<BoardVO> findNoticeBoardList(SearchBoardVO sebvo);

	List<BoardVO> findReviewBoardList(SearchBoardVO sebvo);

	int findReviewBoardTotalContent(String search);

	List<BoardVO> findQnABoardList(SearchBoardVO sebvo);

	int findQnABoardTotalContent(String search);

	List<BoardVO> findThreeRecruitBoardList(String search);

	List<BoardVO> findThreeNoticeBoardList(String search);

	List<BoardVO> findThreeReviewBoardList(String search);

	List<BoardVO> findThreeQnABoardList(String search);
}
