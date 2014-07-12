/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Paiement;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IPaiementEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "paiementListBean")
@ViewScoped
public class PaiementListBean implements Serializable{
    
    private Paiement paiement;
    private List<Paiement> paiements;
    private Produit produit;
    private List<Produit> produits;
    private boolean buttonDisabled = true;
    
    @EJB
    private IPaiementEJBMetierLocal iPaiementEJBMetierLocal;

    public PaiementListBean() {
        paiement = new Paiement();
        buttonDisabled = true;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public Produit getProduit() {
        return produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
        buttonDisabled = false;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public String getEditUrl() {
        return "/paiement/edit";
    }

    public String getShowUrl() {
        return "/paiement/show";
    }
}
