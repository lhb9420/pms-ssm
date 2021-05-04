package com.dao.provider;

import com.domain.Employee;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.EMPLOYEETABLE;

public class EmployeeDynaSqlProvider {
			// 动态插入
			public String insert_Employee(final Employee job){
				
				return new SQL(){
					{
						INSERT_INTO(EMPLOYEETABLE);
						if(job.getName() != null ){
							VALUES("name", "#{name}");
						}
						if(job.getCard_id()!=null){
							VALUES("card_id","#{card_id}");
						}
						if(job.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(job.getAddress()!=null){
							VALUES("address","#{address}");
						}
						if(job.getPost_code()!=null){
							VALUES("post_code","#{post_code}");
						}
						if(job.getTel()!=null){
							VALUES("tel","#{tel}");
						}
						if(job.getPhone()!=null){
							VALUES("phone","#{phone}");
						}
						if(job.getQq_num()!=null){
							VALUES("qq_nul","#{qq_num}");
						}
						if(job.getEmail()!=null){
							VALUES("email","#{email}");
						}
						if(job.getSex()!=null){
							VALUES("sex","#{sex}");
						}
						if(job.getParty()!=null){
							VALUES("party","#{party}");
						}
						if(job.getBirthday()!=null){
							VALUES("birthday","#{birthday}");
						}
						if(job.getRace()!=null){
							VALUES("race","#{race}");
						}
						if(job.getEducation()!=null){
							VALUES("education","#{education}");
						}
						if(job.getSpeciality()!=null){
							VALUES("speciality","#{speciality}");
						}
						if(job.getHobby()!=null){
							VALUES("hobby","#{hobby}");
						}
						if(job.getRemark()!=null){
							VALUES("remark","#{remark}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getLogin_name()!=null){
							VALUES("login_name","#{login_name}");
						}
						if(job.getDept_id()!=null){
							VALUES("dept_id","#{dept_id}");
						}
						if(job.getJob_id()!=null){
							VALUES("job_id","#{job_id}");
						}
					}
				}.toString();
			}	
			// 动态更新
			public String update_Employee(final Employee employee){
				
				return new SQL(){
					{
						UPDATE(EMPLOYEETABLE);
						if(employee.getName() != null ){
							SET("name = #{name}");
						}
						if(employee.getCard_id()!=null){
							SET("card_id = #{card_id}");
						}
						if(employee.getAddress()!=null){
							SET("address = #{address}");
						}
						if(employee.getPassword()!=null){
							SET("password = #{password}");
						}
						if(employee.getPost_code()!=null){
							SET("post_code = #{post_code}");
						}
						if(employee.getTel()!=null){
							SET("tel = #{tel}");
						}
						if(employee.getPhone()!=null){
							SET("phone = #{phone}");
						}
						if(employee.getQq_num()!=null){
							SET("qq_nul = #{qq_num}");
						}
						if(employee.getEmail()!=null){
							SET("email = #{email}");
						}
						if(employee.getSex()!=null){
							SET("sex = #{sex}");
						}
						if(employee.getParty()!=null){
							SET("party = #{party}");
						}
						if(employee.getBirthday()!=null){
							SET("birthday = #{birthday}");
						}
						if(employee.getRace()!=null){
							SET("race = #{race}");
						}
						if(employee.getLogin_name()!=null){
							SET("login_name = #{login_name}");
						}
						if(employee.getEducation()!=null){
							SET("education = #{education}");
						}
						if(employee.getSpeciality()!=null){
							SET("speciality = #{speciality}");
						}
						if(employee.getHobby()!=null){
							SET("hobby = #{hobby}");
						}
						if(employee.getRemark()!=null){
							SET("remark = #{remark}");
						}
						if(employee.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(employee.getDept_id()!=null){
							SET("dept_id = #{dept_id}");
						}
						if(employee.getJob_id()!=null){
							SET("job_id = #{job_id}");
						}
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
