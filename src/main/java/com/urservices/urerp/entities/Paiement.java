/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findById", query = "SELECT p FROM Paiement p WHERE p.id = :id"),
    @NamedQuery(name ="Paiement.AllPaiementsOperation", query = "SELECT p FROM Paiement p WHERE p.operation = :operation")
})
public class Paiement extends Operation implements Serializable {
    
    public final static String FIND_ALL_PAIEMENTS_OPERATION = "Paiement.AllPaiementsOperation";
    public final static String FIND_ALL = "Paiement.findAll";
    public final static String FINDByID = "Paiement.findById";
    
   
    protected Float montant;

    public Paiement() {
        super();
    }

    public Paiement(Long id, Float montant) {
        super();
        this.id = id;
        this.numero ="P00";
        this.dateOperation = new Date();
        this.montant = montant;
    }

    

    @NotNull(message = "{urerp.entity.required}")
    public Float getMontant() {
        return montant;
    }

   
    public void setMontant(Float montant) {
        this.montant = montant;
    }


    @Override
    public String toString() {
        return super.toString();
    }
    
}
