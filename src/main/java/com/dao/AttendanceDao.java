package com.dao;

import com.dao.provider.AttendanceDynSqlProvider;
import com.domain.Attendance;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.util.common.Constants.ATTENDENCETABLE;
import static com.util.common.Constants.JOBTABLE;

@Repository
public interface AttendanceDao {
    @Select("select * from " + ATTENDENCETABLE + " ")
    List<Attendance> get_List();

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{content},'%')")
    List<Attendance> get_LikeList(String content);

    @SelectProvider(type = AttendanceDynSqlProvider.class,method = "update_attendanceInfo")
    void update_attendanceInfo(Attendance attendance);

    @SelectProvider(type = AttendanceDynSqlProvider.class,method = "insert_attendanceInfo")
    void insert_attendanceInfo(Attendance attendance);

    @Select("select * from "+ATTENDENCETABLE+" where day =#{day}")
    List<Attendance> get_IdByNameAndDay(String day);
}
