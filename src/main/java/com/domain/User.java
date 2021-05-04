package com.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private Integer employee_id;
    private String username;
    private String loginname;
    private String password;
    private Integer status;
    private String create_date;

    public User() {
        super();
    }

    public User(Integer employee_id, String username, String loginname, String password, Integer status) {
        this.employee_id = employee_id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

}
