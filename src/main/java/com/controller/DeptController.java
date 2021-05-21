package com.controller;

import com.domain.Dept;
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
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value = "/dept/")
    public ModelAndView index2(ModelAndView mv) {
        mv.setViewName("dept/list");
        return mv;
    }

    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value = "/dept/{formName}")
    public String index2(@PathVariable String formName) {
//		return formName;
        String blank = "/dept/list";
        return blank;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public String index(Model model, String content) {
        List<Dept> dept_list = rainservice.findAllDept();
        if (content != null) {
            dept_list = rainservice.findAllDept(content);
        }
        model.addAttribute("list", dept_list);
        return "dept/list";
    }

    @RequestMapping(value = "/dept/list2", method = RequestMethod.GET)
    public String index1(HttpSession session, Model model) {
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String content = (rainservice.get_Info((rainservice.get_EmployeeInfo(user.getEmployee_id())).getDept_id())).getName();
        List<Dept> dept_list = rainservice.findAllDept(content);
        model.addAttribute("list", dept_list);
        return "dept/list2";
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public String add(Model model, Integer id) {
        if (id != null) {
            Dept dept = rainservice.get_Info(id);
            model.addAttribute("dept", dept);
        }
        return "/dept/add";
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView mv, @ModelAttribute Dept dept, Integer id, HttpSession session) {
        if (id != null) {
            rainservice.update_Info(dept);
        } else {
            rainservice.addDept(dept);
        }
        if (new Integer((Integer) session.getAttribute("tip")) == 3) {
            mv.setViewName("redirect:/dept/list");
        } else {
            mv.setViewName("dept/list2");
        }
        return mv;
    }

    @RequestMapping(value = "/dept/delete", method = RequestMethod.GET)
    public void delete(Integer id) {
        if (id != null) {
            rainservice.delete_Info(id);
        }
    }
}
