package com.spring.pneu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private int id;
    @Column(name="marque")
    private String marque;
    @OneToMany(targetEntity=Tire.class, mappedBy="marque",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tire> tires = new ArrayList<>();
    public Marque()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
