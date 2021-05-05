package com.service.impl;

import com.dao.*;
import com.domain.*;
import com.service.RainService;
import com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("RainService")
public class RainServiceImpl implements RainService {

    @Autowired
    private DeptDao deptDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private EmployeeDao employeedao;
    @Autowired
    private NoticeDao noticedao;
    @Autowired
    private UserDao userdao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private AttendanceDao attendanceDao;

    /**
     * 部门信息的管理
     */
    @Transactional(readOnly = true)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public void addDept(Dept dept) {
        // TODO Auto-generated method stub
        deptDao.save(dept);
    }

    @Override
    public Dept get_Info(Integer id) {
        // TODO Auto-generated method stub
        Dept dept = deptDao.get_Info(id);
        return dept;
    }

    @Override
    public void update_Info(Dept dept) {
        // TODO Auto-generated method stub
        deptDao.update_Info(dept);
    }

    @Override
    public void delete_Info(Integer id) {
        // TODO Auto-generated method stub
        deptDao.delete_Info(id);
    }

    @Override
    public List<Dept> findAllDept(String content) {
        // TODO Auto-generated method stub
        System.out.println(content);
        return deptDao.selectLikeAllDept(content);
    }

    /**
     * 职位管理的操作
     */
    @Override
    public List<Job> findAllJob() {
        // TODO Auto-generated method stub
        return jobDao.get_List();
    }

    @Override
    public List<Job> findAllJob(String content) {
        // TODO Auto-generated method stub
        return jobDao.get_LikeList(content);
    }

    @Override
    public Job get_JobInfo(Integer id) {
        // TODO Auto-generated method stub
        return jobDao.get_Info(id);
    }

    @Override
    public void update_JobInfo(Job job) {
        // TODO Auto-generated method stub
        jobDao.update_Info(job);
    }

    @Override
    public void insert_JobInfo(Job job) {
        // TODO Auto-generated method stub
        jobDao.insert_Info(job);
    }

    @Override
    public void delete_JobInfo(Integer id) {
        // TODO Auto-generated method stub
        jobDao.delete_Info(id);
    }

    /**
     * 员工信息的管理
     */
    @Override
    public List<Employee> get_EmployeeList() {
        // TODO Auto-generated method stub
        /**
         * 将部门，职位id中的信息提取出来
         */
        List<Employee> list = employeedao.get_List();
        int size = list.size();
        List<Employee> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Employee data = list.get(i);
            Dept dept = deptDao.get_Info(data.getDept_id());
            data.setDept(dept);
            Job job = jobDao.get_Info(data.getJob_id());
            data.setJob(job);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public List<Employee> get_EmployeeLikeList(String content) {
        // TODO Auto-generated method stub
        /**
         * 将部门，职位id中的信息提取出来
         */
        List<Employee> list = employeedao.get_LikeList(content);
        int size = list.size();
        List<Employee> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Employee data = list.get(i);
            Dept dept = deptDao.get_Info(data.getDept_id());
            data.setDept(dept);
            Job job = jobDao.get_Info(data.getJob_id());
            data.setJob(job);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public Employee get_EmployeeInfo(Integer id) {
        // TODO Auto-generated method stub
        Employee data = employeedao.get_Info(id);
        Dept dept = deptDao.get_Info(data.getDept_id());
        data.setDept(dept);
        Job job = jobDao.get_Info(data.getJob_id());
        data.setJob(job);
        return data;
    }

    @Override
    public void update_EmployeeInfo(Employee data) {
        // TODO Auto-generated method stub
        employeedao.update_Info(data);
    }

    @Override
    public void insert_EmployeeInfo(Employee data) {
        // TODO Auto-generated method stub
        /**
         * 将职位id和部门id提取，或者不管，因为直接存到数据库了，不管
         */
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        data.setCreate_date(sdf.format(date));
        System.out.println(data.getPassword() + "0000000000000000");
        employeedao.insert_Info(data);
    }

    @Override
    public void delete_EmployeeInfo(Integer id) {
        // TODO Auto-generated method stub
        System.out.print(id);
        employeedao.delete_Info(id);
    }

    /**
     * 公告管理
     */
    @Override
    public List<Notice> get_NoticeList() {
        // TODO Auto-generated method stub
        return noticedao.get_List();
    }

    @Override
    public List<Notice> get_NoticeLikeList(String content) {
        // TODO Auto-generated method stub
        return noticedao.get_LikeList(content);
    }

    @Override
    public Notice get_NoticeInfo(Integer id) {
        // TODO Auto-generated method stub
        return noticedao.get_Info(id);
    }

    @Override
    public void update_NoticeInfo(Notice notice) {
        // TODO Auto-generated method stub
        noticedao.update_Info(notice);
    }

    @Override
    public void insert_NoticeInfo(Notice notice) {
        // TODO Auto-generated method stub
        noticedao.insert_Info(notice);
    }

    @Override
    public void delete_NoticeInfo(Integer id) {
        // TODO Auto-generated method stub
        noticedao.delete_Info(id);
    }

    @Override
    public User login(String loginname, String password) {
        // TODO Auto-generated method stub
        User user = userdao.get_login(loginname, password);
        return user;
    }

    @Override
    public List<User> get_UserList() {
        // TODO Auto-generated method stub
        return userdao.get_List();
    }

    @Override
    public List<User> get_UserLikeList(String content) {
        // TODO Auto-generated method stub
        return userdao.get_LikeList(content);
    }

    @Override
    public User get_UserInfo(Integer id) {
        // TODO Auto-generated method stub
        return userdao.get_Info(id);
    }

    @Override
    public void update_UserInfo(User user) {
        // TODO Auto-generated method stub
        userdao.update_Info(user);
    }

    @Override
    public void insert_UserInfo(User user) {
        // TODO Auto-generated method stub
//		Date date = new Date();    
//		String year = String.format("%tY", date);   
//		String month = String.format("%tB", date);   
//		String day = String.format("%te", date);   
//		notice.setCreate_date(year+month+day);
        userdao.insert_Info(user);
    }

    @Override
    public void delete_UserInfo(Integer id) {
        // TODO Auto-generated method stub
        userdao.delete_Info(id);
    }

    @Override
    public Employee login2(String loginname, String password) {
        // TODO Auto-generated method stub
        return employeedao.get_ByInfo(loginname, password);
    }

    //工资信息
    @Override
    public List<Salary> get_SalaryList() {
        // TODO Auto-generated method stub
        /**
         * 将工资中的信息提取出来
         */
        List<Salary> list = salaryDao.get_List();
        int size = list.size();
        List<Salary> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Salary data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public List<Salary> get_SalaryLikeList(String content) {
        List<Salary> list = salaryDao.get_LikeList(content);
        int size = list.size();
        List<Salary> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Salary data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    //请假信息
    @Override
    public List<Leave> get_LeaveList() {
        List<Leave> list = leaveDao.get_List();
        int size = list.size();
        List<Leave> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Leave data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public List<Leave> get_LeaveLikeList(String content) {
        List<Leave> list = leaveDao.get_LikeList(content);
        int size = list.size();
        List<Leave> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Leave data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    //考勤信息

    @Override
    public List<Attendance> get_AttendanceList() {
        List<Attendance> list = attendanceDao.get_List();
        int size = list.size();
        List<Attendance> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Attendance data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public List<Attendance> get_AttenanceLikeList(String content) {
        List<Attendance> list = attendanceDao.get_LikeList(content);
        int size = list.size();
        List<Attendance> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Attendance data = list.get(i);
            list2.add(i, data);
        }
        return list2;
    }

    @Override
    public void enable_Leave(Integer leave_id) {
        leaveDao.enable(leave_id);
    }

    @Override
    public void insert_leave(Leave leave) {
        leaveDao.insert(leave);
    }

    @Override
    public Employee get_EmployeeIdByName(String name) {
        return employeedao.get_IdByName(name);
    }

    @Override
    public List<Attendance> get_AttendanceId(String day) {
        return attendanceDao.get_IdByNameAndDay(day);
    }

    @Override
    public void update_AttendanceInfo(Attendance attendance) {
        attendanceDao.update_attendanceInfo(attendance);
    }

    @Override
    public void insert_AttendanceInfo(Attendance attendance) {
        attendanceDao.insert_attendanceInfo(attendance);
    }

    @Override
    public void insert_SalaryInfo(Salary salary) {
        salaryDao.insert_salary(salary);
    }

    @Override
    public User get_UserInfoByEmployeeId(Integer id) {
        return userdao.get_InfoByEmployeeId(id);
    }

    @Override
    public Page<Salary> salary_list(int page, int limit, String name) {
        //计算起始索引
        int start = limit * (page - 1);
        List<Salary> list;
        Page<Salary> p = new Page<>();
        if (name == null) {
            list = salaryDao.getListWithoutNmae(start, limit);
            p.setCount(salaryDao.get_List().size());
        } else {
            list = salaryDao.getList(start, limit, name);
            p.setCount(salaryDao.get_LikeList(name).size());
        }
        //封装分页数据
        p.setData(list);
        return p;
    }

    @Override
    public void delete_salary(Integer salary_id) {
        salaryDao.deleteById(salary_id);
    }

    @Override
    public Page<Attendance> attendance_list(int page, int limit, String day, String name) {
        //计算起始索引
        int start = limit * (page - 1);
        List<Attendance> list;
        Page<Attendance> p = new Page<>();
        if (day == null && name == null) {
            list = attendanceDao.get_list(start, limit);
            p.setCount(attendanceDao.get_List().size());
        } else if (day == null && name != null) {
            list = attendanceDao.getListByName(start, limit, name);
            p.setCount(attendanceDao.get_LikeList(name).size());
        } else if (day != null && name == null) {
            list = attendanceDao.getListByDay(start, limit, day);
            p.setCount(attendanceDao.get_DayLikeList(day).size());
        } else {
            list = attendanceDao.getListByNameAndDay(start, limit, name, day);
            p.setCount(attendanceDao.get_NameDayLikeList(name, day).size());
        }
        p.setData(list);
        return p;
    }

    @Override
    public Page<Overtime> overtime_list(int page, int limit, String day, String name) {
        Page<Attendance> attendancePage = attendance_list(page, limit, day, name);
        List<Overtime> list = new ArrayList<>();
        for (Attendance date : attendancePage.getData()) {
            list.add(new Overtime(date.getName(), date.getDay(), date.getRecord5(), date.getRecord6()));
        }
        Page<Overtime> p = new Page<>();
        p.setData(list);
        if (day == null && name == null) {
            p.setCount(attendanceDao.get_List().size());
        } else if (day == null && name != null) {
            p.setCount(attendanceDao.get_LikeList(name).size());
        } else if (day != null && name == null) {
            p.setCount(attendanceDao.get_DayLikeList(day).size());
        } else {
            p.setCount(attendanceDao.get_NameDayLikeList(name, day).size());
        }
        return p;
    }

    @Override
    public Page<User> user_list(int page, int limit, String userName) {
        //计算起始索引
        int start = limit * (page - 1);
        Page<User> p = new Page<>();
        List<User> list = new ArrayList<>();
        if (userName == null) {
            list = userdao.getList(start, limit);
            p.setCount(userdao.get_List().size());
        } else if (userName != null) {
            list = userdao.getListByName(start, limit, userName);
            p.setCount(userdao.get_LikeList(userName).size());
        }
        p.setData(list);
        return p;
    }

    @Override
    public Page<Employee> employee_list(int page, int limit, String userName) {
        int start = limit * (page - 1);
        Page<Employee> p = new Page<>();
        List<Employee> list = new ArrayList<>();
        if (userName == null) {
            list = employeedao.getList(start, limit);
            p.setCount(employeedao.get_List().size());
        } else if (userName != null) {
            list = employeedao.getListByName(start, limit, userName);
            p.setCount(employeedao.get_LikeList(userName).size());
        }
        //提取部门职位信息
        int size = list.size();
        List<Employee> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Employee data = list.get(i);
            Dept dept = deptDao.get_Info(data.getDept_id());
            data.setDept(dept);
            Job job = jobDao.get_Info(data.getJob_id());
            data.setJob(job);
            list2.add(i, data);
        }
        p.setData(list2);
        return p;
    }
}
