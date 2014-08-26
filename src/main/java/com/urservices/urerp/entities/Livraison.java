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
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findAllLivraisonsOperation", query = "SELECT l FROM Livraison l WHERE l.operation = :operation"),
    @NamedQuery(name = "Livraison.findById", query = "SELECT l FROM Livraison l WHERE l.id = :id")
})
public class Livraison extends Operation implements Serializable {
    
    public final static String FIND_ALL = "Livraison.findAll";
    public final static String FINDByID = "Livraison.findById";
    public final static String FIND_ALL_LIVRAISONS_OPERATION = "Livraison.findAllLivraisonsOperation";

    public Livraison() {
    }

    public Livraison(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
}
