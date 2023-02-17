package com.example.QuranProject;

import java.sql.Date;

public class Student {

    private Integer id;
    private String name;
    private Date bd;
    private String address;
    private Integer phone_number;
    private String supervisor;
    private String center;


    public Student(Integer id, String name, Date bd, String address, Integer phone_number, String supervisor, String center) {
        this.id = id;
        this.name = name;
        this.bd = bd;
        this.address = address;
        this.phone_number = phone_number;
        this.supervisor = supervisor;
        this.center = center;

    }

    public Student(Integer id, String name, Date bd, String address, Integer phone_number) {
        this.id = id;
        this.name = name;
        this.bd = bd;
        this.address = address;
        this.phone_number = phone_number;
    }

    public Student(String name,String center) {
        this.name = name;
        this.center=center;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBd() {
        return bd;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getCenter() {
        return center;
    }

}
