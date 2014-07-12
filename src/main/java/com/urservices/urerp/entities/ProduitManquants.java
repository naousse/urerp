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
    @NamedQuery(name = "ProduitManquants.findAll", query = "SELECT pm FROM ProduitManquants pm"),
    @NamedQuery(name = "ProduitManquants.findById", query = "SELECT pm FROM ProduitManquants pm WHERE pm.id = :id")
})
public class ProduitManquants extends Operation implements Serializable {
    
    public final static String FIND_ALL = "ProduitManquants.findAll";
    public final static String FINDByID = "ProduitManquants.findById";

    public ProduitManquants() {
    }

    public ProduitManquants(Long id, String numero, Date dateOperation) {
        super(id, numero, dateOperation);
    }
    
}
