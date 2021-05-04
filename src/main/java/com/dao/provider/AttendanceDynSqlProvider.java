package com.dao.provider;

import com.domain.Attendance;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.ATTENDENCETABLE;

public class AttendanceDynSqlProvider {

    public String update_attendanceInfo(final Attendance attendance) {
        return new SQL() {
            {
                UPDATE(ATTENDENCETABLE);
                if (attendance.getRecord1() != null) {
                    SET(" record1 = #{record1} ");
                }
                if (attendance.getRecord2() != null) {
                SET(" record2 = #{record2} ");
                }
                if (attendance.getRecord3() != null) {
                    SET(" record3 = #{record3} ");
                }
                if (attendance.getRecord4() != null) {
                    SET(" record4 = #{record4} ");
                }
                if (attendance.getRecord5() != null) {
                    SET(" record5 = #{record5} ");
                }
                if (attendance.getRecord6() != null) {
                    SET(" record6 = #{record6} ");
                }
                WHERE("attendance_id = #{attendance_id} ");
            }
        }.toString();
    }

    public String insert_attendanceInfo(final Attendance attendance) {
        return new SQL() {
            {
                INSERT_INTO(ATTENDENCETABLE);
                if (attendance.getEmployee_id() != null) {
                    VALUES("employee_id", "#{employee_id}");
                }
                if (attendance.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (attendance.getDay() != null) {
                    VALUES("day", "#{day}");
                }
                if (attendance.getRecord1() != null) {
                    VALUES("record1", "#{record1}");
                }
                if (attendance.getRecord2() != null) {
                    VALUES("record2", "#{record2}");
                }
                if (attendance.getRecord3() != null) {
                    VALUES("record3", "#{record3}");
                }
                if (attendance.getRecord4() != null) {
                    VALUES("record4", "#{record4}");
                }
                if (attendance.getRecord5() != null) {
                    VALUES("record5", "#{record5}");
                }
                if (attendance.getRecord6() != null) {
                    VALUES("record6", "#{record6}");
                }
            }
        }.toString();
    }

}
