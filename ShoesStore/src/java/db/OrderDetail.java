/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Date;

/**
 *
 * @author PHT
 */
public class OrderDetail {

    private int id;
    private int orderHeaderId;
    private int shoesId;
    private int quantity;
    private double price;
    private double discount;

    public OrderDetail() {
    }

    public OrderDetail(int shoesId, int quantity, double price, double discount) {
        this.shoesId = shoesId;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public OrderDetail(int id, int orderHeaderId, int shoesId, int quantity, double price, double discount) {
        this.id = id;
        this.orderHeaderId = orderHeaderId;
        this.shoesId = shoesId;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(int orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public int getShoesId() {
        return shoesId;
    }

    public void setShoesId(int shoesId) {
        this.shoesId = shoesId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
