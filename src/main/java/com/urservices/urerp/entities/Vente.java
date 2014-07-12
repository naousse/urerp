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
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v"),
    @NamedQuery(name = "Vente.findById", query = "SELECT v FROM Vente v WHERE v.id = :id")
    
})
public class Vente extends Operation implements Serializable {
    
    public final static String FIND_ALL = "Vente.findAll";
    public final static String FINDByID = "Vente.findById";

    public Vente() {
        super();
    }

    public Vente(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
}
