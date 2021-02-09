package com.Task2.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name = "product_group")
@XmlRootElement(name = "group")
public class ProductGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private Long code;
    @Column(name = "name")
    private String name;
    @Column(name = "parent_id", insertable = false, updatable = false)
    private Long parent_id;

    @OneToMany(mappedBy = "productGroup")
    @XmlElement(name = "group")
    private List<Product> productsListss;

    public ProductGroup() {
    }

    public ProductGroup(Long id, Long code, String name, Long parent_id, List<Product> productsLists, ProductGroup parent, List<ProductGroup> child) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.parent_id = parent_id;
        this.productsListss = productsLists;
    }

    public Long getId() {
        return id;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }


    public List<Product> getProductsLists() {
        return productsListss;
    }

    public void setProductsLists(List<Product> productsLists) {
        this.productsListss = productsLists;
    }

//    public ProductGroup getParent() {
//        return parent;
//    }
//
//    public List<ProductGroup> getChild() {
//        return child;
//    }
//
//    public void setParent(ProductGroup parent) {
//        this.parent = parent;
//    }
//
//    public void setChild(List<ProductGroup> child) {
//        this.child = child;
//    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", productsLists=" + productsListss +
                '}';
    }
}
