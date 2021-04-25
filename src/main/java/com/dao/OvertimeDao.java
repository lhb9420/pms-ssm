package com.dao;

import com.domain.Overtime;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.util.common.Constants.OVERTIMETABLE;

public interface OvertimeDao {
    @Select("select * from "+OVERTIMETABLE+" ")
    List<Overtime> get_List();
    @Select("select * from "+OVERTIMETABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Overtime> get_LikeList(String content);
}
