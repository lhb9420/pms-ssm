package com.dao.provider;

import com.domain.Leave;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.LEAVETABLE;

public class LeaveDynaSqlProvider {
    public String enable_leave(Integer leave_id) {
        return new SQL() {
            {
                UPDATE(LEAVETABLE);
                SET("enable = 1");
                WHERE(" leave_id = #{leave_id} ");
            }
        }.toString();
    }
    public String insert_leave(final Leave leave){
        return new SQL(){
            {
                INSERT_INTO(LEAVETABLE);
                if(leave.getEmployee_id()!=null){
                    VALUES("employee_id","#{employee_id}");
                }
                if(leave.getName()!=null){
                    VALUES("name","#{name}");
                }
                if(leave.getLeave_date() != null ){
                    VALUES("leave_date", "#{leave_date}");
                }
                if(leave.getReason()!=null){
                    VALUES("reason","#{reason}");
                }
                if(!leave.isEnable()){
                    VALUES("enable", "#{enable}");
                }
            }
        }.toString();
    }
}
