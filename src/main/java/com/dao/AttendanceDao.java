package com.dao;

import com.domain.Attendance;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.util.common.Constants.ATTENDENCETABLE;

public interface AttendanceDao {
    @Select("select * from " + ATTENDENCETABLE + " ")
    List<Attendance> get_List();

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{content},'%')")
    List<Attendance> get_LikeList(String content);
}
