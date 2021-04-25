package com.controller;

import com.domain.Dept;
import com.domain.Employee;
import com.domain.Job;
import com.domain.Salary;
import com.service.RainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SalaryController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/salary/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("salary/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/salary/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/salary/list";
			return blank;
		}
		@RequestMapping(value="/salary/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<Salary> salary_list = rainservice.get_SalaryList();
			if (content!=null){
				salary_list = rainservice.get_SalaryLikeList(content);
			}
			model.addAttribute("list",salary_list);
			return "/salary/list";
		}
}
