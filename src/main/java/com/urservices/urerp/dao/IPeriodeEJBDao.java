/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.entities.Periode;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IPeriodeEJBDao {
    
    public Periode create(Periode periode);
    
    public Periode update(Periode periode);
    
    public int delete(Periode periode);
    
    public Periode findById(Long id);
    
    public Periode findPeriodeActifEmploye(Employe employe);
    
    public List<Periode> findAll();
    
    public List<Periode> findPeriodesEmploye(Employe employe);
    
}
