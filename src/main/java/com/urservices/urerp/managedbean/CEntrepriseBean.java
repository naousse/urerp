/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.metier.ICEntrepriseEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author samuel
 */
@Named(value = "cEntrepriseBean")
@RequestScoped
public class CEntrepriseBean implements Serializable{
    
    private CEntreprise clientEntreprise;
    
    private List<CEntreprise> clientEntreprises;
    
    private Long clientEntrepriseId;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private ICEntrepriseEJBMetierLocal iCEntrepriseEJBMetierLocal;

    /**
     * Creates a new instance of CEntrepriseBean
     */
    public CEntrepriseBean() {
        clientEntreprise = new CEntreprise();
        clientEntreprises = new ArrayList<CEntreprise>();
    }

    public CEntreprise getClientEntreprise() {
        return clientEntreprise;
    }

    public Long getClientEntrepriseId() {
        return clientEntrepriseId;
    }

    public List<CEntreprise> getClientEntreprises() {
        return clientEntreprises;
    }

    public void setClientEntreprise(CEntreprise clientEntreprise) {
        this.clientEntreprise = clientEntreprise;
    }

    public void setClientEntrepriseId(Long clientEntrepriseId) {
        this.clientEntrepriseId = clientEntrepriseId;
        this.clientEntreprise = iCEntrepriseEJBMetierLocal.findById(clientEntrepriseId);
    }

    public void setClientEntreprises(List<CEntreprise> clientEntreprises) {
        this.clientEntreprises = clientEntreprises;
    }
    
    public String doCreate() throws IOException {
        iCEntrepriseEJBMetierLocal.create(clientEntreprise);
        context.getExternalContext().redirect("show.xhtml?q="+clientEntreprise.getId());
        return "show";
    }
    
    public String doNew() {
        return "/cliententreprise/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/cliententreprise/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iCEntrepriseEJBMetierLocal.update(clientEntreprise);
        context.getExternalContext().redirect("show.xhtml?q="+clientEntreprise.getId());
        return "show";
    }
    
    public String doEdit() {
        return "edit";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        clientEntreprise = iCEntrepriseEJBMetierLocal.findById(clientEntrepriseId);
    }
}
