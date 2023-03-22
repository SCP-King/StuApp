package com.example.stu_app.pojo;

public class Summary {
    private int stuid;
    private String stukeywords;
    private String stusummary;
    private String studate;

    public Summary() {
    }

    public Summary(int stuid, String stukeywords, String stusummary, String studate) {
        this.stuid = stuid;
        this.stukeywords = stukeywords;
        this.stusummary = stusummary;
        this.studate = studate;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStukeywords() {
        return stukeywords;
    }

    public void setStukeywords(String stukeywords) {
        this.stukeywords = stukeywords;
    }

    public String getStusummary() {
        return stusummary;
    }

    public void setStusummary(String stusummary) {
        this.stusummary = stusummary;
    }

    public String getStudate() {
        return studate;
    }

    public void setStudate(String studate) {
        this.studate = studate;
    }
}
