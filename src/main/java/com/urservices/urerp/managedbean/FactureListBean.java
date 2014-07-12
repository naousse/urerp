/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Facture;
import com.urservices.urerp.metier.IFactureEJBMetierLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
@Named(value = "factureListBean")
@ViewScoped
public class FactureListBean implements Serializable {
    
    private Facture facture;
    
    private List<Facture> factures;
    
    private boolean buttonDisabled = true;    
    
    @EJB
    private IFactureEJBMetierLocal iFactureEJBMetierLocal;

    /**
     * Creates a new instance of FactureListBean
     */
    public FactureListBean() {
        facture = new Facture();
        buttonDisabled = true;
    }

    public Facture getFacture() {
        return facture;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
        buttonDisabled = false;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Facture> getAllFactures() {
        return iFactureEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/facture/edit";
    }

    public String getShowUrl() {
        return "/facture/show";
    }
}
