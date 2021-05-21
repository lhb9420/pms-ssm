package com.dao;

import com.dao.provider.AttendanceDynSqlProvider;
import com.domain.Attendance;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.util.common.Constants.ATTENDENCETABLE;

@Repository
public interface AttendanceDao {
    @Select("select * from " + ATTENDENCETABLE + " ")
    List<Attendance> get_List();

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{content},'%')")
    List<Attendance> get_LikeList(String content);

    @SelectProvider(type = AttendanceDynSqlProvider.class, method = "update_attendanceInfo")
    void update_attendanceInfo(Attendance attendance);

    @SelectProvider(type = AttendanceDynSqlProvider.class, method = "insert_attendanceInfo")
    void insert_attendanceInfo(Attendance attendance);

    @Select("select * from " + ATTENDENCETABLE + " where day =#{day}")
    List<Attendance> get_IdByNameAndDay(String day);

    @Select("select * from " + ATTENDENCETABLE + "  limit #{start},#{limit}")
    List<Attendance> get_list(@Param("start") int start, @Param("limit") int limit);

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{name},'%')  limit #{start},#{limit}")
    List<Attendance> getListByName(@Param("start") int start, @Param("limit") int limit, @Param("name") String name);

    @Select("select * from " + ATTENDENCETABLE + "  where day like CONCAT('%',#{day},'%')  limit #{start},#{limit}")
    List<Attendance> getListByDay(@Param("start") int start, @Param("limit") int limit, @Param("day") String day);

    @Select("select * from " + ATTENDENCETABLE + "  where day like CONCAT('%',#{day},'%')")
    List<Attendance> get_DayLikeList(String day);

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{name},'%') and  day like CONCAT('%',#{day},'%')  limit #{start},#{limit}")
    List<Attendance> getListByNameAndDay(@Param("start") int start, @Param("limit") int limit, @Param("name") String name, @Param("day") String day);

    @Select("select * from " + ATTENDENCETABLE + "  where name like CONCAT('%',#{name},'%') and  day like CONCAT('%',#{day},'%')")
    List<Attendance> get_NameDayLikeList(@Param("name") String name, @Param("day") String day);

}
