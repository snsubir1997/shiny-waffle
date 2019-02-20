package com.subir.timestampedgridofimages.Model;

import android.graphics.Bitmap;

public class MyGrid
{
    public MyGrid(Bitmap image, String name) {
        this.image = image;
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    Bitmap image;
    String name;
}