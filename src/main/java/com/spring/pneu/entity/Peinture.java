package com.spring.pneu.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="peinture")
public class Peinture {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")

    private int id;
    @Column(name="date")
    private String date;
    @Column(name="ouvrier")
    private String ouvrier;
    @Column(name="duree")
    private String duree;
    @Column(name="emplatres")
    private String emplatre;
    @Column(name="gomme")
    private boolean gomme;
    @Column(name="nbr_blessures")
    private int nbBlessures;
    @Column(name="gonflage")
    private String gonflage;

    @OneToOne(mappedBy = "peinture")
    private Tire tire;

    public Peinture()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(String ouvrier) {
        this.ouvrier = ouvrier;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getEmplatre() {
        return emplatre;
    }

    public void setEmplatre(String emplatre) {
        this.emplatre = emplatre;
    }

    public boolean isGomme() {
        return gomme;
    }

    public void setGomme(boolean gomme) {
        this.gomme = gomme;
    }

    public int getNbBlessures() {
        return nbBlessures;
    }

    public void setNbBlessures(int nbBlessures) {
        this.nbBlessures = nbBlessures;
    }

    public String getGonflage() {
        return gonflage;
    }

    public void setGonflage(String gonflage) {
        this.gonflage = gonflage;
    }
}
