package com.icbt.dto;

import com.icbt.service.CakeService;

public class Cake {

    String name;
    Double price;


    public Cake( String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
