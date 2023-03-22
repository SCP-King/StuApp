package com.example.stu_app.pojo;

public class Teacher {
    private int teacherid,teacherpassword;

    public Teacher(int id, int password) {
        this.teacherid = id;
        this.teacherpassword = password;
    }

    public Teacher() {
    }

    public int getId() {
        return teacherid;
    }

    public void setId(int id) {
        this.teacherid = id;
    }

    public int getPassword() {
        return teacherpassword;
    }

    public void setPassword(int password) {
        this.teacherpassword = password;
    }
}
