package com.aniapps.myshoppinglist;

public class SubList {

    String category="",sub_title = "", quantity = "", note = "";
    int img = 0;
    boolean tick;

    public SubList() {
    }

    public SubList(String category,int img, String sub_title, String quantity, String note, boolean tick) {
        this.category=category;
        this.img = img;
        this.sub_title = sub_title;
        this.quantity = quantity;
        this.note = note;
        this.tick = tick;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isTick() {
        return tick;
    }

    public void setTick(boolean tick) {
        this.tick = tick;
    }

}
