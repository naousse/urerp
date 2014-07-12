/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IFournisseurEJBDao {
    
    public Fournisseur create(Fournisseur fournisseur);
    
    public Fournisseur update(Fournisseur fournisseur);
    
    public int delete(Fournisseur fournisseur);
    
    public Fournisseur findById(Long id);
    
    public Fournisseur findByCode(String code);
    
    public List<Fournisseur> findAll();
    
    public Fournisseur findFournisseurAchat(Achat achat);
}
