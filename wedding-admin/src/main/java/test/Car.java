package test;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-25 16:16
 **/

public abstract class Car implements Comparator {
    private String name;
    private Double price;
    private String Brand;

    public Car(){

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

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public abstract Double depreciation();
}
