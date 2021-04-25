package com.dao;

import com.domain.Salary;
import com.util.common.Constants;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.util.common.Constants.EMPLOYEETABLE;
import static com.util.common.Constants.SALARYTABLE;

public interface SalaryDao {
    //工资的相关SQL
    //无参数查询
    @Select("select * from "+SALARYTABLE+" ")
    List<Salary> get_List();
    //按员工查询
    @Select("select * from "+SALARYTABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Salary> get_LikeList(String content);
}
