package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

public class Shoe {

    @JsonView(View.Public.class)
    private int size;

    @JsonView(View.Public.class)
    private String name;

    @JsonView(View.Public.class)
    private int productNr;

    @JsonView(View.Public.class)
    private String brand;

    @JsonView(View.Public.class)
    private int price;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductNr() {
        return productNr;
    }

    public void setProductNr(int productNr) {
        this.productNr = productNr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
