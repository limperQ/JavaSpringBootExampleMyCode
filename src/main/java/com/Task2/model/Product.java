package com.Task2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@Entity
@Table(name = "product")
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private Long code;
    @Column(name = "name")
    private String name;
    @Column(name = "group_id", updatable = false, insertable = false)
    private Long group_id;

    @OneToMany(mappedBy = "product")
    @XmlElement(name = "prihod")
    private List<Prihod> prihod;

    @OneToMany(mappedBy = "product")
    @XmlElement(name = "rashod")
    private List<Rashod> rashod;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @XmlTransient
    @JsonIgnore
    private ProductGroup productGroup;

    public Product() {
    }

    public Product(Long id, Long code, String name, Long group_id, List<Prihod> prihod, List<Rashod> rashod) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.group_id = group_id;
        this.prihod = prihod;
        this.rashod = rashod;
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

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public void setPrihod(List<Prihod> prihod) {
        this.prihod = prihod;
    }

    public void setRashod(List<Rashod> rashod) {
        this.rashod = rashod;
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

    public Long getGroup_id() {
        return group_id;
    }

    public List<Prihod> getPrihod() {
        return prihod;
    }

    public List<Rashod> getRashod() {
        return rashod;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", group_id=" + group_id +
                ", prihod=" + prihod +
                ", rashod=" + rashod +
                '}';
    }
}
