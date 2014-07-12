/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.ModePaiement;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IModePaiementEJBDao {
    
    public ModePaiement create(ModePaiement modePaiement);
    
    public ModePaiement update(ModePaiement modePaiement);
    
    public int delete(ModePaiement modePaiement);
    
    public ModePaiement findById(Long id);
    
    public List<ModePaiement> findAll();
    
}
