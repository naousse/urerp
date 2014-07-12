/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Stock;
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
public class StockEJBDao implements IStockEJBDaoLocal, IStockEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état StockEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    private EntityManager em;

    @Override
    //Création d'un stock
    public Stock create(Stock stock) {
        em.persist(stock);
        return stock;
    }

    @Override
    //Mise à jour d'un stock
    public Stock update(Stock stock) {
        Stock updateStock;
        updateStock = em.merge(stock);
        return updateStock;
    }

    @Override
    //Suppression d'un stock
    public int delete(Stock stock) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Stock s WHERE s.id = :id");
        query.setParameter("id", stock.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    //Recherche d'un stock à l'aide de son identifiant
    public Stock findById(Long id) {
        Query query = em.createNamedQuery("Stock.findById").setParameter("id", id);
        return (Stock)query.getSingleResult();
    }

    @Override
    //Recherche de la liste de tout les stocks
    public List<Stock> findAll() {
        Query query = em.createNamedQuery("Stock.findAll");
        return (List<Stock>)query.getResultList();
    }

}
