package com.example.stu_app.pojo;

public class Stu {
    private int stuid;
    private int stupassword;
    private String stuname;
    private String stuphone;
    private String stuclass;

    public Stu(int stuid, String stuname, String stuphone, String stuclass,int stupassword) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuphone = stuphone;
        this.stuclass = stuclass;
        this.stupassword=stupassword;
    }

    public Stu() {
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuphone() {
        return stuphone;
    }

    public void setStuphone(String stuphone) {
        this.stuphone = stuphone;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public void setStupassword(int stupassword) {
        this.stupassword = stupassword;
    }

    public int getStupassword() {
        return stupassword;
    }
}
