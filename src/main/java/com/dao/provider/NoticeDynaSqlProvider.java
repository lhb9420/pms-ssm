package com.dao.provider;

import com.domain.Notice;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.NOTICETABLE;

public class NoticeDynaSqlProvider {
			// 动态插入
			public String insert_Notice(final Notice job){
				
				return new SQL(){
					{
						INSERT_INTO(NOTICETABLE);
						if(job.getTitle() != null ){
							VALUES("title", "#{title}");
						}
						if(job.getUser_id()!=null){
							VALUES("user_id","#{user_id}");
						}
						if(job.getContent()!=null){
							VALUES("content","#{content}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(final Notice job){
				
				return new SQL(){
					{
						UPDATE(NOTICETABLE);
						if(job.getTitle() != null ){
							SET("title = #{title}");
						}
						if(job.getUser_id()!=null){
							SET("user_id = #{user_id}");
						}
						if(job.getContent()!=null){
							SET("content = #{content}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
				
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
