/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Fonction;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IFonctionEJBDao {
    
    public Fonction create(Fonction fonction);
    
    public Fonction update(Fonction fonction);
    
    public int delete(Fonction fonction);
    
    public Fonction findById(Long id);
    
    public List<Fonction> findAll();
    
    public Fonction findByLibelle(String libelle);
    
}
