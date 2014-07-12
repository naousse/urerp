/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.metier.IFournisseurEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
//Bean géré
@ManagedBean(name = "fournisseurListBean")

//Matérialise la durée de vie du bean (durée d'affichage d'une vue)
@ViewScoped
public class FournisseurListBean implements Serializable{
    
    private Fournisseur fournisseur;
    
    private List<Fournisseur> fournisseurs;
    
    private boolean buttonDisabled = true;
    
    //Injection d'une référence vers l'EJB IEmployeEJBMetierLocal
    @EJB
    private IFournisseurEJBMetierLocal iFournisseurEJBMetierLocal;

    /**
     * Creates a new instance of FournisseurListBean
     */
    public FournisseurListBean() {
        fournisseur = new Fournisseur();
        buttonDisabled = true;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        buttonDisabled = false;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Fournisseur> getAllFournisseurs() {
        return iFournisseurEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/fournisseur/edit";
    }
    
    public String getShowUrl() {
        return "/fournisseur/show";
    }
    
    public String getModificationUrl() {
        return "/fournisseur/modification";
    }
}
