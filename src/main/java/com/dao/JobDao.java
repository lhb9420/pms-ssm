package com.dao;

import com.dao.provider.JobDynaSqlProvider;
import com.domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

import static com.util.common.Constants.JOBTABLE;

public interface JobDao {
	//查询
		@Select("select * from "+JOBTABLE+" ")
		List<Job> get_List();
		@Select("select * from "+JOBTABLE+"  where name like CONCAT('%',#{content},'%')")
		List<Job> get_LikeList(String content);
		
		
		@SelectProvider(type=JobDynaSqlProvider.class,method="insertDept")
		void insert_Info(Job job);
		
		@Select("select * from "+JOBTABLE+" where id = #{id}")
		Job get_Info(Integer id);

		@SelectProvider(type=JobDynaSqlProvider.class,method="updateDept")
		void update_Info(Job job);
		// 根据id删除部门
		@Delete(" delete from "+JOBTABLE+" where id = #{id} ")
		void delete_Info(Integer id);
}
