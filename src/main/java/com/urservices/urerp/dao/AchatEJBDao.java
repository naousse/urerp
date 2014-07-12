/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Achat;
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
public class AchatEJBDao implements IAchatEJBDaoLocal, IAchatEJBDaoRemote, Serializable {

    /* Injection d'une référence à un gestionnaire d'entités 
     dans l'EJB sans état AchatEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;
    private Object numero;

    @Override
    public Achat create(Achat achat) {
        em.persist(achat);
        return achat;
    }

    @Override
    public Achat update(Achat achat) {
        Achat updateAchat;
        updateAchat = em.merge(achat);
        return updateAchat;
    }

    @Override
    public int delete(Achat achat) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Achat a WHERE a.id = :id");
        query.setParameter("id", achat.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Achat findById(Long id) {
        Query query = em.createNamedQuery("Achat.findById").setParameter("id", id);
        return (Achat) query.getSingleResult();
    }

    @Override
    public List<Achat> findAll() {
        Query query = em.createNamedQuery("Achat.findAll");
        return (List<Achat>) query.getResultList();
    }

    @Override
    public Achat findByNumero(String numero) {
        Query query = em.createNamedQuery("Achat.findByNumero").setParameter("numero", numero);
        int nombreDeResultat = ((List<Achat>)query.getResultList()).size();
        if (nombreDeResultat == 1) {
            return (Achat)query.getSingleResult();
        }
        return null;
    }

}
