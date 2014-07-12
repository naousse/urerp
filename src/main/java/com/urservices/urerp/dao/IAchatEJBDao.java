/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Achat;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IAchatEJBDao {
    
    public Achat create(Achat achat);
    
    public Achat update(Achat achat);
    
    public int delete(Achat achat);
    
    public Achat findById(Long id);
    
    public List<Achat> findAll();
    
    public Achat findByNumero(String numero);
    
}
