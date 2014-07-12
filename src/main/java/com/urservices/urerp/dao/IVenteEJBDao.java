/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Vente;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IVenteEJBDao {
    
    public Vente create(Vente vente);
    
    public Vente update(Vente vente);
    
    public int delete(Vente vente);
    
    public Vente findById(Long id);
    
    public List<Vente> findAll();
    
}
