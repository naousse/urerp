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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = Fonction.FIND_ALL, query ="SELECT f FROM Fonction f" ),
    @NamedQuery(name = Fonction.FINDByID, query ="SELECT f FROM Fonction f WHERE f.id =:id" ),
    @NamedQuery(name = Fonction.FINDByLIBELLE, query ="SELECT f FROM Fonction f WHERE f.libelle =:libelle" )
})
public class Fonction implements Serializable {
    
    public final static String FIND_ALL = "Fonction.findAll";
    public final static String FINDByID = "Fonction.findById";
    public final static String FINDByLIBELLE = "Fonction.findByLibelle";
    
    protected Long id;
    
    private String libelle;
    
    

    public Fonction() {
    }

    public Fonction(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @Size(min = 4, message = "{urerp.entity.min}")
    public String getLibelle() {
        return libelle;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }

}
