package com.shop.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProductUpdateDTO {
    private String prod_title;
    private  int prod_id;
    private float prod_price;
    private  int prod_qty;
    private MultipartFile photo;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String prod_title, int prod_id, float prod_price, int prod_qty, MultipartFile photo) {
        this.prod_title = prod_title;
        this.prod_id = prod_id;
        this.prod_price = prod_price;
        this.prod_qty = prod_qty;
        this.photo = photo;
    }

    public String getProd_title() {
        return prod_title;
    }

    public void setProd_title(String prod_title) {
        this.prod_title = prod_title;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public float getProd_price() {
        return prod_price;
    }

    public void setProd_price(float prod_price) {
        this.prod_price = prod_price;
    }

    public int getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(int prod_qty) {
        this.prod_qty = prod_qty;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ProductUpdateDTO{" +
                "prod_title='" + prod_title + '\'' +
                ", prod_id=" + prod_id +
                ", prod_price=" + prod_price +
                ", prod_qty=" + prod_qty +
                ", photo=" + photo +
                '}';
    }
}
