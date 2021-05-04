package com.dao.provider;

import com.domain.User;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.USERTABLE;

public class UserDynaSqlProvider {
			// 动态插入
			public String insert_Notice(final User user){
				
				return new SQL(){
					{
						INSERT_INTO(USERTABLE);
						if(user.getLoginname() != null ){
							VALUES("loginname", "#{loginname}");
						}
						if(user.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(user.getUsername()!=null){
							VALUES("username","#{username}");
						}
						if(user.getEmployee_id()!=null){
							VALUES("employee_id","#{employee_id}");
						}
						if(user.getStatus()!=null){
							VALUES("status","#{status}");
						}
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(final User job){
				
				return new SQL(){
					{
						UPDATE(USERTABLE);
						if(job.getLoginname() != null ){
							SET("loginname = #{loginname}");
						}
						if(job.getPassword()!=null){
							SET("password = #{password}");
						}
						if(job.getUsername()!=null){
							SET("username = #{username}");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
