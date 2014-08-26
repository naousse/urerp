/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Operation;
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
public class LivraisonEJBDao implements ILivraisonEJBDaoLocal, ILivraisonEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état LivraisonEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Livraison create(Livraison livraison) {
        em.persist(livraison);
        return livraison;
    }

    @Override
    public Livraison update(Livraison livraison) {
        Livraison updateLivraison;
        updateLivraison = em.merge(livraison);
        return updateLivraison;
    }

    @Override
    public int delete(Livraison livraison) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Livraison l WHERE l.id = :id");
        query.setParameter("id", livraison.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }
    
    @Override
    public Livraison findById(Long id) {
        Query query = em.createNamedQuery("Livraison.findById").setParameter("id", id);
        return (Livraison)query.getSingleResult();
    }

    @Override
    public List<Livraison> findAll() {
        Query query = em.createNamedQuery("Livraison.findAll");
        return (List<Livraison>)query.getResultList();
    }

    @Override
    public List<Livraison> findAllLivraisonsOperation(Operation operation) {
        Query query = em.createNamedQuery("Livraison.findAllLivraisonsOperation").setParameter("operation", operation);
        return (List<Livraison>)query.getResultList();
    }

}
