/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.CPhysique;
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
public class CPhysiqueEJBDao implements ICPhysiqueEJBDaoLocal, ICPhysiqueEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état CPhysiqueEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public CPhysique create(CPhysique cPhysique) {
        em.persist(cPhysique);
        return cPhysique;
    }

    @Override
    public CPhysique update(CPhysique cPhysique) {
        CPhysique updateCPhysique;
        updateCPhysique = em.merge(cPhysique);
        return cPhysique;
    }

    @Override
    public int delete(CPhysique cPhysique) {
        int nombreDeLingesAffectées = 0;
        Query query = em.createQuery("DELETE FROM CPhysique cp WHERE cp.id = :id");
        query.setParameter("id", cPhysique.getId());
        nombreDeLingesAffectées = query.executeUpdate();
        return nombreDeLingesAffectées;
    }

    @Override
    public CPhysique findById(Long id) {
        Query query = em.createNamedQuery("CPhysique.findById").setParameter("id", id);
        return (CPhysique)query.getSingleResult();
    }

    @Override
    public List<CPhysique> findAll() {
        Query query = em.createNamedQuery("CPhysique.findAll");
        return (List<CPhysique>)query.getResultList();
    }

    @Override
    public CPhysique findClientPhysiqueByCni(String cni) {
        Query query = em.createNamedQuery("CPhysique.findClientPhysiqueByCni").setParameter("cni", cni);
        int totalResultat = ((List<CPhysique>)query.getResultList()).size();
        if (totalResultat == 1) {
            return (CPhysique)query.getSingleResult();
        }
        return null;
    }
}
