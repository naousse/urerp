/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Vente;
import com.urservices.urerp.metier.IVenteEJBMetierLocal;
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
@ManagedBean(name = "venteListBean")
@ViewScoped
public class VenteListBean implements Serializable{
    
    private Vente vente;
    private boolean buttonDisabled = true;
    private List<Vente> ventes;

    FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IVenteEJBMetierLocal iVenteEJBMetierLocal;
    
    /**
     * Creates a new instance of VenteListBean
     */
    public VenteListBean() {
        vente = new Vente();
        buttonDisabled = true;
    }

    public Vente getVente() {
        return vente;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
        buttonDisabled = false;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Vente> getAllVentes() {
        return iVenteEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/vente/edit";
    }
    
    public String getShowUrl() {
        return "/vente/show";
    }
}
