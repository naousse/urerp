/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.ProduitManquants;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IProduitManquantsEJBDao {
    
    public ProduitManquants create(ProduitManquants produitManquants);
    
    public ProduitManquants update(ProduitManquants produitManquants);
    
    public int delete(ProduitManquants produitManquants);
    
    public ProduitManquants findById(Long id);
    
    public List<ProduitManquants> findAll();
    
}
