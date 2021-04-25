package com.domain;

import java.io.Serializable;

public class Attendance implements Serializable {
    private Integer attendance_id;
    private Integer employee_id;
    private String name;
    private String record1;
    private String record2;
    private String record3;
    private String record4;
    private String create_date;

    public Attendance() {
        super();
    }

    public Integer getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(Integer attendance_id) {
        this.attendance_id = attendance_id;
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

    public String getRecord3() {
        return record3;
    }

    public void setRecord3(String record3) {
        this.record3 = record3;
    }

    public String getRecord4() {
        return record4;
    }

    public void setRecord4(String record4) {
        this.record4 = record4;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
