package com.controller;

import com.domain.Attendance;
import com.domain.User;
import com.service.RainService;
import com.util.TimeGenerate;
import com.util.common.Constants;
import com.util.jsonClass.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

        //得到用户的编号
        Integer employee_id=rainservice.get_EmployeeIdByName(name).getId();
        //得到这一天所有的考勤记录
        List<Attendance> attendances_onday=rainservice.get_AttendanceId(day);
        Integer attendance_id=null;
        //找到这位用户的记录
        for (Attendance date: attendances_onday) {
            if(date.getName().equals(name)){
                attendance_id=date.getAttendance_Id();
            }
        }
        //找到这位用户的记录
        String hour=TimeGenerate.gethour();
        Attendance attendance=new Attendance();
        switch (TimeGenerate.timesort()){
            case 1:
                attendance.setRecord1(hour);
                break;
            case 2:
                attendance.setRecord2(hour);
                break;
            case 3:
                attendance.setRecord3(hour);
                break;
            case 4:
                attendance.setRecord4(hour);
                break;
            case 5:
                attendance.setRecord5(hour);
                break;
            case 6:
                attendance.setRecord6(hour);
                break;
        }
        if (attendance_id != null) {
            attendance.setAttendance_Id(attendance_id);
            rainservice.update_AttendanceInfo(attendance);
        } else {
            attendance.setEmployee_id(employee_id);
            attendance.setName(name);
            attendance.setDay(day);
            rainservice.insert_AttendanceInfo(attendance);
        }
    }

    @RequestMapping("/attendance/table")
    @ResponseBody
    public Page<Attendance> attendance_table(int page, int limit, String day, String name) {
        Page<Attendance> date = rainservice.attendance_list(page, limit, day, name);
        return date;
    }

    @RequestMapping(value = "/attendance/analyse_onday")
    public String analyse_onday() {
        String blank = "/attendance/analyse";
        return blank;
    }
}
