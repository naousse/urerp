/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.entities.Fonction;
import com.urservices.urerp.entities.Periode;
import com.urservices.urerp.metier.IEmployeEJBMetierLocal;
import com.urservices.urerp.metier.IFonctionEJBMetierLocal;
import com.urservices.urerp.metier.IPeriodeEJBMetierLocal;
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
//Bean géré
@Named(value = "employeBean")

//Matérialise la durée de vie du bean (temps d'une requête pour @RequestScoped)
@RequestScoped
public class EmployeBean implements Serializable{
    
    private Employe employe;
    
    private Periode periode;
    
    private Periode nouvellePeriode;
    
    private List<Employe> employes;
    
    private List<Fonction> fonctions;
    
    private List<Periode> periodes;
    
    private Long employeId;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    //Injection d'une référence vers l'EJB IEmployeEJBMetierLocal
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;
    
    //Injection d'une référence vers l'EJB IFonctionEJBMetierLocal
    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;
    
    //Injection d'une référence vers l'EJB IPeriodeEJBMetierLocal
     @EJB
    private IPeriodeEJBMetierLocal iPeriodeEJBMetierLocal;

    /**
     * Creates a new instance of EmployeBean
     */
    public EmployeBean() {
        employe = new Employe();
        periode = new Periode();
        nouvellePeriode = new Periode();
        employes = new ArrayList<Employe>();
    }

    public Employe getEmploye() {
        return employe;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public Long getEmployeId() {
        return employeId;
    }

    public Periode getPeriode() {
        return periode;
    }

    public Periode getNouvellePeriode() {
        return nouvellePeriode;
    }

    public List<Fonction> getFonctions() {
        fonctions = iFonctionEJBMetierLocal.findAll();
        return fonctions;
    }

    public List<Periode> getPeriodes() {
        return periodes;
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }
    
    
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
       // periode = iPeriodeEJBMetierLocal.findPeriodeActifEmploye(employe);
        periodes = iPeriodeEJBMetierLocal.findPeriodesEmploye(employe);
        
    }
    
     public void setShowId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
        periodes = iPeriodeEJBMetierLocal.findPeriodesEmploye(employe);
        
    }
     
     
     
      public void setEditId(Long employeId) {
        this.employeId = employeId;
        employe = iEmployeEJBMetierLocal.findById(employeId);
        periode = iPeriodeEJBMetierLocal.findPeriodeActifEmploye(employe);
        
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setNouvellePeriode(Periode nouvellePeriode) {
        this.nouvellePeriode = nouvellePeriode;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
    
    /*Cette méthode permet de créer un employé
     * en invoquant l'EJB sans état correspondant*/
    public String doCreate() throws IOException {
          System.out.println(periode.getFonction().getId());
          iEmployeEJBMetierLocal.create(employe,periode);
          context.getExternalContext().redirect("show.xhtml?q=" + employe.getId());
        return "show";
    }
    
    //Cette méthode permet de naviguer vers new.xhtml
    public String doNew() {
        return "/employe/new?faces-redirect=true";
    }
    
    //Cette méthode permet de naviguer vers list.xhtml
    public String doList() {
        return "/employe/list?faces-redirect=true";
    }
    
    /*Cette méthode permet de modifier un employé
        en invoquant l'EJB sans état correspondant*/
    public String doUpdate() throws IOException {
        iEmployeEJBMetierLocal.update(employe,periode);
        context.getExternalContext().redirect("show.xhtml?q="+employe.getId());
        return "show";
    }
    
    //Cette méthode permet de naviguer vers edit.xhtml
    public String doEdit() {
        return "edit.xhtml";
    }
    
    //Cette méthode permet de naviguer vers show.xhtml
    public String doShow() {
        return "show";
    }
    
    /*Cette méthode permet de rechercher un employé
     * en invoquant l'EJB sans état correspondant*/
    public void doFind() {
        employe = iEmployeEJBMetierLocal.findById(employeId);
    }
    
    /*Cette méthode permet de modifier la période d'un employé
     * en invoquant les EJB sans état correspondant*/
    public String doModification() throws IOException {
        iPeriodeEJBMetierLocal.update(employe,periode);
        iEmployeEJBMetierLocal.changer(employe, nouvellePeriode);
        context.getExternalContext().redirect("show.xhtml?q="+employe.getId());
        return "show";
    }
}
