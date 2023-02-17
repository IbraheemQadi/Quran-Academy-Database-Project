package com.example.QuranProject;

public class Center {
    private Integer id;
    private String address;
    private String working_days;

    public Center(Integer id, String address, String working_days) {
        this.id = id;
        this.address = address;
        this.working_days = working_days;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getWorking_days() {
        return working_days;
    }
}
