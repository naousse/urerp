/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Vente;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IVenteEJBMetier {
    
    public Vente create(Vente vente);
    
    public Vente createCP(Vente vente, CPhysique physique, List<LigneOperation> ligneOperations);
    
    public Vente createCE(Vente vente, CEntreprise entreprise, List<LigneOperation> ligneOperations);
    
    public Vente update(Vente vente);
    
    public int delete(Vente vente);
    
    public Vente findById(Long id);
    
    public List<Vente> findAll();
    
}
