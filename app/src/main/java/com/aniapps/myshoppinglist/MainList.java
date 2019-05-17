package com.aniapps.myshoppinglist;

import java.util.ArrayList;

public class MainList {
    public String main_title="";
    public ArrayList<SubList> subList=new ArrayList<>();

    public MainList(String main_title, ArrayList<SubList> subList) {
        super();
        this.main_title = main_title;
        this.subList = subList;
    }

    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    public ArrayList<SubList> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<SubList> subList) {
        this.subList = subList;
    }
}
