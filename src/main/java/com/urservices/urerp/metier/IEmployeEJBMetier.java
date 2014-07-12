/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.entities.Periode;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IEmployeEJBMetier {
    
    public void changer(Employe employe, Periode periode);
     
    public Employe create(Employe employe);
    
    public void create(Employe employe, Periode periode);
    
    public Employe update(Employe employe);
    
    public Employe update(Employe employe, Periode periode);
    
    public int delete(Employe employe);
    
    public Employe findById(Long id);
    
    public List<Employe> findAll();
    
    public Employe findByCni(String cni);
    
}
