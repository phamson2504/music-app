package com.example.lap3;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String caption;
    private int hinhAnh;

    public Item(String name, String caption, int hinhAnh) {
        this.name = name;
        this.caption = caption;
        this.hinhAnh = hinhAnh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
