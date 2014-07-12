/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id")
})
public class Produit implements Serializable {
    
    public final static String FIND_ALL = "Produit.findAll";
    public final static String FINDByID = "Produit.findById";
    
    protected Long id;
    protected Long reference;
    protected String designation;
    protected int quantiteEnStock;
    protected int seuilDeSecurité;
    protected List<Stock> stock;
    protected List<LigneOperation> ligneOperations;

    public Produit() {
    }

    public Produit(Long id, Long reference, String designation, int quantiteEnStock, int seuilDeSecurité, List<Stock> stock, List<LigneOperation> ligneOperations) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.quantiteEnStock = quantiteEnStock;
        this.seuilDeSecurité = seuilDeSecurité;
        this.stock = stock;
        this.ligneOperations = ligneOperations;
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
    public Long getReference() {
        return reference;
    }

    @NotNull(message = "{urerp.entity.required}")
    @Size(min = 1, max = 100, message = "{urerp.entity.size}")
    public String getDesignation() {
        return designation;
    }

    public int getSeuilDeSecurité() {
        return seuilDeSecurité;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    @OneToMany(mappedBy = "produit")
    public List<Stock> getStock() {
        return stock;
    }

    @OneToMany(mappedBy = "produit")
    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }
    
    public void addLigneOperation(LigneOperation ligneOperation){
        this.ligneOperations.add(ligneOperation);
    }
    
    public void addStock(Stock stock) {
        this.stock.add(stock);
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public void setSeuilDeSecurité(int seuilDeSecurité) {
        this.seuilDeSecurité = seuilDeSecurité;
    }

    @Override
    public String toString() {
        return this.designation;
    }
    
}
