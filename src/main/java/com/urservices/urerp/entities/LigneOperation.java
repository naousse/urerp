/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "LigneOperation.findAll", query = "SELECT lo FROM LigneOperation lo"),
    @NamedQuery(name = "LigneOperation.findMaxIdLigneOperationForAnOperation", query = "SELECT MAX(lo.id) FROM LigneOperation lo  WHERE lo.operation = :operation"),
    @NamedQuery(name = "LigneOperation.findAllLigneOperationsForOneOperation", query = "SELECT lo FROM LigneOperation lo WHERE lo.operation = :operation"),
    @NamedQuery(name = "LigneOperation.findById", query = "SELECT lo FROM LigneOperation lo WHERE lo.id = :id")

})
public class LigneOperation implements Serializable {

    public final static String FIND_ALL = "LigneOperation.findAll";
    public final static String FIND_MAX_ID_LIGNE_OPERATION_FOR_AN_OPERATION = "LigneOperation.findMaxIdLigneOperationForAnOperation";
    public final static String FIND_ALL_LIGNE_OPERATIONS_FOR_ONE_OPERATION = "LigneOperation.findAllLigneOperationsForOneOperation";
    public final static String FINDByID = "LigneOperation.findById";

    protected Long id;
    protected int quantite;
    protected Float prixU = 0F;
    protected Operation operation;
    protected Produit produit;
    private String etat;

    public LigneOperation() {
    }

    public LigneOperation(Long id, int quantite, Float prixU) {
        this.id = id;
        this.quantite = quantite;
        this.prixU = prixU;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @NotNull(message = "{urerp.entity.required}")
    public int getQuantite() {
        return quantite;
    }

    @NotNull(message = "{urerp.entity.required}")
    public Float getPrixU() {
        return prixU;
    }

    @ManyToOne
    public Operation getOperation() {
        return operation;
    }

    @ManyToOne
    public Produit getProduit() {
        return produit;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrixU(Float prixU) {
        this.prixU = prixU;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LigneOperation)) {
            return false;
        }
        LigneOperation other = (LigneOperation) o;
        return (this.id.equals(other.id));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
