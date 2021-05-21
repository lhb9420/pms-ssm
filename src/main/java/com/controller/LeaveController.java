package com.controller;

import com.domain.Leave;
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
import java.util.ArrayList;
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

    @RequestMapping(value = "/leave/list2", method = RequestMethod.GET)
    public String index1(HttpSession session, Model model, String content) {
        List<Leave> leave_list = rainservice.get_LeaveList();
        if (content != null) {
            leave_list = rainservice.get_LeaveLikeList(content);
        }
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String name = user.getUsername();
        List<Leave> temp = new ArrayList<>();
        for (Leave a : leave_list) {
            if ((rainservice.get_EmployeeIdByName(a.getName())).getDept_id() == (rainservice.get_EmployeeIdByName(name)).getDept_id()) {
                temp.add(a);
            }
        }
        model.addAttribute("list", temp);
        return "/leave/list2";
    }

    @RequestMapping(value = "/leave/list1", method = RequestMethod.GET)
    public String index1(HttpSession session, Model model) {
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String name = user.getUsername();
        List<Leave> leave_list = rainservice.get_LeaveLikeList(name);
        model.addAttribute("list", leave_list);
        return "/leave/list1";
    }

    @RequestMapping(value = "/leave/enable", method = RequestMethod.GET)
    public void enable(Integer leave_id) {
        if (leave_id != null) {
            rainservice.enable_Leave(leave_id);
        }
    }

    @RequestMapping(value = "/leave/add", method = RequestMethod.GET)
    public String add(Model model) {
        Leave leave = new Leave();
        model.addAttribute("leave", leave);
        return "/leave/add";
    }

    @RequestMapping(value = "/leave/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView mv, @ModelAttribute Leave leave, HttpSession session) {
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        leave.setEmployee_id(user.getId());
        leave.setName(user.getUsername());
        leave.setEnable(false);
        rainservice.insert_leave(leave);
        if (new Integer((Integer) session.getAttribute("tip")) == 3) {
            mv.setViewName("redirect:/leave/list");
        } else {
            mv.setViewName("redirect:/leave/list1");
        }
        return mv;
    }
}
