package com.controller;

import com.domain.Attendance;
import com.domain.Leave;
import com.domain.Overtime;
import com.service.RainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    public String index(Model model, String content) {
        List<Attendance> attendance_list;
        if (content != null) {
            attendance_list = rainservice.get_AttenanceLikeList(content);
        } else {
            attendance_list = rainservice.get_AttendanceList();
        }
        List<Overtime> overtime_list = new ArrayList<>();
        for (int i = 0; i < attendance_list.size(); i++) {
            if (attendance_list.get(i).getRecord5()!=null){
                overtime_list.add(new Overtime(attendance_list.get(i).getName(),attendance_list.get(i).getDay(),attendance_list.get(i).getRecord5(),attendance_list.get(i).getRecord6()));
            }
        }
        model.addAttribute("list", overtime_list);
        return "/overtime/list";
    }
}
