/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.CPhysique;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ICPhysiqueEJBDao {
    
    public CPhysique create(CPhysique cPhysique);
    
    public CPhysique update(CPhysique cPhysique);
    
    public int delete(CPhysique cPhysique);
    
    public CPhysique findById(Long id);
    
    public List<CPhysique> findAll();
    
    public CPhysique findClientPhysiqueByCni(String cni);
}
