/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.LigneOperation;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ILigneOperationEJBDao {
    
    public LigneOperation create(LigneOperation ligneOperation);
    
    public LigneOperation update(LigneOperation ligneOperation);
    
    public int delete(LigneOperation ligneOperation);
    
    public LigneOperation findById(Long id);
    
    public List<LigneOperation> findAll();
    
}
