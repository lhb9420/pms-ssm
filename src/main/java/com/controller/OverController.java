package com.controller;

import com.domain.Overtime;
import com.domain.User;
import com.service.RainService;
import com.util.common.Constants;
import com.util.jsonClass.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class OverController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value = "/overtime/")
    public ModelAndView index2(ModelAndView mv) {
        mv.setViewName("leave/list");
        return mv;
    }

    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value = "/overtime/{formName}")
    public String index2(@PathVariable String formName) {
        String blank = "/overtime/list";
        return blank;
    }

    @RequestMapping(value = "/overtime/list", method = RequestMethod.GET)
    public String index() {
        return "/overtime/list";
    }

    @RequestMapping(value = "/overtime/list1", method = RequestMethod.GET)
    public String index1() {
        return "/overtime/list1";
    }

    @RequestMapping("/overtime/table")
    @ResponseBody
    public Page<Overtime> attendance_table(int page, int limit, String day, String name) {
        Page<Overtime> date = rainservice.overtime_list(page, limit, day, name);
        return date;
    }

    @RequestMapping("/overtime/table1")
    @ResponseBody
    public Page<Overtime> attendance_table1(HttpSession session, int page, int limit, String day) {
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String name = user.getUsername();
        Page<Overtime> date = rainservice.overtime_list(page, limit, day, name);
        return date;
    }
}
