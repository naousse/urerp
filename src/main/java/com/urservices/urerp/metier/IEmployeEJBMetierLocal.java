/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;



import com.urservices.urerp.entities.Employe;
import javax.ejb.Local;

/**
 *
 * @author samuel
 */
@Local
public interface IEmployeEJBMetierLocal extends IEmployeEJBMetier{

    public Employe findById(String toString);

   
    
}
