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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT fr FROM Fournisseur fr"),
    @NamedQuery(name = "Fournisseur.findById", query = "SELECT fr FROM Fournisseur fr WHERE fr.id = :id"),
    @NamedQuery(name = "Fournisseur.findByCode", query = "SELECT fr FROM Fournisseur fr WHERE fr.code = :code")
})
public class Fournisseur extends Partenaire implements Serializable {
    
    public final static String FIND_ALL = "Fournisseur.findAll";
    public final static String FINDByID = "Fournisseur.findById";
    public final static String FINDByCODE = "Fournisseur.findByCode";
    
    private String code;
    private String pays;

    public Fournisseur() {
        super();
    }

    public Fournisseur(String pays, Long id, String code, String nom, Adresse adresse) {
        super(id, nom, adresse);
        this.pays = pays;
        this.code = code;
    }

    @Override
    public Long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        return super.getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    @NotNull(message = "{urerp.entity.required}")
    @Size(min = 3, max = 10, message = "{urerp.entity.size}")
    public String getCode() {
        return code;
    }

    @Size(min = 4, max = 50, message = "{urerp.entity.size}")
    public String getPays() {
        return pays;
    }

    @Override
    public Adresse getAdresse() {
        return super.getAdresse(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        super.setAdresse(adresse); //To change body of generated methods, choose Tools | Templates.
    }
    
}
