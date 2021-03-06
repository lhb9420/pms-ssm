package com.dao;

import com.dao.provider.SalaryDynaSqlProvider;
import com.domain.Salary;
import com.domain.User;
import com.util.common.Constants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.util.common.Constants.EMPLOYEETABLE;
import static com.util.common.Constants.SALARYTABLE;

@Repository
public interface SalaryDao {
    //工资的相关SQL
    //无参数查询
    @Select("select * from " + SALARYTABLE + " ")
    List<Salary> get_List();

    //按员工查询
    @Select("select * from " + SALARYTABLE + "  where name like CONCAT('%',#{content},'%')")
    List<Salary> get_LikeList(String content);

    @SelectProvider(type = SalaryDynaSqlProvider.class, method = "insert_salaryInfo")
    void insert_salary(Salary salary);

    @Select("select * from " + SALARYTABLE + "   where name like CONCAT('%',#{name},'%') limit #{start},#{limit}")
    List<Salary> getList(@Param("start") int start, @Param("limit") int limit, @Param("name") String name);

    @Select("select * from " + SALARYTABLE + "   limit #{start},#{limit}")
    List<Salary> getListWithoutNmae(@Param("start") int start, @Param("limit") int limit);

    @Delete(" delete from "+SALARYTABLE+" where salary_id = #{salary_id} ")
    void deleteById(Integer salary_id);
}
