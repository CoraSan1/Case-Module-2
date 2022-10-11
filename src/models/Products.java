package models;

import java.io.Serializable;

public class Products implements Serializable {
    private int id;
    private String name;
    private double price;
    private String discrible;
    private String madeBy;

    public Products() {
    }

    public Products(int id, String name, double price, String discrible, String madeBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discrible = discrible;
        this.madeBy = madeBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discrible='" + discrible + '\'' +
                ", madeBy='" + madeBy + '\'' +
                '}';
    }
}
