package db;

import java.util.Date;

public class Product {

    private String id;
    private String name;
    private double price;
    private Date expDate;

    public Product() {
    }

    public Product(String id, String name, double price, Date expDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

}
