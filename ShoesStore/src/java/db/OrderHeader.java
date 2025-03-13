/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PHT
 */
public class OrderHeader {

    private int id;
    private Date date;
    private String status;
    private int customerId;
    private List<OrderDetail> details = null;

    public OrderHeader() {
        this.details = new ArrayList<>();
    }

    public OrderHeader(Date date, String status, int customerId) {
        this.date = date;
        this.status = status;
        this.customerId = customerId;
        this.details = new ArrayList<>();
    }

    public OrderHeader(int id, Date date, String status, int customerId) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.customerId = customerId;
        this.details = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public void add(OrderDetail orderDetail) {
        this.details.add(orderDetail);
    }
}
