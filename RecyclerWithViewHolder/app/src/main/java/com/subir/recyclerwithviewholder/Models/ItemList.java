package com.subir.recyclerwithviewholder.Models;

public class ItemList {

    private String name, rno, gpa;

    public ItemList(String name, String rno, String gpa) {
        this.name = name;
        this.rno = rno;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
}