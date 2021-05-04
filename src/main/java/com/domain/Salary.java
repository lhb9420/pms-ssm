package com.domain;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer salary_id;
    private Integer employee_id;
    private String name;
    private String month;
    private Integer base_salary;
    private Integer overtime_salary;
    private Integer bonus;
    private Integer total;

    public Salary() {
        super();
    }

    public Integer getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(Integer salary_id) {
        this.salary_id = salary_id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = String.valueOf(month);
    }

    public Integer getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(Integer base_salary) {
        this.base_salary = base_salary;
    }

    public Integer getOvertime_salary() {
        return overtime_salary;
    }

    public void setOvertime_salary(Integer overtime_salary) {
        this.overtime_salary = overtime_salary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
