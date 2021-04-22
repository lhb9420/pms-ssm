package com.controller;

import com.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SalaryController {
    @RequestMapping(value="/salary/")
    public ModelAndView index2(ModelAndView mv){
        mv.setViewName("salary/list");
        return mv;
    }
    @RequestMapping(value="/salary/list",method= RequestMethod.GET)
    public String index(){
        return "salary/list";
    }
}
