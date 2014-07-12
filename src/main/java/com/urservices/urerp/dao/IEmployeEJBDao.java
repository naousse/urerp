/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Employe;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IEmployeEJBDao {
    
    public Employe create(Employe employe);
    
    public Employe update(Employe employe);
    
    public int delete(Employe employe);
    
    public Employe findById(Long id);
    
    public List<Employe> findAll();
    
    public Employe findByCni(String cni);
    
}
