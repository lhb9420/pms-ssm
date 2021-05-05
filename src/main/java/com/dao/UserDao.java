package com.dao;

import com.dao.provider.UserDynaSqlProvider;
import com.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.util.common.Constants.USERTABLE;

@Repository
public interface UserDao {

	@Select("select * from "+USERTABLE+" ")
	List<User> get_List();

	@Select("select * from "+USERTABLE+"  where loginname like CONCAT('%',#{content},'%')")
	List<User> get_LikeList(String content);

	@Select("select * from "+USERTABLE+"  where loginname = #{loginname} AND password = #{password}")
	User get_login(@Param("loginname") String loginname, @Param("password") String password);
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="insert_Notice")
	void insert_Info(User employee);
	
	@Select("select * from "+USERTABLE+" where id = #{id}")
	User get_Info(Integer id);

	@SelectProvider(type = UserDynaSqlProvider.class, method = "update_Notice")
	void update_Info(User employee);

	// 根据id删除部门
	@Delete(" delete from " + USERTABLE + " where id = #{id} ")
	void delete_Info(Integer id);

	@Select("select * from " + USERTABLE + " where employee_id = #{employee_id}")
	User get_InfoByEmployeeId(Integer id);

	@Select("select * from " + USERTABLE + " limit #{start},#{limit}")
	List<User> getList(@Param("start") int start, @Param("limit") int limit);

	@Select("select * from " + USERTABLE + "  where loginname like CONCAT('%',#{userName},'%') limit #{start},#{limit}")
	List<User> getListByName(@Param("start") int start, @Param("limit") int limit, @Param("userName") String userName);
}
