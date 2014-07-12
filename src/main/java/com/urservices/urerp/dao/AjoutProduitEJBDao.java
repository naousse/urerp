/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author samuel
 */
@Stateful 
public class AjoutProduitEJBDao implements IAjoutProduitEJBDaoLocal, IAjoutProduitEJBDaoRemote, Serializable{

    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;
    
    @Override
    public Produit create(Produit produit) {
        em.persist(produit);
        return produit;
    }

    @Override
    public Produit update(Produit produit) {
        Produit updateProduit;
        updateProduit = em.merge(produit);
        return updateProduit;
    }

    @Override
    public int delete(Produit produit) {
        int nombreDeLigenAffectées = 0;
        Query query = em.createQuery("DELETE FROM Produit p WHERE p.id = :id");
        query.setParameter("id", produit.getId());
        nombreDeLigenAffectées = query.executeUpdate();
        return nombreDeLigenAffectées;
    }

    @Override
    public Produit findById(Long id) {
        Query query = em.createNamedQuery("Produit.findById").setParameter("id", id);
        return (Produit)query.getSingleResult();
    }

    @Override
    public List<Produit> findAll() {
        Query query = em.createNamedQuery("Produit.findAll");
        return (List<Produit>)query.getResultList();
    }
}
