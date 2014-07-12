/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.metier.ICPhysiqueEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
@Named(value = "cPhysiqueBean")
@RequestScoped
public class CPhysiqueBean implements Serializable{
    
    private CPhysique clientPhysique;
    
    private List<CPhysique> clientPhysiques;
    
    private Long clientPhysiqueId;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private ICPhysiqueEJBMetierLocal iCPhysiqueEJBMetierLocal;

    /**
     * Creates a new instance of CPhysiqueBean
     */
    public CPhysiqueBean() {
        clientPhysique = new CPhysique();
        clientPhysiques = new ArrayList<CPhysique>();
    }

    public CPhysique getClientPhysique() {
        return clientPhysique;
    }

    public Long getClientPhysiqueId() {
        return clientPhysiqueId;
    }

    public List<CPhysique> getClientPhysiques() {
        return clientPhysiques;
    }

    public void setClientPhysique(CPhysique clientPhysique) {
        this.clientPhysique = clientPhysique;
    }

    public void setClientPhysiqueId(Long clientPhysiqueId) {
        this.clientPhysiqueId = clientPhysiqueId;
        clientPhysique = iCPhysiqueEJBMetierLocal.findById(clientPhysiqueId);
    }

    public void setClientPhysiques(List<CPhysique> clientPhysiques) {
        this.clientPhysiques = clientPhysiques;
    }
    
    public String doCreate() throws IOException {
        iCPhysiqueEJBMetierLocal.create(clientPhysique);
        context.getExternalContext().redirect("show.xhtml?q="+clientPhysique.getId());
        return "show";
    }
    
    public String doNew() {
        return "/clientphysique/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/clientphysique/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iCPhysiqueEJBMetierLocal.update(clientPhysique);
        context.getExternalContext().redirect("show.xhtml?q="+clientPhysique.getId());
        return "show";
    }
    
    public String doEdit() {
        return "edit.xhtml";
    }
    
    public String doShow() {
        return "show";
    }
    
    public void doFind() {
        iCPhysiqueEJBMetierLocal.findById(clientPhysiqueId);
    }
}
