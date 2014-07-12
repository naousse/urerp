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
    @NamedQuery(name = "Perte.findAll", query = "SELECT p FROM Perte p"),
    @NamedQuery(name = "Perte.findById", query = "SELECT p FROM Perte p WHERE p.id = :id")
})
public class Perte extends Operation implements Serializable {
    
    public final static String FIND_ALL = "Perte.findAll";
    public final static String FINDByID = "Perte.findById";

    public Perte() {
    }

    public Perte(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
}
