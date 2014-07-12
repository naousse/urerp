/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Perte;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IPerteEJBDao {
    
    public Perte create(Perte perte);
    
    public Perte update(Perte perte);
    
    public int delete(Perte perte);
    
    public Perte findById(Long id);
    
    public List<Perte> findAll();
    
}
