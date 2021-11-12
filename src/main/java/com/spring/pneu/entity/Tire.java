package com.spring.pneu.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name="pneu")
public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "occasion")
    private boolean occasion;
    @Column(name = "repare")

    private boolean repare;
    @Column(name = "rechape")
    private boolean rechape;
    @Column(name = "ua")
    private boolean ua;
    @ManyToOne()
    @JoinColumn(name="origine_id", referencedColumnName = "id", insertable = true, updatable = true)

    private client origine;
    @Column(name = "date_livraison")
    private String dateLivraison;
    @ManyToOne()
    @JoinColumn(name="destinaire_id", referencedColumnName = "id", insertable = true, updatable = true)
    private client destinaire;
    @Column(name = "matricule")
    private String matricule;
    @ManyToOne()
    @JoinColumn(name="dimension_id", referencedColumnName = "id", insertable = true, updatable = true)
    private Dimension dimension;
    @ManyToOne()
    @JoinColumn(name="marque_id", referencedColumnName = "id", insertable = true, updatable = true)
    private Marque marque;
    @Column(name = "etat")
    private String etat;
    @Column(name = "observation")
    private String observation;
    @Column(name = "prix")
    private float prix;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rep_ext", referencedColumnName = "id")
    private ReparationExt reparationExt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rep_int", referencedColumnName = "id")
    private ReparationInt reparationInt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_gomme", referencedColumnName = "id")
    private Gomme gomme;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuisson", referencedColumnName = "id")
    private Cuisson cuisson;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_controle", referencedColumnName = "id")
    private Controle controle;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dessin", referencedColumnName = "id")
    private Dessin dessin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_peinture", referencedColumnName = "id")
    private Peinture peinture;

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Tire(int id, boolean occasion, boolean repare, boolean rechape, boolean ua, int origineId, String dateLivraison, int destinaireId, String matricule, int dimensionId, String marque, String etat, String observation, float prix) {
        this.id = id;
        this.occasion = occasion;
        this.repare = repare;
        this.rechape = rechape;
        this.ua = ua;
        this.dateLivraison = dateLivraison;
        this.matricule = matricule;
        this.etat = etat;
        this.observation = observation;
        this.prix = prix;
    }

    public Tire() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccasion() {
        return occasion;
    }

    public void setOccasion(boolean occasion) {
        this.occasion = occasion;
    }

    public boolean isRepare() {
        return repare;
    }

    public void setRepare(boolean repare) {
        this.repare = repare;
    }

    public boolean isRechape() {
        return rechape;
    }

    public void setRechape(boolean rechape) {
        this.rechape = rechape;
    }

    public boolean isUa() {
        return ua;
    }

    public void setUa(boolean ua) {
        this.ua = ua;
    }



    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }



    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }


    public ReparationExt getReparationExt() {
        return reparationExt;
    }

    public void setReparationExt(ReparationExt reparationExt) {
        this.reparationExt = reparationExt;
    }

    public ReparationInt getReparationInt() {
        return reparationInt;
    }

    public void setReparationInt(ReparationInt reparationInt) {
        this.reparationInt = reparationInt;
    }

    public Gomme getGomme() {
        return gomme;
    }

    public void setGomme(Gomme gomme) {
        this.gomme = gomme;
    }

    public Cuisson getCuisson() {
        return cuisson;
    }

    public void setCuisson(Cuisson cuisson) {
        this.cuisson = cuisson;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Dessin getDessin() {
        return dessin;
    }

    public void setDessin(Dessin dessin) {
        this.dessin = dessin;
    }

    public Peinture getPeinture() {
        return peinture;
    }

    public void setPeinture(Peinture peinture) {
        this.peinture = peinture;
    }

    public client getOrigine() {
        return origine;
    }

    public void setOrigine(client origine) {
        this.origine = origine;
    }

    public client getDestinaire() {
        return destinaire;
    }

    public void setDestinaire(client destinaire) {
        this.destinaire = destinaire;
    }
}
