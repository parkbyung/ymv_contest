package org.log5j.ymv.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.board.AuctionBoardVO;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.board.ReviewBoardVO;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.sponsor.SponsorVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadPathController {

	@Resource(name = "uploadReviewPath")
	private String reviewPath;

	@Resource(name = "uploadNoticePath")
	private String noticePath;

	@Resource(name = "uploadProfilePath")
	private String profilePath;

	@Resource(name = "uploadAuctionPath")
	private String auctionPath;
	
	@Resource(name = "uploadSponsorPath")
	private String sponsorPath;

	@RequestMapping("upload_profile_path.ymv")
	public String registerProfilePath(HttpServletRequest request, PictureVO pvo, ModelAndView mav) {
		MemberVO mvo=(MemberVO)request.getSession().getAttribute("mvo");
		MultipartFile file = pvo.getFileName();
		String fileName = "[memberNo" + mvo.getMemberNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "profileupload\\" + fileName;
		if (!fileName.equals("")) {
			try {
				mvo.setFilePath(filePath);
				pvo.setPictureNo(mvo.getMemberNo());
				file.transferTo(new File(profilePath + fileName));
				System.out.println("PictureNo: " + pvo.getPictureNo()
						+ " fileName: " + pvo.getFileName());
				System.out.println("fileupload ok:" + fileName);
				System.out.println(filePath);
				mav.addObject("mvo", mvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "forward:member_update_profile.ymv";
	}

	@RequestMapping("upload_notice_path.ymv")
	public String registerNoticeFilePath(NoticeBoardVO nvo, PictureVO pvo) {
		MultipartFile file = pvo.getFileName();
		ModelAndView mav = new ModelAndView();
		String fileName = "[" + nvo.getBoardNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "noticeupload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(nvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(noticePath + fileName));
				mav.addObject("pvo", pvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "notice_register_file.ymv";
	}

	@RequestMapping("upload_review_path.ymv")
	public String registerReviewFilePath(ReviewBoardVO rbvo, PictureVO pvo) {
		MultipartFile file = pvo.getFileName();
		ModelAndView mav = new ModelAndView();
		String fileName = "[" + rbvo.getBoardNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "reviewupload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(rbvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(reviewPath + fileName));
				// 픽쳐 디비에 파일정보 저장
				mav.addObject("pvo", pvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "forward:review_register_file.ymv";
	}
	
	@RequestMapping("upload_auction_path.ymv")
	public String registerAuctionFilePath(AuctionBoardVO abvo, PictureVO pvo) {
		MultipartFile file=pvo.getFileName();
		ModelAndView mav = new ModelAndView();
		String fileName="["+abvo.getBoardNo()+"]"+file.getOriginalFilename();			
		String filePath="auctionupload\\"+fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(abvo.getBoardNo());
		if(!fileName.equals("")){
			try {
				file.transferTo(new File(auctionPath+fileName));
				mav.addObject("pvo", pvo);
				} catch (Exception e) {					
				e.printStackTrace();
			}
		}
		return "forward:auction_register_file.ymv";
	}
	
	@RequestMapping("upload_sponsor_path.ymv")
	public String registerSponsorFilePath(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		PictureVO pvo=(PictureVO)request.getSession().getAttribute("pvo");
		SponsorVO spvo=(SponsorVO)request.getSession().getAttribute("spvo");
		String hidden = (String) request.getSession().getAttribute("hidden");
		MultipartFile file = pvo.getFileName();
		ModelAndView mav = new ModelAndView();
		String fileName = "[" + spvo.getBoardNo() + "]"
				+ file.getOriginalFilename();
		String filePath = "sponsorupload\\" + fileName;
		pvo.setFilePath(filePath);
		pvo.setPictureNo(spvo.getBoardNo());
		if (!fileName.equals("")) {
			try {
				file.transferTo(new File(sponsorPath + fileName));
				mav.addObject("pvo", pvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("pvo", pvo);
		if(hidden.equals("register")){
			return "forward:sponsor_register_file.ymv";
		}
		return "forward:sponsor_update_file.ymv";
	}
}
