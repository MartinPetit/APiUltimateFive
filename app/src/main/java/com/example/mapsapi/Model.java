package com.example.mapsapi;

public class Model {

    private int image;
    private String title;
    private String desc;
    private String prix;

    public Model(int image, String title, String desc, String prix) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.prix = prix;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
