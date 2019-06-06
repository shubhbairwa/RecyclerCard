package com.example.recyclercard;

public class ExampleItem {
    private int mimageResource;
    private String mtext;
    public ExampleItem(int imageResource,String text){
        mimageResource=imageResource;
        mtext=text;
    }

    public int getMimageResource() {
        return mimageResource;
    }

    public String getMtext() {
        return mtext;
    }
}
