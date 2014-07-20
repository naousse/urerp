/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel
 */
//Cette Classe est une entitée
@Entity
@Access(AccessType.PROPERTY)
public abstract class Operation implements Serializable{
    
    protected Long id;
    protected String numero;
    protected Date dateOperation;
    protected Partenaire partenaire;
    protected Employe employe;
    protected ModePaiement modePaiment;
    protected List<LigneOperation> ligneOperations;
    protected Operation operation;

    public Operation() {
        ligneOperations = new ArrayList<LigneOperation>();
    }

    public Operation(Long id, String numero, Date dateOperation) {
        this();
        this.id = id;
        this.numero = numero;
        this.dateOperation = dateOperation;
    }

    //Cet attribut est une clé primaire
    @Id
    //Cet attribut sera généré automaiquement
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    @NotNull(message = "{urerp.entity.required}")
    public String getNumero() {
        return numero;
    }

    @ManyToOne
    public Partenaire getPartenaire() {
        return partenaire;
    }
    
    @ManyToOne
    public Employe getEmploye() {
        return employe;
    }

    @ManyToOne
    public ModePaiement getModePaiment() {
        return modePaiment;
    }

  

    @OneToMany(mappedBy = "operation")
    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }

    @NotNull(message = "{urerp.entity.date}")
    @Temporal(TemporalType.DATE)
    public Date getDateOperation() {
        return dateOperation;
    }

    @ManyToOne
    public Operation getOperation() {
        return operation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setModePaiment(ModePaiement modePaiment) {
        this.modePaiment = modePaiment;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    

    public void addLigneOperations(LigneOperation ligneOperation){
        this.ligneOperations.add(ligneOperation);
    }
    
}
