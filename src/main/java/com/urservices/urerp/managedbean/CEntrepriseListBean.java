/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.metier.ICEntrepriseEJBMetierLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "cEntrepriseListBean")
@ViewScoped
public class CEntrepriseListBean implements Serializable{

    private CEntreprise clientEntreprise;
    
    private List<CEntreprise> clientEntreprises;
    
    private boolean butonDisabled;
    
    @EJB
    private ICEntrepriseEJBMetierLocal iCEntrepriseEJBMetierLocal;
    
    /**
     * Creates a new instance of CEntrepriseListBean
     */
    public CEntrepriseListBean() {
        clientEntreprise = new CEntreprise();
        butonDisabled = true;
    }

    public CEntreprise getClientEntreprise() {
        return clientEntreprise;
    }

    public List<CEntreprise> getClientEntreprises() {
        return clientEntreprises;
    }

    public void setClientEntreprise(CEntreprise clientEntreprise) {
        this.clientEntreprise = clientEntreprise;
        butonDisabled = false;
    }

    public void setClientEntreprises(List<CEntreprise> clientEntreprises) {
        this.clientEntreprises = clientEntreprises;
    }

    public boolean isButonDisabled() {
        return butonDisabled;
    }
    
    public List<CEntreprise> getAllCEntreprise() {
        return iCEntrepriseEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/cliententreprise/edit";
    }
    
    public String getShowUrl() {
        return "/cliententreprise/show";
    }
    
    public String getModificationUrl() {
        return "/cliententreprise/modification";
    }
}
