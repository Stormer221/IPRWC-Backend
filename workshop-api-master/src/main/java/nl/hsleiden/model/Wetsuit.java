package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;

public class Wetsuit {
    @JsonView(View.Public.class)
    private String size;

    @JsonView(View.Public.class)
    private String material;

    @JsonView(View.Public.class)
    private int thickness;

    @JsonView(View.Public.class)
    private int productNr;

    @JsonView(View.Public.class)
    private String brand;

    @JsonView(View.Public.class)
    private int price;

    @JsonView(View.Public.class)
    private String name;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getProductNr() {
        return productNr;
    }

    public void setProductNr(int productNr) {
        this.productNr = productNr;
    }
}
