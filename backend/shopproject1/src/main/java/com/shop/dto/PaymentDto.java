package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentDto {
    private int  pay_id;
    private int user_id;
    private float pay_amount;
    private int myorder_id;
    private String pay_date;
    private int pay_type;

    public PaymentDto(){

    }
    public PaymentDto(int pay_id, int user_id, float pay_amount, int myorder_id, String pay_date, int pay_type) {
        this.pay_id = pay_id;
        this.user_id = user_id;
        this.pay_amount = pay_amount;
        this.myorder_id = myorder_id;
        this.pay_date = pay_date;
        this.pay_type = pay_type;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(float pay_amount) {
        this.pay_amount = pay_amount;
    }

    public int getMyorder_id() {
        return myorder_id;
    }

    public void setMyorder_id(int myorder_id) {
        this.myorder_id = myorder_id;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "pay_id=" + pay_id +
                ", user_id=" + user_id +
                ", pay_amount=" + pay_amount +
                ", myorder_id=" + myorder_id +
                ", pay_date='" + pay_date + '\'' +
                ", pay_type=" + pay_type +
                '}';
    }
}
