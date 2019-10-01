package com.t1708m.ejb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private long prodID;
    private String ProdName;
    private String Description;
    private long DateOfManf;
    private long price;

    public long getProdId() {
        return prodID;
    }

    public void setProdId(long prodId) {
        this.prodID = prodId;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getProdID() {
        return prodID;
    }

    public void setProdID(long prodID) {
        this.prodID = prodID;
    }

    public long getDateOfManf() {
        return DateOfManf;
    }

    public void setDateOfManf(long dateOfManf) {
        DateOfManf = dateOfManf;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
