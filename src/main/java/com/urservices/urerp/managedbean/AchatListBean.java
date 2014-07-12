/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "achatListBean")
@ViewScoped
public class AchatListBean implements Serializable{
    
    private Achat achat;
    private List<Achat> achats;
    private Produit produit;
    private List<Produit> produits;
    private boolean buttonDisabled = true;
    
    @EJB
    private IAchatEJBMetierLocal iAchatEJBMetierLocal;

    /**
     * Creates a new instance of AchatListBean
     */
    public AchatListBean() {
        achat = new Achat();
        buttonDisabled = true;
    }

    public Achat getAchat() {
        return achat;
    }

    public List<Achat> getAchats() {
        return achats;
    }
    
    public void setAchat(Achat achat) {
        this.achat = achat;
        buttonDisabled = false;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }
    
    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Achat> getAllAchats() {
        return iAchatEJBMetierLocal.findAll();
    }

    public String getEditUrl() {
        return "/achat/edit";
    }

    public String getShowUrl() {
        return "/achat/show";
    }
    
    public String getDeleteUrl() {
        return "/achat/delete";
    }
}
