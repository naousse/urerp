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
    @NamedQuery(name = "CPhysique.findAll", query = "SELECT cp FROM CPhysique cp"),
    @NamedQuery(name = "CPhysique.findClientPhysiqueByCni", query = "SELECT cp FROM CPhysique cp WHERE cp.cni = :cni"),
    @NamedQuery(name = "CPhysique.findById", query = "SELECT cp FROM CPhysique cp WHERE cp.id = :id"),
})
public class CPhysique extends Partenaire implements Serializable{
    
    public final static String FIND_ALL = "CPhysique.findAll";
    public final static String FIND_ClientPhysiqueByCni = "CPhysique.findClientPhysiqueByCni";
    public final static String FINDByID = "CPhysique.findById";
    
    protected String cni;
    protected String prenom;

    public CPhysique() {
    }

    public CPhysique(String cni, String prenom, Long id, String nom, Adresse adresse) {
        super(id, nom, adresse);
        this.cni = cni;
        this.prenom = prenom;
    }

    public String getCni() {
        return cni;
    }

    @Override
    public String getNom() {
        return super.getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Adresse getAdresse() {
        return super.getAdresse(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        super.setAdresse(adresse); //To change body of generated methods, choose Tools | Templates.
    }
    
}
