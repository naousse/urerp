/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Partenaire;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IPartenaireEJBDao {
    
    public Partenaire create(Partenaire partenaire);
    
    public Partenaire update(Partenaire partenaire);
    
    public int delete(Partenaire partenaire);
    
    public Partenaire findById(Long id);
    
    public List<Partenaire> findAll();
    
}
