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

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findById", query = "SELECT f FROM Facture f WHERE f.id = :id")
})
public class Facture extends Operation implements Serializable {
    
    public final static String FIND_ALL = "Facture.findAll";
    public final static String FINDByID = "Facture.findById";

    public Facture() {
    }

    public Facture(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
}
