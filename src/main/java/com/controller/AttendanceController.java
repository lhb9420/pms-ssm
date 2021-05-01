package com.controller;

import com.domain.Attendance;
import com.domain.User;
import com.service.RainService;
import com.util.TimeGenerate;
import com.util.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "/attendance/sign-in",method = RequestMethod.GET)
    public String signin(){
        return "/attendance/sign-in";
    }

    @RequestMapping(value = "/attendance/sign",method = RequestMethod.GET)
    public void sign(HttpSession session){
        User user = (User) session.getAttribute(Constants.USER_SESSION);
        String name=user.getUsername();
        String day= TimeGenerate.getday();
        String hour=TimeGenerate.gethour();
        Integer employee_id=rainservice.get_EmployeeIdByName(name).getId();
        List<Attendance> attendances_onday=rainservice.get_AttendanceId(day);
        Integer addendance_id=null;
        for (Attendance date: attendances_onday) {
            if(date.getName().equals(name)){
                addendance_id=date.getAttendance_Id();
            }
        }
        if(addendance_id!=null){
            Attendance attendance=new Attendance(addendance_id,hour);
            rainservice.update_AttendanceInfo(attendance);
        }else{
            Attendance attendance=new Attendance(employee_id,name,day,hour);
            rainservice.insert_AttendanceInfo(attendance);
        }
    }
}
