package com.example.ca1.Model;

public class ItemList {

    private String name, regId;

    public ItemList(String name, String regId) {
        this.name = name;
        this.regId = regId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }
}
