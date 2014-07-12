/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.ProduitManquants;
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
public class ProduitManquantsEJBDao implements IProduitManquantsEJBDaoLocal, IProduitManquantsEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état ProduitManquantsEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public ProduitManquants create(ProduitManquants produitManquants) {
        em.persist(produitManquants);
        return produitManquants;
    }

    @Override
    public ProduitManquants update(ProduitManquants produitManquants) {
        ProduitManquants updateProduitManquants;
        updateProduitManquants = em.merge(produitManquants);
        return updateProduitManquants;
    }

    @Override
    public int delete(ProduitManquants produitManquants) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM ProduitManquants pm WHERE pm.id = :id");
        query.setParameter("id", produitManquants.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public ProduitManquants findById(Long id) {
        Query query = em.createNamedQuery("ProduitManquants.findById").setParameter("id", id);
        return (ProduitManquants)query.getSingleResult();
    }

    @Override
    public List<ProduitManquants> findAll() {
        Query query = em.createNamedQuery("ProduitManquants.findAll");
        return (List<ProduitManquants>)query.getResultList();
    }

}
