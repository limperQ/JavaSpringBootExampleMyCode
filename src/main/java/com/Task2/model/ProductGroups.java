package com.Task2.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
public class ProductGroups {
    private List<ProductGroup> productGroup;

    public ProductGroups() {
    }

    public ProductGroups(List<ProductGroup> productGroups) {
        this.productGroup = productGroups;
    }

    public List<ProductGroup> getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(List<ProductGroup> productGroups) {
        this.productGroup = productGroups;
    }

    @Override
    public String toString() {
        return "ProductGroups{" +
                "productGroups=" + productGroup +
                '}';
    }
}
