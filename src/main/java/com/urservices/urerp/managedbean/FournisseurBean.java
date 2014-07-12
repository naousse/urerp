/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.metier.IFournisseurEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
//Bean géré
@Named(value = "fournisseurBean")

//Matérialise la durée de vie du bean (temps d'une requête pour @RequestScoped)
@RequestScoped
public class FournisseurBean implements Serializable{
    
    private Fournisseur fournisseur;
    
    private List<Fournisseur> fournisseurs;
    
    private Long fournisseurId;
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    //Injection d'une référence vers l'EJB IFournisseurEJBMetierLocal
    @EJB
    private IFournisseurEJBMetierLocal iFournisseurEJBMetierLocal;

    /**
     * Creates a new instance of FournisseurBean
     */
    public FournisseurBean() {
        fournisseur = new Fournisseur();
        fournisseurs = new ArrayList<Fournisseur>();
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public List<Fournisseur> getFournisseurs() {
        fournisseurs = iFournisseurEJBMetierLocal.findAll();
        return fournisseurs;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
        this.fournisseur = iFournisseurEJBMetierLocal.findById(fournisseurId);
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
    
    public String doCreate() throws IOException{
        iFournisseurEJBMetierLocal.create(fournisseur);
        context.getExternalContext().redirect("show.xhtml?q="+fournisseur.getId());
        return "show";
    }
    
    public String doNew(){
        return "/fournisseur/new?faces-redirect=true";
    }
    
    public String doList(){
        return "/fournisseur/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException{
        iFournisseurEJBMetierLocal.update(fournisseur);
        context.getExternalContext().redirect("/fournisseur/show.xhtml?q="+fournisseur.getId());
        return "show";
    }
    
    public String doEdit(){
        return "edit";
    }
    
    public String doShow(){
        return "show";
    }
    
    public void doFind(){
        fournisseur = iFournisseurEJBMetierLocal.findById(fournisseurId);
    }
    
}
