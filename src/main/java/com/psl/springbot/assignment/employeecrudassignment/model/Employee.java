package com.psl.springbot.assignment.employeecrudassignment.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    private int id;
    private String fname;
    private String lname;
    private int empno;
    private int mgrid;
    private int isdeleted;

    public Employee() {
    }


    @Id
    public int getId() {
        return id;
    }

    public Employee(int id, String fname, String lname, int empno, int mgrid, int isdeleted) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.empno = empno;
        this.mgrid = mgrid;
        this.isdeleted = isdeleted;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getMgrid() {
        return mgrid;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", empno=" + empno +
                ", mgrid=" + mgrid +
                '}';
    }
}
