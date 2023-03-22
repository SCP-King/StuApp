package com.example.stu_app.pojo;

public class Days {
    private int stuid;
    private int studays;
    private int stulongdays;

    public Days() {
    }

    public Days(int stuid, int studays, int stulongdays) {
        this.stuid = stuid;
        this.studays = studays;
        this.stulongdays = stulongdays;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getStudays() {
        return studays;
    }

    public void setStudays(int studays) {
        this.studays = studays;
    }

    public int getStulongdays() {
        return stulongdays;
    }

    public void setStulongdays(int stulongdays) {
        this.stulongdays = stulongdays;
    }
}
