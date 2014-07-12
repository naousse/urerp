/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IFournisseurEJBMetier {
    
    public Fournisseur create(Fournisseur fournisseur);
    
    public Fournisseur update(Fournisseur fournisseur);
    
    public int delete(Fournisseur fournisseur);
    
    public Fournisseur findById(Long id);
    
    public Fournisseur findByCode(String code);
    
    public List<Fournisseur> findAll();
    
}
