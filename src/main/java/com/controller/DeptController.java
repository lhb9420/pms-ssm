package com.controller;

import com.domain.Dept;
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

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public String add(Model model, Integer id) {
        if (id != null) {
            Dept dept = rainservice.get_Info(id);
            model.addAttribute("dept", dept);
        }
        return "/dept/add";
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView mv, @ModelAttribute Dept dept, Integer id) {
        if (id != null) {
            rainservice.update_Info(dept);
        } else {
            rainservice.addDept(dept);
        }
        mv.setViewName("redirect:/dept/list");
        return mv;
    }

    @RequestMapping(value = "/dept/delete", method = RequestMethod.GET)
    public void delete(Integer id) {
        if (id != null) {
            rainservice.delete_Info(id);
        }
    }
}
