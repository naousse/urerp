/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Operation;
import com.urservices.urerp.entities.Paiement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author samuel
 */
//Bean de session sans état
@Stateless
public class PaiementEJBDao implements IPaiementEJBDaoLocal, IPaiementEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état PaiementEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    private EntityManager em;

    @Override
    public Paiement create(Paiement paiement) {
        em.persist(paiement);
        return paiement;
    }

    @Override
    public Paiement update(Paiement paiement) {
        Paiement updatePaiement;
        updatePaiement = em.merge(paiement);
        return updatePaiement;
    }

    @Override
    public int delete(Paiement paiement) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Paiement p WHERE p.id = :id");
        query.setParameter("id", paiement.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Paiement findById(Long id) {
        Query query = em.createNamedQuery("Paiement.findById").setParameter("id", id);
        return (Paiement)query.getSingleResult();
    }

    @Override
    public List<Paiement> findAll() {
        Query query = em.createNamedQuery("Paiement.findAll");
        return (List<Paiement>)query.getResultList();
    }

   

    @Override
    public List<Paiement> findAllPaiementsOperation(Operation operation) {
        Query query = em.createNamedQuery(Paiement.FIND_ALL_PAIEMENTS_OPERATION);
        query.setParameter("operation", operation);
        return (List<Paiement>)query.getResultList();}
}
