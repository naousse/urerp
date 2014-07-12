/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id")
})
public class Stock implements Serializable {
    
    public final static String FIND_ALL = "Stock.findAll";
    public final static String FINDByID = "Stock.findById";
    
    protected Long id;
    protected Date dateDePeremption;
    protected Date dateAlerte;
    protected int quantite;
    protected Produit produit;

    public Stock() {
    }

    public Stock(Long id, Date dateDePeremption, Date dateAlerte, int quantite) {
        this.id = id;
        this.dateDePeremption = dateDePeremption;
        this.dateAlerte = dateAlerte;
        this.quantite = quantite;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{urerp.entity.date}")
    public Date getDateDePeremption() {
        return dateDePeremption;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{urerp.entity.date}")
    public Date getDateAlerte() {
        return dateAlerte;
    }

    @NotNull(message = "{urerp.entity.required}")
    public int getQuantite() {
        return quantite;
    }

    @ManyToOne
    public Produit getProduit() {
        return produit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDePeremption(Date dateDePeremption) {
        this.dateDePeremption = dateDePeremption;
    }

    public void setDateAlerte(Date dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setDateDePeremption(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
