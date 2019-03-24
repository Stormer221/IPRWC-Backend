package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

public class Mask {

    @JsonView(View.Public.class)
    private String brand;

    @JsonView(View.Public.class)
    private int productNr;

    @JsonView(View.Public.class)
    private String fit;

    @JsonView(View.Public.class)
    private int price;

    @JsonView(View.Public.class)
    private String name;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductNr() {
        return productNr;
    }

    public void setProductNr(int productNr) {
        this.productNr = productNr;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}
