package com.example.myapplication;

public class TaskGetter {

    private String title,desc;

    public TaskGetter(){

    }


    public TaskGetter(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }
    public String getDesc() {
        return desc;
    }
}
