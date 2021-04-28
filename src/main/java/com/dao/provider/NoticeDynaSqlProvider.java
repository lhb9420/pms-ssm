package com.dao.provider;

import com.domain.Notice;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.NOTICETABLE;

public class NoticeDynaSqlProvider {
			// 动态插入
			public String insert_Notice(final Notice notice){
				
				return new SQL(){
					{
						INSERT_INTO(NOTICETABLE);
						if(notice.getTitle() != null ){
							VALUES("title", "#{title}");
						}
						if(notice.getUser_id()!=null){
							VALUES("user_id","#{user_id}");
						}
						if(notice.getContent()!=null){
							VALUES("content","#{content}");
						}
						if(notice.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if (notice.getName()!=null){
							VALUES("name","#{name}");
						}
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(final Notice notice){
				
				return new SQL(){
					{
						UPDATE(NOTICETABLE);
						if(notice.getTitle() != null ){
							SET("title = #{title}");
						}
						if(notice.getUser_id()!=null){
							SET("user_id = #{user_id}");
						}
						if(notice.getContent()!=null){
							SET("content = #{content}");
						}
						if(notice.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if (notice.getName()!=null){
							SET("name = #{name}");
						}
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
