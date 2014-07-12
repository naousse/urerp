/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "CEntreprise.findAll", query = "SELECT ce FROM CEntreprise ce"),
    @NamedQuery(name = "CEntreprise.findByName", query = "SELECT ce FROM CEntreprise ce WHERE ce.nom = :nom"),
    @NamedQuery(name = "CEntreprise.findById", query = "SELECT ce FROM CEntreprise ce WHERE ce.id = :id")
})
public class CEntreprise extends Partenaire implements Serializable {
    
    public final static String FIND_ALL = "CEntreprise.findAll";
    public final static String FINDByName = "CEntreprise.findByName";
    public final static String FINDByID = "CEntreprise.findById";

    public CEntreprise() {
        super();
    }

    public CEntreprise(Long id, String nom, Adresse adresse) {
        super(id, nom, adresse);
    }

}
