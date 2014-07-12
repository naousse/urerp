/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)

//Requêtes nommées
@NamedQueries({
    @NamedQuery(name = "Periode.findAll", query = "SELECT p FROM Periode p"),
    @NamedQuery(name = "Periode.findById", query = "SELECT p FROM Periode p WHERE p.id = :id")
})
public class Periode implements Serializable {
    
    public final static String FIND_ALL = "Periode.findAll";
    public final static String FINDByID = "Periode.findById";
    
    protected Long id;
    protected Date dateDebut;
    protected Date dateFin;
    protected Fonction fonction;
    protected Employe employe;
    
    
    public Periode() {
        fonction = new Fonction();
        employe = new Employe();
    }

    public Periode(Long id, Date dateDebut, Date dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @NotNull(message = "urerp.entity.date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateDebut() {
        return dateDebut;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateFin() {
        return dateFin;
    }

    @ManyToOne
    public Employe getEmploye() {
        return employe;
    }

    @ManyToOne
    public Fonction getFonction() {
        return fonction;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }


    
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

}
