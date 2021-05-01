package com.dao;

import com.dao.provider.EmployeeDynaSqlProvider;
import com.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

import static com.util.common.Constants.EMPLOYEETABLE;

public interface EmployeeDao {
	/**
	 * 
	 * @return
	 */
	//查询
			@Select("select * from "+EMPLOYEETABLE+" ")
			List<Employee> get_List();
			@Select("select * from "+EMPLOYEETABLE+"  where name like CONCAT('%',#{content},'%')")
			List<Employee> get_LikeList(String content);
			
			
			@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insert_Employee")
			void insert_Info(Employee employee);
			
			@Select("select * from "+EMPLOYEETABLE+" where id = #{id}")
			Employee get_Info(Integer id);

			@SelectProvider(type=EmployeeDynaSqlProvider.class,method="update_Employee")
			void update_Info(Employee employee);
			// 根据id删除部门
			@Delete(" delete from "+EMPLOYEETABLE+" where id = #{id} ")
			void delete_Info(Integer id);
			
			@Select("select * from "+EMPLOYEETABLE+" where name=#{name} and password=#{password}")
			Employee get_ByInfo(@Param("name") String name, @Param("password") String password);

			@Select("select * from "+EMPLOYEETABLE+" where name=#{name}")
			Employee get_IdByName(String name);
}
