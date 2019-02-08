package com.subir.roshansirtestapp1.Model;

public class ItemList {
    private String name, regId;
    private int imageRes;

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

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public ItemList(String name, String regId, int imageRes) {
        this.name = name;
        this.regId = regId;
        this.imageRes = imageRes;
    }
}
