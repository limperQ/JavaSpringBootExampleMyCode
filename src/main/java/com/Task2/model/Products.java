package com.Task2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "AllProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
    private List<Product> product;

    public Products() {
    }

    public Products(List<Product> products) {
        this.product = products;
    }

    public List<Product> getProducts() {
        return product;
    }

    public void setProducts(List<Product> product) {
        this.product = product;
    }
}
