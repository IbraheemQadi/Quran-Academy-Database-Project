package com.example.QuranProject;

import java.sql.Date;

public class Supervisor {
    private Integer id;
    private String name;
    private Date bd;
    private String address;
    private Integer phone_number;
    private String center;

    public Supervisor(Integer id, String name, Date bd, String address, Integer phone_number, String center) {
        this.id = id;
        this.name = name;
        this.bd = bd;
        this.address = address;
        this.phone_number = phone_number;
        this.center = center;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBd() {
        return this.bd;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public String getCenter() {
        return center;
    }


}
