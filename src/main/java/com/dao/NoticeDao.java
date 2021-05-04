package com.dao;

import com.dao.provider.NoticeDynaSqlProvider;
import com.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.util.common.Constants.NOTICETABLE;

@Repository
public interface NoticeDao {

	@Select("select * from "+NOTICETABLE+" ")
	List<Notice> get_List();
	@Select("select * from "+NOTICETABLE+"  where title like CONCAT('%',#{content},'%')")
	List<Notice> get_LikeList(String content);

	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insert_Notice")
	void insert_Info(Notice notice);
	
	@Select("select * from "+NOTICETABLE+" where id = #{id}")
	Notice get_Info(Integer id);

	@SelectProvider(type=NoticeDynaSqlProvider.class,method="update_Notice")
	void update_Info(Notice notice);
	// 根据id删除部门
	@Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
	void delete_Info(Integer id);

}
