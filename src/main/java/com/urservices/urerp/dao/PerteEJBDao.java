/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Perte;
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
public class PerteEJBDao implements IPerteEJBDaoLocal, IPerteEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état PerteEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Perte create(Perte perte) {
        em.persist(perte);
        return perte;
    }

    @Override
    public Perte update(Perte perte) {
        Perte updatePerte;
        updatePerte = em.merge(perte);
        return updatePerte;
    }

    @Override
    public int delete(Perte perte) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Perte p WHERE p.id = :id");
        query.setParameter("id", perte.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Perte findById(Long id) {
        Query query = em.createNamedQuery("Perte.findById").setParameter("id", id);
        return (Perte)query.getSingleResult();
    }

    @Override
    public List<Perte> findAll() {
        Query query = em.createNamedQuery("Perte.findAll");
        return (List<Perte>)query.getResultList();
    }

}
