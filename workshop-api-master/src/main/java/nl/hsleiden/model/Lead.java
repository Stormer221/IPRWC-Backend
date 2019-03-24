package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

public class Lead {

    @JsonView(View.Public.class)
    private String kind;

    @JsonView(View.Public.class)
    private double kilogram;

    @JsonView(View.Public.class)
    private int productNr;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getKilogram() {
        return kilogram;
    }

    public void setKilogram(double kilogram) {
        this.kilogram = kilogram;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(View.Public.class)
    private String brand;

    @JsonView(View.Public.class)
    private int price;

    @JsonView(View.Public.class)
    private String name;
}
