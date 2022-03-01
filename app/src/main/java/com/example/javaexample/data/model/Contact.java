package com.example.javaexample.data.model;

public class Contact {

    public String name;
    public String mobile;
    public String home;
    public String office;

    public Contact(String name, String mobile, String home, String office) {
        this.name = name;
        this.mobile = mobile;
        this.home = home;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
