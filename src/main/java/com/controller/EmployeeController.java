package com.controller;

import com.domain.Dept;
import com.domain.Employee;
import com.domain.Job;
import com.domain.User;
import com.service.RainService;
import com.util.jsonClass.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value = "/employee/")
    public ModelAndView index2(ModelAndView mv) {
        mv.setViewName("employee/list");
        return mv;
    }

    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value = "/employee/{formName}")
    public String index2(@PathVariable String formName) {
        String blank = "/employee/list";
        return blank;
    }

    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public String index(Model model, String content) {
        List<Employee> employee_list = rainservice.get_EmployeeList();
        if (content != null) {
            employee_list = rainservice.get_EmployeeLikeList(content);
        }
        model.addAttribute("list", employee_list);
        return "employee/list";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.GET)
    public String add(Model model, Integer id) {
        if (id != null) {
            Employee employee = rainservice.get_EmployeeInfo(id);
            model.addAttribute("employee", employee);
        }
        List<Dept> dept_list = rainservice.findAllDept();
        List<Job> job_list = rainservice.findAllJob();
        model.addAttribute("job_list", job_list);
        model.addAttribute("dept_list", dept_list);
        return "/employee/add";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView mv, @ModelAttribute Employee employee, Integer id) {
        if (id != null) {
            rainservice.update_EmployeeInfo(employee);
        } else {
            rainservice.insert_EmployeeInfo(employee);
        }
        User user = rainservice.get_UserInfoByEmployeeId(id);
        if (user != null) {
            user.setUsername(employee.getName());
            user.setLoginname(employee.getLogin_name());
            user.setPassword(employee.getPassword());
            rainservice.update_UserInfo(user);
        } else {
            user = new User(rainservice.get_EmployeeIdByName(employee.getName()).getId(), employee.getName(), employee.getLogin_name(), employee.getPassword(), 2);
            rainservice.insert_UserInfo(user);
        }
        mv.setViewName("redirect:/employee/list");
        return mv;
    }

    @RequestMapping(value = "/employee/delete", method = RequestMethod.GET)
    public void delete(Integer id) {
        if (id != null) {
            rainservice.delete_EmployeeInfo(id);
        }
    }

    @RequestMapping("/employee/table")
    @ResponseBody
    public Page<Employee> attendance_table(int page, int limit, String userName) {
        Page<Employee> date = rainservice.employee_list(page, limit, userName);
        return date;
    }
}
