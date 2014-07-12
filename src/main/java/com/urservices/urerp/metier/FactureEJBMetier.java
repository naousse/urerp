/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IFactureEJBDaoLocal;
import com.urservices.urerp.entities.Facture;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class FactureEJBMetier implements IFactureEJBMetierLocal, IFactureEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IFactureEJBDaoLocal
    @EJB
    private IFactureEJBDaoLocal iFactureEJBDaoLocal;

    @Override
    public Facture create(Facture facture) {
        return iFactureEJBDaoLocal.create(facture);
    }

    @Override
    public Facture update(Facture facture) {
        return iFactureEJBDaoLocal.update(facture);
    }

    @Override
    public int delete(Facture facture) {
        return iFactureEJBDaoLocal.delete(facture);
    }

    @Override
    public Facture findById(Long id) {
        return iFactureEJBDaoLocal.findById(id);
    }

    @Override
    public List<Facture> findAll() {
        return iFactureEJBDaoLocal.findAll();
    }

}
