package com.dao;

import com.dao.provider.LeaveDynaSqlProvider;
import com.dao.provider.UserDynaSqlProvider;
import com.domain.Leave;
import com.domain.Salary;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static com.util.common.Constants.LEAVETABLE;


public interface LeaveDao {
    @Select("select * from "+LEAVETABLE+" ")
    List<Leave> get_List();
    @Select("select * from "+LEAVETABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Leave> get_LikeList(String content);
    @SelectProvider(type= LeaveDynaSqlProvider.class,method="enable_leave")
    void enable(Integer leave_id);
    @SelectProvider(type= LeaveDynaSqlProvider.class,method="insert_leave")
    void insert(Leave leave);
}
