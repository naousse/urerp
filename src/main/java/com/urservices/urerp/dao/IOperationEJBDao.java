/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Operation;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IOperationEJBDao {
    
    public Operation create(Operation operation);
    
    public Operation update(Operation operation);
    
    public int delete(Operation operation);
    
    public Operation findById(Long id);
    
    public List<Operation> findAll();
    
}
