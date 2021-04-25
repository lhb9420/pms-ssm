package com.dao;

import com.domain.Leave;
import com.domain.Salary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.util.common.Constants.LEAVETABLE;
import static com.util.common.Constants.SALARYTABLE;

public interface LeaveDao {
    @Select("select * from "+LEAVETABLE+" ")
    List<Leave> get_List();
    @Select("select * from "+LEAVETABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Leave> get_LikeList(String content);
}
