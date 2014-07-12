/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Vente;
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
public class VenteEJBDao implements IVenteEJBDaoLocal, IVenteEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état VenteEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    //Création d'une vente
    public Vente create(Vente vente) {
        em.persist(vente);
        return vente;
    }

    @Override
    //Mise à jour d'une vente
    public Vente update(Vente vente) {
        Vente updateVente;
        updateVente = em.merge(vente);
        return updateVente;
    }

    @Override
    //Suppression d'une vente
    public int delete(Vente vente) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Vente v WHERE v.id = :id");
        query.setParameter("id", vente.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    //Recherche d'une vente à l'aide de son identifiant
    public Vente findById(Long id) {
        Query query = em.createNamedQuery("Vente.findById").setParameter("id", id);
        return (Vente)query.getSingleResult();
    }

    @Override
    //Recherche de la liste de toute les ventes
    public List<Vente> findAll() {
        Query query = em.createNamedQuery("Vente.findAll");
        return (List<Vente>)query.getResultList();
    }

}
