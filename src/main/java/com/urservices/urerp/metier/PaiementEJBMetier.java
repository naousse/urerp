/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IPaiementEJBDaoLocal;
import com.urservices.urerp.entities.Operation;
import com.urservices.urerp.entities.Paiement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class PaiementEJBMetier implements IPaiementEJBMetierLocal, IPaiementEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IPaiementEJBDaoLocal
    @EJB
    private IPaiementEJBDaoLocal iPaiementEJBDaoLocal;

    @Override
    public Paiement create(Paiement paiement) {
        return iPaiementEJBDaoLocal.create(paiement);
    }

    @Override
    public Paiement update(Paiement paiement) {
        return iPaiementEJBDaoLocal.update(paiement);
    }

    @Override
    public int delete(Paiement paiement) {
        return iPaiementEJBDaoLocal.delete(paiement);
    }

    @Override
    public Paiement findById(Long id) {
        return iPaiementEJBDaoLocal.findById(id);
    }

    @Override
    public List<Paiement> findAll() {
        return iPaiementEJBDaoLocal.findAll();
    }

    @Override
    public List<Paiement> findAllPaiementsOperation(Operation operation) {
        return iPaiementEJBDaoLocal.findAllPaiementsOperation(operation);
    }
}
