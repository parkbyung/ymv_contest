package org.log5j.ymv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home.ymv")
	@NoLoginCheck
	public String test(){
		return "home";
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @return
	 */
	@RequestMapping("loginCheck.ymv")
	@NoLoginCheck
	public String loginCheck(){
		return "loginCheck";
	}
}
