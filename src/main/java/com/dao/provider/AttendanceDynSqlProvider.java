package com.dao.provider;

import com.domain.Attendance;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.ATTENDENCETABLE;

public class AttendanceDynSqlProvider {

    public String update_attendanceInfo(final Attendance attendance){
        return new SQL(){
            {
                UPDATE(ATTENDENCETABLE);
                if (attendance.getRecord1() != null) {
                    SET(" record1 = #{record1} ");
                }
                WHERE(" addendance_id = #{addendance_id} ");
            }
        }.toString();
    }
    
    public String insert_attendanceInfo(final Attendance attendance){
        return new SQL(){
            {
                INSERT_INTO(ATTENDENCETABLE);
                if (attendance.getEmployee_id()!=null){
                    VALUES("employee_id", "#{employee_id}");
                }
                if (attendance.getName()!=null){
                    VALUES("name", "#{name}");
                }
                if (attendance.getDay()!=null){
                    VALUES("day", "#{day}");
                }
                if (attendance.getRecord1()!=null){
                    VALUES("record1", "#{record1}");
                }
            }
        }.toString();
    }

}
