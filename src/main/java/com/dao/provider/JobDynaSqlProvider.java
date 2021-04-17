package com.dao.provider;

import com.domain.Job;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.JOBTABLE;

public class JobDynaSqlProvider {
	// 动态插入
			public String insertDept(final Job job){
				
				return new SQL(){
					{
						INSERT_INTO(JOBTABLE);
						if(job.getName() != null && !job.getName().equals("")){
							VALUES("name", "#{name}");
						}
						if(job.getRemark() != null && !job.getRemark().equals("")){
							VALUES("remark", "#{remark}");
						}
					}
				}.toString();
			}	
			// 动态更新
			public String updateDept(final Job job){
				
				return new SQL(){
					{
						UPDATE(JOBTABLE);
						if(job.getName() != null){
							SET(" name = #{name} ");
						}
						if(job.getRemark() != null){
							SET(" remark = #{remark} ");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
