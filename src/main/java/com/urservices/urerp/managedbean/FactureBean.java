/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Facture;
import com.urservices.urerp.metier.IFactureEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author samuel
 */
@ManagedBean(name = "factureBean")
@RequestScoped
public class FactureBean implements Serializable{

    private Facture facture;
    private List<Facture> factures;
    private Long factureId;
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IFactureEJBMetierLocal iFactureEJBMetierLocal;
    /**
     * Creates a new instance of FactureBean
     */
    public FactureBean() {
        facture = new Facture();
        factures = new ArrayList<Facture>();
    }

    public Long getFactureId() {
        return factureId;
    }

    public Facture getFacture() {
        return facture;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
        this.facture = iFactureEJBMetierLocal.findById(factureId);
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
    
    public String doCreate() throws IOException {
        iFactureEJBMetierLocal.create(facture);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + facture.getId());
        return "show";
    }
    
    public String doNew() {
        return "/facture/new?faces-redirect=true";
    }

    public String doList() {
        return "/facture/list?faces-redirect=true";
    }

    public String doUpdate() throws IOException {
        iFactureEJBMetierLocal.update(facture);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + facture.getId());
        return "show";
    }

    public String doEdit() {
        return "edit.xhtml";
    }

    public String doShow() {
        return "show";
    }

    public String doDelete() {
        iFactureEJBMetierLocal.delete(facture);
        return "list";
    }
    
    public void doFind() {
        facture = iFactureEJBMetierLocal.findById(factureId);
    }
}
