/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Fonction;
import com.urservices.urerp.metier.IFonctionEJBMetierLocal;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
//Bean géré
@Named(value = "fonctionBean")

//Matérialise la durée de vie du bean (temps d'une requête pour @RequestScoped)
@RequestScoped
public class FonctionBean implements Serializable {

    private Fonction fonction;
    private List<Fonction> fonctions;
    private FacesContext context = FacesContext.getCurrentInstance();
    private Long fonctionId;
    
    //Injection d'une référence vers l'EJB IFonctionEJBMetierLocal
    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;

    /**
     * Creates a new instance of FonctionBean
     */
    public FonctionBean() {
        fonction = new Fonction();
        fonctions = new ArrayList<Fonction>();
    }

    public Fonction getFonction() {
        return fonction;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public Long getFonctionId() {
        return fonctionId;
    }

    public void setFonctionId(Long fonctionId) {
        this.fonctionId = fonctionId;
        fonction = iFonctionEJBMetierLocal.findById(fonctionId);
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public String doCreate() throws IOException {
        iFonctionEJBMetierLocal.create(fonction);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + fonction.getId());
        return "show";
    }

    public String doNew() {
        return "/fonction/new?faces-redirect=true";
    }

    public String doList() {
        return "/fonction/list?faces-redirect=true";
    }

    public String doUpdate() throws IOException {
        iFonctionEJBMetierLocal.update(fonction);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + fonction.getId());
        return "show";
    }

    public String doEdit() {
        return "edit.xhtml";
    }

    public String doShow() {
        return "show";
    }

    public void doFind() {
        fonction = iFonctionEJBMetierLocal.findById(fonctionId);
    }
}
