package com.controller;

import com.domain.Notice;
import com.domain.User;
import com.service.RainService;
import com.util.common.Constants;
import com.util.jsonClass.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NoticeController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/notice/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("notice/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/notice/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/notice/list";
			return blank;
		}
		@RequestMapping(value="/notice/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<Notice> notict_list = rainservice.get_NoticeList();
			if (content!=null){
				notict_list = rainservice.get_NoticeLikeList(content);
			}
			model.addAttribute("list",notict_list);
			return "notice/list";
		}
		@RequestMapping(value="/notice/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				Notice notice = rainservice.get_NoticeInfo(id);
				model.addAttribute("notice",notice);
			}
			return "/notice/add";
		}
		@RequestMapping(value="/notice/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv, @ModelAttribute Notice notice , Integer id, HttpSession session){
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			notice.setUser_id(user.getId());
			notice.setName(user.getUsername());
			if(id!=null){
				rainservice.update_NoticeInfo(notice);
			}else{
				rainservice.insert_NoticeInfo(notice);
			}
			mv.setViewName("redirect:/notice/list");
			return mv;
		}

	@RequestMapping(value = "/notice/delete", method = RequestMethod.GET)
	public void delete(Integer id) {
		if (id != null) {
			rainservice.delete_NoticeInfo(id);
		}
	}

	@RequestMapping("/notice/table")
	@ResponseBody
	public Page<Notice> attendance_table() {
		Page<Notice> date = rainservice.notice_list();
		return date;
	}
}
