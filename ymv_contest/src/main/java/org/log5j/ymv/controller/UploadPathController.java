package org.log5j.ymv.controller;

import java.io.File;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.NoticeBoardService;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadPathController {

	@Resource(name="uploadReviewPath")
	private String reviewPath;
	
	@Resource(name="uploadNoticePath")
	private String noticePath;
	
	@Resource(name="uploadProfilePath")
	private String profilePath;
	
	@Resource(name="memberServiceImpl")
	private MemberService memberService;
	
	@Resource(name="noticeBoardServiceImpl")
	private NoticeBoardService noticeBoardService;
	
	@RequestMapping("upload_profile_path.ymv")
	public String registerProfilePath(MemberVO mvo,PictureVO pvo) {
		MultipartFile file=pvo.getFileName();
		ModelAndView mav = new ModelAndView();
		mav.addObject("mvo",mvo);
			String fileName="[memberNo"+mvo.getMemberNo()+"]"+file.getOriginalFilename();			
			String filePath="profileupload\\"+fileName;
			if(!fileName.equals("")/*&&(fileName.contains(".jpg")||fileName.contains(".png") )*/){
				try {
					mvo.setFilePath(filePath);
					pvo.setPictureNo(mvo.getMemberNo());
					file.transferTo(new File(profilePath+fileName));
					System.out.println("PictureNo: "+pvo.getPictureNo()+" fileName: "+pvo.getFileName());
					
					System.out.println("fileupload ok:"+fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			return "forward:member_update_profile.ymv";
			
	}
	@RequestMapping("upload_notice_path.ymv")
	public ModelAndView registerNoticeFilePath(NoticeBoardVO nvo,PictureVO pvo) {
		MultipartFile file=pvo.getFileName();
		String fileName="["+nvo.getBoardNo()+"]"+file.getOriginalFilename();			
		String filePath="noticeupload\\"+fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(nvo.getBoardNo());
		if(!fileName.equals("")){
			try {
				file.transferTo(new File(noticePath+fileName));
				noticeBoardService.registerPicture(pvo);
			} catch (Exception e) {					
				e.printStackTrace();
			}
		}	
			return new ModelAndView("redirect:notice_board.ymv");
	}
	   
/*
	@Override
	public PictureVO registerReviewFilePath(ReviewBoardVO rbvo, PictureVO pvo) {
		MultipartFile file=pvo.getFileName();
		
		 *  파일 얻는 메서드  : list.get(i) 을 호출하면 File이 반환 
		 *  실제 디렉토리로 전송(업로드) 메서드 : 파일.transferTo(파일객체)
		 *  ModelAndView 에서 결과 페이지로 업로드한 파일 정보를 문자열배열로
		 *  할당해 jsp에서 사용하도록 한다. 
		 
		String fileName = "[" + rbvo.getBoardNo() + "]"+ file.getOriginalFilename();
		String filePath = "upload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(rbvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(reviewPath + fileName));
				// 픽쳐 디비에 파일정보 저장
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pvo;
	}

	@Override
	public PictureVO registerNoticeFilePath(NoticeBoardVO nvo, PictureVO pvo) {
		MultipartFile file=pvo.getFileName();
		
		 *  파일 얻는 메서드  : list.get(i) 을 호출하면 File이 반환 
		 *  실제 디렉토리로 전송(업로드) 메서드 : 파일.transferTo(파일객체)
		 *  ModelAndView 에서 결과 페이지로 업로드한 파일 정보를 문자열배열로
		 *  할당해 jsp에서 사용하도록 한다. 
		 
			String fileName="["+nvo.getBoardNo()+"]"+file.getOriginalFilename();			
			String filePath="noticeupload\\"+fileName;
			pvo.setFilePath(filePath);
			pvo.setPictureNo(nvo.getBoardNo());
			if(!fileName.equals("")){
				try {
					file.transferTo(new File(noticePath+fileName));
					// 픽쳐 디비에 파일정보 저장
					
					nameList.add(fileName);
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			return pvo;		
	}*/
}
