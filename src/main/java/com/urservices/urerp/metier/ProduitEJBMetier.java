/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IProduitEJBDaoLocal;
import com.urservices.urerp.entities.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class ProduitEJBMetier implements IProduitEJBMetierLocal, IProduitEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IProduitEJBDaoLocal
    @EJB
    private IProduitEJBDaoLocal iProduitEJBDaoLocal;

    @Override
    public Produit create(Produit produit) {
        return iProduitEJBDaoLocal.create(produit);
    }

    @Override
    public Produit update(Produit produit) {
        return iProduitEJBDaoLocal.update(produit);
    }

    @Override
    public int delete(Produit produit) {
        return iProduitEJBDaoLocal.delete(produit);
    }

    @Override
    public Produit findById(Long id) {
        return iProduitEJBDaoLocal.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return iProduitEJBDaoLocal.findAll();
    }

}
