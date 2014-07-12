/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.CEntreprise;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ICEntrepriseEJBDao {
    
    public CEntreprise create(CEntreprise cEntreprise);
    
    public CEntreprise update(CEntreprise cEntreprise);
    
    public int delete(CEntreprise cEntreprise);
    
    public CEntreprise findById(Long id);
    
    public List<CEntreprise> findAll();
    
    public CEntreprise findByName(String nom);
    
}
