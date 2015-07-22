package org.log5j.ymv.model.scheduler;

import java.util.HashMap;
import java.util.List;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;

public interface SchedulerService {

	public abstract List<BoardVO> findSchedulerList(SchedulerVO sdvo);

	ListVO findSearchList(SearchVO scvo);

	public abstract List<HashMap> findDateList(SchedulerVO sdvo);

	public abstract SchedulerVO checkScheduler(String parameter);

	public abstract void registerScheduler(SchedulerVO sdvo);

	public abstract void updateScheduler(SchedulerVO sdvo);
	
	public ListVO findRecruitBoardList(SearchBoardVO sebvo);

	public ListVO findNoticeBoardList(SearchBoardVO sebvo);

	public ListVO findReviewBoardList(SearchBoardVO sebvo);

	public ListVO findQnABoardList(SearchBoardVO sebvo);

	public List<BoardVO> findThreeRecruitBoardList(String search);

	public List<BoardVO> findThreeNoticeBoardList(String search);

	public List<BoardVO> findThreeReviewBoardList(String search);

	public List<BoardVO> findThreeQnABoardList(String search);

}