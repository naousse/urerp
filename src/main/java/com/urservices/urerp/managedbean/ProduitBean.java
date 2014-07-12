/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IProduitEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
@Named(value = "produitBean")
@RequestScoped
public class ProduitBean implements Serializable{
    
    private Produit produit;
    
    private List<Produit> produits;
    
    private Long produitId;
    
    FacesContext context = FacesContext.getCurrentInstance();

    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;
    
    /**
     * Creates a new instance of ProduitBean
     */
    public ProduitBean() {
        produit = new Produit();
        produits = new ArrayList<Produit>();
    }

    public Long getProduitId() {
        return produitId;
    }

    public Produit getProduit() {
        return produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
        produit = iProduitEJBMetierLocal.findById(produitId);
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    public String doCreate() throws IOException {
        iProduitEJBMetierLocal.create(produit);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement éffectué avec succès", "Enregistrement éffectué avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + produit.getId());
        return "show";
    }
    
    public String doNew() {
        return "/produit/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/produit/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iProduitEJBMetierLocal.update(produit);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification éffectuée avec succès", "Modification éffectuée avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + produit.getId());
        return "show";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        produit = iProduitEJBMetierLocal.findById(produitId);
    }
}
