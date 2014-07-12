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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "ModePaiement.findAll", query = "SELECT mp FROM ModePaiement mp"),
    @NamedQuery(name = "ModePaiement.findById", query = "SELECT mp FROM ModePaiement mp WHERE mp.id = :id")
})
public class ModePaiement implements Serializable {
    
    public final static String FIND_ALL = "ModePaiement.findAll";
    public final static String FINDByID = "ModePaiement.findById";
    
    protected Long id;
    protected TypePaiement typePaiement;
    protected List<Operation> operations;

    public ModePaiement() {
    }

    public ModePaiement(Long id, TypePaiement typePaiement) {
        this.id = id;
        this.typePaiement = typePaiement;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    @OneToMany(mappedBy = "modePaiment")
    public List<Operation> getOperations() {
        return operations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
