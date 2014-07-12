/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Facture;
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
public class FactureEJBDao implements IFactureEJBDaoLocal, IFactureEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état FactureEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Facture create(Facture facture) {
        em.persist(facture);
        return facture;
    }

    @Override
    public Facture update(Facture facture) {
        Facture updateFacture;
        updateFacture = em.merge(facture);
        return updateFacture;
    }

    @Override
    public int delete(Facture facture) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Facture f WHERE f.id = :id");
        query.setParameter("id", facture.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Facture findById(Long id) {
        Query query = em.createNamedQuery("Facture.findById").setParameter("id", id);
        return (Facture)query.getSingleResult();
    }

    @Override
    public List<Facture> findAll() {
        Query query = em.createNamedQuery("Facture.findAll");
        return (List<Facture>)query.getResultList();
    }

}
