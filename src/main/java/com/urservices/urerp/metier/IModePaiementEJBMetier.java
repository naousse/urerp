/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.ModePaiement;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IModePaiementEJBMetier {
    
    public ModePaiement create(ModePaiement modePaiement);
    
    public ModePaiement update(ModePaiement modePaiement);
    
    public int delete(ModePaiement modePaiement);
    
    public ModePaiement findById(Long id);
    
    public List<ModePaiement> findAll();
    
}
