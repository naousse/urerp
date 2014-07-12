/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Produit;
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
public class ProduitEJBDao implements IProduitEJBDaoLocal, IProduitEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état ProduitEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    private EntityManager em;

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
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Produit p WHERE p.id = :id");
        query.setParameter("id", produit.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
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
