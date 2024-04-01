package edu.miu.cs.cs489appsd.lab1a.productmgtapp.model;

import java.time.LocalDate;

public class Product {

    private Long productID;
    private String name;
    private LocalDate date;
    private Integer qty;
    private Double price;

    public Product(){}
    public Product(Long productId, String name, LocalDate date, Integer qty, Double price){
        this.productID = productId;
        this.name = name;
        this.date = date;
        this.qty = qty;
        this.price = price;
    }

    public Product(String name){
        this(null, name, null, null, null);
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
