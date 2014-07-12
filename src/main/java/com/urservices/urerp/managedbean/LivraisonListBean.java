/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.metier.ILivraisonEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@Named(value = "livraisonListBean")
@ViewScoped
public class LivraisonListBean implements Serializable{
    
    private Livraison livraison;
    private List<Livraison> livraisons;
    private boolean buttonDisabled = true;
    
    @EJB
    private ILivraisonEJBMetierLocal iLivraisonEJBMetierLocal;

    /**
     * Creates a new instance of LivraisonListBean
     */
    public LivraisonListBean() {
        livraison = new Livraison();
        buttonDisabled = true;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
        buttonDisabled = false;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Livraison> getAllLivraisons() {
        return iLivraisonEJBMetierLocal.findAll();
    }

    public String getEditUrl() {
        return "/livraison/edit";
    }

    public String getShowUrl() {
        return "/livraison/show";
    }
    
    public String getModificationUrl() {
        return "/livraison/modification";
    }
}
