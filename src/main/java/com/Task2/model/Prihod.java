package com.Task2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@Entity
@Table(name = "prihod")
@XmlRootElement(name = "prihod")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prihod {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "time")
    private Date time;
    @Column(name = "prod_id", insertable = false, updatable = false)
    private Long prod_id;
    @Column(name = "num")
    private Long num;
    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "id")
    @XmlTransient
    @JsonIgnore
    private Product product;

    public Prihod() {
    }

    public Prihod(Long id, Date time, Long prod_id, Long num, Long price, Product product) {
        this.id = id;
        this.time = time;
        this.prod_id = prod_id;
        this.num = num;
        this.price = price;
        this.product = product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Long getProd_id() {
        return prod_id;
    }

    public Long getNum() {
        return num;
    }

    public Long getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Prihod{" +
                "time=" + time +
                ", prod_id=" + prod_id +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
