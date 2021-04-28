package com.controller;

import com.domain.Leave;
import com.domain.Notice;
import com.domain.Salary;
import com.domain.User;
import com.service.RainService;
import com.util.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class LeaveController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value = "/leave/")
    public ModelAndView index2(ModelAndView mv) {
        mv.setViewName("leave/list");
        return mv;
    }

    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value = "/leave/{formName}")
    public String index2(@PathVariable String formName) {
        String blank = "/leave/list";
        return blank;
    }

    @RequestMapping(value = "/leave/list", method = RequestMethod.GET)
    public String index(Model model, String content) {
        List<Leave> leave_list = rainservice.get_LeaveList();
        if (content != null) {
            leave_list = rainservice.get_LeaveLikeList(content);
        }
        model.addAttribute("list", leave_list);
        return "/leave/list";
    }
    @RequestMapping(value="/leave/enable",method=RequestMethod.GET)
    public void enable(Integer leave_id){
        if(leave_id!=null){
            rainservice.enable_Leave(leave_id);
        }
    }
    @RequestMapping(value="/leave/add",method=RequestMethod.GET)
    public String add(Model model){
            Leave leave=new Leave();
            model.addAttribute("leave",leave);
        return "/leave/add";
    }

    @RequestMapping(value="/leave/add",method=RequestMethod.POST)
    public ModelAndView add(ModelAndView mv, @ModelAttribute Leave leave, HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        leave.setEmployee_id(user.getId());
        leave.setName(user.getUsername());
        leave.setEnable(false);
        rainservice.insert_leave(leave);
        mv.setViewName("redirect:/leave/list");
        return mv;
    }
}
