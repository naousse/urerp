/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.entities.LigneOperation;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IAchatEJBMetier {
    
    public Achat create(Achat achat);
    
    public Achat create(Achat achat, Fournisseur fournisseur, List<LigneOperation> ligneOperations);
    
    public Achat update(Achat achat);
    
    public int delete(Achat achat);
    
    public Achat findById(Long id);
    
    public List<Achat> findAll();
    
    public Achat findByNumero(String numero);
    
}
