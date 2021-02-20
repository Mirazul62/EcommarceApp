package com.example.ecommrrcewebsite.Models;

public class SimpleVerticalModel {
    public SimpleVerticalModel(){
        ////empty constructor///////
    }
    private int pro_img;
    private String simple_title, simple_discription, simple_coupon, simple_quantity, simple_money;

    public SimpleVerticalModel(int pro_img, String simple_title, String simple_discription, String simple_coupon, String simple_quantity, String simple_money) {
        this.pro_img = pro_img;
        this.simple_title = simple_title;
        this.simple_discription = simple_discription;
        this.simple_coupon = simple_coupon;
        this.simple_quantity = simple_quantity;
        this.simple_money = simple_money;
    }

    public int getPro_img() {
        return pro_img;
    }

    public void setPro_img(int pro_img) {
        this.pro_img = pro_img;
    }

    public String getSimple_title() {
        return simple_title;
    }

    public void setSimple_title(String simple_title) {
        this.simple_title = simple_title;
    }

    public String getSimple_discription() {
        return simple_discription;
    }

    public void setSimple_discription(String simple_discription) {
        this.simple_discription = simple_discription;
    }

    public String getSimple_coupon() {
        return simple_coupon;
    }

    public void setSimple_coupon(String simple_coupon) {
        this.simple_coupon = simple_coupon;
    }

    public String getSimple_quantity() {
        return simple_quantity;
    }

    public void setSimple_quantity(String simple_quantity) {
        this.simple_quantity = simple_quantity;
    }

    public String getSimple_money() {
        return simple_money;
    }

    public void setSimple_money(String simple_money) {
        this.simple_money = simple_money;
    }
}
