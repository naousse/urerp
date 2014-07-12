/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public abstract class Partenaire implements Serializable{
    
    protected Long id;
    protected String nom;
    protected Adresse adresse;
    protected List<Operation> operations;

    public Partenaire() {
        this.adresse = new Adresse();
    }

    public Partenaire(Long id, String nom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
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

    @NotNull(message = "{urerp.entity.required}")
    @Size(min = 2, max = 30, message = "{urerp.entity.size}")
    public String getNom() {
        return nom;
    }

    @Embedded
    public Adresse getAdresse() {
        return adresse;
    }

    @OneToMany(mappedBy = "partenaire")
    public List<Operation> getOperations() {
        return operations;
    }
  

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

   public void addOperation(Operation operation){
       this.operations.add(operation);
   }
    
}
