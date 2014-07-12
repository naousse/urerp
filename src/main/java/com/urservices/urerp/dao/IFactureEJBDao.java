/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Facture;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IFactureEJBDao {
    
    public Facture create(Facture facture);
    
    public Facture update(Facture facture);
    
    public int delete(Facture facture);
    
    public Facture findById(Long id);
    
    public List<Facture> findAll();
    
}
