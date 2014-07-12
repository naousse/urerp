/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface ILivraisonEJBMetier {
    
    public Livraison create(Livraison livraison);
    
    public Livraison update(Livraison livraison);
    
    public int delete(Livraison livraison);
    
    public Livraison findById(Long id);
    
    public List<Livraison> findAll();
    
    public Livraison create(Livraison livraison, List<LigneOperation> ligneOperations);
    
}
