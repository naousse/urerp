/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.entities.Periode;
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
public class PeriodeEJBDao implements IPeriodeEJBDaoLocal, IPeriodeEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état PeriodeEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Periode create(Periode periode) {
        em.persist(periode);
        return periode;
    }

    @Override
    public Periode update(Periode periode) {
        Periode updatePeriode;
        updatePeriode = em.merge(periode);
        return updatePeriode;
    }

    @Override
    public int delete(Periode periode) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Periode p WHERE p.id = :id");
        query.setParameter("id", periode.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Periode findById(Long id) {
        Query query = em.createNamedQuery("Periode.findById").setParameter("id", id);
        return (Periode)query.getSingleResult();
    }

    @Override
    public List<Periode> findAll() {
        Query query = em.createNamedQuery("Periode.findAll");
        return (List<Periode>)query.getResultList();
    }

    @Override
    public Periode findPeriodeActifEmploye(Employe employe) {
       Query query = em.createQuery("SELECT p FROM Periode p WHERE p.employe = :employe AND p.dateFin=null");
        query.setParameter("employe",employe);
        return (Periode)query.getSingleResult();
    }

    @Override
    public List<Periode> findPeriodesEmploye(Employe employe) {
        Query query = em.createQuery("SELECT p FROM Periode p WHERE p.employe = :employe");
        query.setParameter("employe",employe);
        return (List<Periode>)query.getResultList();
    }

}
