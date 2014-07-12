/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IProduitEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "produitListBean")
@ViewScoped
public class ProduitListBean implements Serializable{
    
    private Produit produit;
    private boolean buttonDisabled = true;
    private List<Produit> produits;
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;

    /**
     * Creates a new instance of ProduitListBean
     */
    public ProduitListBean() {
        System.out.println("Initialisation");
        produit = new Produit();
        buttonDisabled = true;
    }

    public Produit getProduit() {
        System.out.println("Lecture "+this.produit);
        return this.produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduit(Produit produit) {
        System.out.println("Ecriture "+produit);
        this.produit = produit;
        System.out.println("Ecriture "+this.produit);
        buttonDisabled = false;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Produit> getAllProduits() {
        return iProduitEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/produit/edit";
    }
    
    public String getShowUrl() {
        return "/produit/show";
    }
}
