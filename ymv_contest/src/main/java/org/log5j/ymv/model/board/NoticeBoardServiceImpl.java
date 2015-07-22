package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Resource
	private NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public ListVO findNoticeBoardList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = noticeBoardDAO.findNoticeBoardList(pageNo);
		System.out.println("ServiceImpl list: "+list);
		int total = noticeBoardDAO.totalContent();
		System.out.println("ServiceImpl total: "+total);
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		System.out.println("ServiceImpl paging: "+paging);
		ListVO lvo = new ListVO(list, paging);
		System.out.println("ServiceImpl lvo: "+lvo);
		
		return lvo;
	}

	@Override
	public void registerNoticeBoard(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.registerNoticeBoard(vo);
	}

	@Override
	public BoardVO findNoticeBoardByBoardNo(int boardNo) {
		// TODO Auto-generated method stub
		return noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
	}

	@Override
	public void noticeBoardUpdate(NoticeBoardVO vo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.noticeBoardUpdate(vo);
	}

	@Override
	public void noticeBoardDelete(String boardNo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.noticeBoardDelete(boardNo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.registerPicture(pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		// TODO Auto-generated method stub
		return noticeBoardDAO.findPicture(pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		// TODO Auto-generated method stub
		noticeBoardDAO.deletePicture(pictureNo);
	}
	
	@Override
	public void findPostingByNoticeBoardNoNotHit(int boardNo) {
		noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
		
	}

	@Override
	public NoticeBoardVO findPostingByNoticeBoardNoUpdateHit(int boardNo) {
		noticeBoardDAO.updateHit(boardNo);
		NoticeBoardVO nvo = (NoticeBoardVO) noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
		System.out.println(nvo);
		return nvo;
	}

}
