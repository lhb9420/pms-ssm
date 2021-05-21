package com.dao.provider;

import com.domain.Salary;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.SALARYTABLE;

public class SalaryDynaSqlProvider {

    public String insert_salaryInfo(final Salary salary) {
        return new SQL() {
            {
                INSERT_INTO(SALARYTABLE);
                if (salary.getEmployee_id() != null) {
                    VALUES("employee_id", "#{employee_id}");
                }
                if (salary.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (salary.getMonth() != null) {
                    VALUES("month", "#{month}");
                }
                if (salary.getBase_salary() != null) {
                    VALUES("base_salary", "#{base_salary}");
                }
                if (salary.getOvertime_salary() != null) {
                    VALUES("overtime_salary", "#{overtime_salary}");
                }
                if (salary.getBonus() != null) {
                    VALUES("bonus", "#{bonus}");
                }
                if (salary.getTotal() != null) {
                    VALUES("total", "#{total}");
                }
            }
        }.toString();
    }
}
