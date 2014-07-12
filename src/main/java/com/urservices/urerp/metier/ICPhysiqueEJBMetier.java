/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.CPhysique;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ICPhysiqueEJBMetier {
    
    public CPhysique create(CPhysique cPhysique);
    
    public CPhysique update(CPhysique cPhysique);
    
    public int delete(CPhysique cPhysique);
    
    public CPhysique findById(Long id);
    
    public List<CPhysique> findAll();
    
    public CPhysique findClientPhysiqueByCni(String cni);
    
}
