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
    @NamedQuery(name = "Achat.findAll", query = "SELECT a FROM Achat a"),
    @NamedQuery(name = "Achat.findById", query = "SELECT a FROM Achat a WHERE a.id = :id")
})
public class Achat extends Operation implements Serializable {
    
    public final static String FIND_ALL = "Achat.findAll";
    public final static String FINDByID = "Achat.findById";

    public Achat() {
    }

    public Achat(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
    
}
