/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.metier.ICPhysiqueEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "cPhysiqueListBean")
@ViewScoped
public class CPhysiqueListBean implements Serializable{
    
    private CPhysique clientPhysique;
    
    private List<CPhysique> clientPhysiques;
    
    private boolean buttonDisabled = true;
    
    @EJB
    private ICPhysiqueEJBMetierLocal iCPhysiqueEJBMetierLocal;

    /**
     * Creates a new instance of CPhysiqueListBean
     */
    public CPhysiqueListBean() {
        clientPhysique = new CPhysique();
        buttonDisabled = true;
    }

    public CPhysique getClientPhysique() {
        return clientPhysique;
    }

    public List<CPhysique> getClientPhysiques() {
        return clientPhysiques;
    }


    public void setClientPhysique(CPhysique clientPhysique) {
        buttonDisabled = false;
        this.clientPhysique = clientPhysique;
    }

    public void setClientPhysiques(List<CPhysique> clientPhysiques) {
        this.clientPhysiques = clientPhysiques;
    }


    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<CPhysique> getAllCPhysique() {
        return iCPhysiqueEJBMetierLocal.findAll();
    }
    
    public String getEditUrl() {
        return "/clientphysique/edit.xhtml";
    }
    
    public String getShowUrl() {
        return "/clientphysique/show.xhtml";
    }
    
    public String getModificationUrl() {
        return "/clientphysique/modification";
    }
}
