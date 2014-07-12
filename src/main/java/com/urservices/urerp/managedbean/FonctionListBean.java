/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Fonction;
import com.urservices.urerp.metier.IFonctionEJBMetierLocal;
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
@ManagedBean(name = "fonctionListBean")

//Matérialise la durée de vie du bean (durée d'affichage d'une vue)
@ViewScoped
public class FonctionListBean implements Serializable {

    private Fonction fonction;
    private List<Fonction> fonctions;
    private boolean buttonDisabled = true;
    
    //Injection d'une référence vers l'EJB IEmployeEJBMetierLocal
    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;

    /**
     * Creates a new instance of FonctionListBean
     */
    public FonctionListBean() {
        fonction = new Fonction();
        buttonDisabled = true;

    }

    public Fonction getFonction() {
        return fonction;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
        buttonDisabled = false;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }

    public List<Fonction> getAllFonctions() {
        return iFonctionEJBMetierLocal.findAll();
    }

    public String getEditUrl() {
        return "/fonction/edit";
    }

    public String getShowUrl() {
        return "/fonction/show";
    }
}
