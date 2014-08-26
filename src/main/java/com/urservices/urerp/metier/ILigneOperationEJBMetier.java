/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Operation;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ILigneOperationEJBMetier {
    
    public LigneOperation create(LigneOperation ligneOperation);
    
    public LigneOperation update(LigneOperation ligneOperation);
    
    public int delete(LigneOperation ligneOperation);
    
    public LigneOperation findById(Long id);
    
    public List<LigneOperation> findAll();
    
     public Long findMaxIdLigneOperationForAnOperation(Operation operation);
    
     public List<LigneOperation> findAllLigneOperationsForOneOperation(Operation operation);
    
}
