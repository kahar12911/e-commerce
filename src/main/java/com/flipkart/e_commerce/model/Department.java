package com.flipkart.e_commerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DeptId;
    private String DeptName;

    public Department(){

    }

    public Department(Integer deptId, String deptName) {
        DeptId = deptId;
        DeptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Deptid=" + DeptId +
                ", DeptName='" + DeptName + '\'' +
                '}';
    }

    public Integer getDeptid() {
        return DeptId;
    }

    public void setDeptid(Integer deptid) {
        DeptId = deptid;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
