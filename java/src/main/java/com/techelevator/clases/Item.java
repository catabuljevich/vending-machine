package com.techelevator.clases;

import java.math.BigDecimal;

public abstract class Item {

    private String id;
    private String name;
    private BigDecimal price;

    public Item(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = BigDecimal.valueOf(Double.parseDouble(price));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
