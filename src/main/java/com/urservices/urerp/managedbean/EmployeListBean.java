/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.metier.IEmployeEJBMetierLocal;
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
@ManagedBean(name = "employeListBean")

//Matérialise la durée de vie du bean (durée d'affichage d'une vue)
@ViewScoped
public class EmployeListBean implements Serializable{
    
    private Employe employe;
    
    private List<Employe> employes;
    
    private boolean buttonDisabled = true;
    
    //Injection d'une référence vers l'EJB IEmployeEJBMetierLocal
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;

    /**
     * Creates a new instance of EmployeListBean
     */
    public EmployeListBean() {
        employe = new Employe();
        buttonDisabled = true;
    }

    public Employe getEmploye() {
        System.out.println("get employé");
        return employe;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmploye(Employe employe) {
        System.out.println("Set employé");
        this.employe = employe;
        buttonDisabled = false;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public boolean isButtonDisabled() {
        System.out.println("Disbaled Button");
        return buttonDisabled;
    }
    
    public List<Employe> getAllEmployes() {
        return iEmployeEJBMetierLocal.findAll();
    }
    
     public String getEditUrl(){
         return "/employe/edit";
     }
     
     public String getShowUrl(){
         return "/employe/show";
     }
     
     public String getModificationUrl(){
         return "/employe/modification";
     }
}
