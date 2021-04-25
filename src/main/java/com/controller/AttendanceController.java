package com.controller;

import com.domain.Attendance;
import com.domain.Leave;
import com.service.RainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value = "/attendance/")
    public ModelAndView index2(ModelAndView mv) {
        mv.setViewName("attendance/list");
        return mv;
    }

    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value = "/attendance/{formName}")
    public String index2(@PathVariable String formName) {
        String blank = "/attendance/list";
        return blank;
    }

    @RequestMapping(value = "/attendance/list", method = RequestMethod.GET)
    public String index(Model model, String content) {
        List<Attendance> attendance_list = rainservice.get_AttendanceList();
        if (content != null) {
            attendance_list = rainservice.get_AttenanceLikeList(content);
        }
        model.addAttribute("list", attendance_list);
        return "/attendance/list";
    }
}
