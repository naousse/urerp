/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Produit;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IProduitEJBDao {
    
    public Produit create(Produit produit);
    
    public Produit update(Produit produit);
    
    public int delete(Produit produit);
    
    public Produit findById(Long id);
    
    public List<Produit> findAll();
    
}
