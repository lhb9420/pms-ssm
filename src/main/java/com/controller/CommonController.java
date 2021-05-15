package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		// 作为一个空方法，可以匹配任何无效输入，再跳转到404
		return formName;
//		String blank = "blank";
//		return blank;
	}

	@RequestMapping(value = "/")
	public String index() {
		String blank = "index";
		return blank;
	}

	@RequestMapping(value = "/welcome3")
	public String welcome3() {
		return "welcome3";
	}

	@RequestMapping(value = "/welcome2")
	public String welcome2() {
		return "welcome2";
	}

	@RequestMapping(value = "/welcome1")
	public String welcome1() {
		return "welcome1";
	}
}
