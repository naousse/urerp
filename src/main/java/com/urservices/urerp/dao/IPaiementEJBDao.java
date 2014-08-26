/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Operation;
import com.urservices.urerp.entities.Paiement;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IPaiementEJBDao {
    
    public Paiement create(Paiement paiement);
    
    public Paiement update(Paiement paiement);
    
    public int delete(Paiement paiement);
    
    public Paiement findById(Long id);
    
    public List<Paiement> findAll();
    
    public List<Paiement> findAllPaiementsOperation(Operation operation);
    
}
