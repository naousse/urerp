/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IAjoutProduitEJBDaoLocal;
import com.urservices.urerp.entities.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author samuel
 */
@Stateful
public class AjoutProduitEJBMetier implements IAjoutProduitEJBMetierLocal, IAjoutProduitEJBMetierRemote, Serializable{

    @EJB
    private IAjoutProduitEJBDaoLocal iAjoutProduitEJBDaoLocal;
    
    @Override
    public Produit create(Produit produit) {
        return iAjoutProduitEJBDaoLocal.create(produit);
    }

    @Override
    public Produit update(Produit produit) {
        return iAjoutProduitEJBDaoLocal.update(produit);
    }

    @Override
    public int delete(Produit produit) {
        return iAjoutProduitEJBDaoLocal.delete(produit);
    }

    @Override
    public Produit findById(Long id) {
        return iAjoutProduitEJBDaoLocal.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return iAjoutProduitEJBDaoLocal.findAll();
    }
}
