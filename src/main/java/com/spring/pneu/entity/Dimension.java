package com.spring.pneu.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dimension")
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private int id;
    @Column(name="dimension")
    private String dimension;
    @Column(name="prix")
    private Float prix;
    @OneToMany(targetEntity=Tire.class, mappedBy="dimension",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tire> tires = new ArrayList<>();
    public Dimension()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Float getPrix() {
        return prix;
    }


    public void setPrix(Float prix) {
        this.prix = prix;
    }
}
