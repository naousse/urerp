/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Paiement;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
import com.urservices.urerp.metier.IPaiementEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author samuel
 */
@Named(value = "paiementBean")
@RequestScoped
public class PaiementBean implements Serializable{
    
    private Paiement paiement;
    private List<Paiement> paiements;
    private Long paiementId;
    private Achat achat;
    private Long achatId;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IPaiementEJBMetierLocal iPaiementEJBMetierLocal;
    
    @EJB
    private IAchatEJBMetierLocal iAchatEJBMetierLocal;

    public PaiementBean() {
        paiement = new Paiement();
        paiements = new ArrayList<Paiement>();
    }

    public Long getPaiementId() {
        return paiementId;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public Long getAchatId() {
        return achatId;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setPaiementId(Long paiementId) {
        this.paiementId = paiementId;
        this.paiement = iPaiementEJBMetierLocal.findById(paiementId);
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public void setAchatId(Long achatId) {
        this.achatId = achatId;
        this.achat = iAchatEJBMetierLocal.findById(achatId);
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }
    
    public String doCreate() throws IOException {
        iPaiementEJBMetierLocal.create(paiement);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement éffectué avec succès", "Enregistrement éffectué avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + paiement.getId());
        return "show";
    }
    
    public String doNew() {
        return "/paiement/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/paiement/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iPaiementEJBMetierLocal.update(paiement);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification éffectuée avec succès", "Modification éffectuée avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + paiement.getId());
        return "show";
    }
    
    public String doEdit() {
        return "/paiement/edit?faces-redirect=true";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        paiement = iPaiementEJBMetierLocal.findById(paiementId);
    }
    
    public String getDeleteUrl() {
        return "/achat/show?faces-redirect=true";
    }
}
