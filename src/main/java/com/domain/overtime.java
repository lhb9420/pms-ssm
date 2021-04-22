package com.domain;

import java.io.Serializable;

public class overtime implements Serializable {
    private Integer overtime_id;
    private Integer employee_id;
    private String name;
    private String record1;
    private String record2;
    private String create_date;

    public overtime() {
        super();
    }

    public Integer getOvertime_id() {
        return overtime_id;
    }

    public void setOvertime_id(Integer overtime_id) {
        this.overtime_id = overtime_id;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getRecord1() {
        return record1;
    }

    public void setRecord1(String record1) {
        this.record1 = record1;
    }

    public String getRecord2() {
        return record2;
    }

    public void setRecord2(String record2) {
        this.record2 = record2;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
