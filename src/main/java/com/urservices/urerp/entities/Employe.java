/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id"),
    @NamedQuery(name = "Employe.findByCni", query = "SELECT e FROM Employe e WHERE e.cni = :cni")
})
public class Employe implements Serializable {
    
    public final static String FIND_ALL = "Employe.findAll";
    public final static String FINDByID = "Employe.findById";
    public final static String FINDByCNI = "Employe.findByCni";
    
    protected Long id;
    protected String cni;
    protected String nom;
    protected String prenom;
    protected Adresse adresse;
    protected List<Operation> operations;
    protected List<Periode> periodes ;

    
    public Employe() {
        adresse = new Adresse();
    }

    public Employe(Long id, String cni, String nom, String prenom, Adresse adresse) {
        this.id = id;
        this.cni = cni;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    
    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "{urerp.entity.required}")
    public Long getId() {
        return id;
    }

    public String getCni() {
        return cni;
    }

    @NotNull(message = "{urerp.entity.required}")
    @Size(min = 3, max = 30, message = "{urerp.entity.size}")
    public String getNom() {
        return nom;
    }

    @Size(min = 3, max = 30, message = "{urerp.entity.size}")
    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @OneToMany(mappedBy = "employe")
    public List<Operation> getOperations() {
        return operations;
    }

    @OneToMany(mappedBy = "employe")
    public List<Periode> getPeriodes() {
        return periodes;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }
    
    public void addPeriode(Periode periode){
        this.periodes.add(periode);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
