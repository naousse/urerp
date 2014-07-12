/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IProduitManquantsEJBDaoLocal;
import com.urservices.urerp.entities.ProduitManquants;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class ProduitManquantsEJBMetier implements IProduitManquantsEJBMetierLocal, IProduitManquantsEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IProduitManquantsEJBDaoLocal
    @EJB
    private IProduitManquantsEJBDaoLocal iProduitManquantsEJBDaoLocal;

    @Override
    public ProduitManquants create(ProduitManquants produitManquants) {
        return iProduitManquantsEJBDaoLocal.create(produitManquants);
    }

    @Override
    public ProduitManquants update(ProduitManquants produitManquants) {
        return iProduitManquantsEJBDaoLocal.update(produitManquants);
    }

    @Override
    public int delete(ProduitManquants produitManquants) {
        return iProduitManquantsEJBDaoLocal.delete(produitManquants);
    }

    @Override
    public ProduitManquants findById(Long id) {
        return iProduitManquantsEJBDaoLocal.findById(id);
    }

    @Override
    public List<ProduitManquants> findAll() {
        return iProduitManquantsEJBDaoLocal.findAll();
    }

}
