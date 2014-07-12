/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.ModePaiement;
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
public class ModePaiementEJBDao implements IModePaiementEJBDaoLocal, IModePaiementEJBDaoRemote, Serializable{
    
    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état ModePaiementEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public ModePaiement create(ModePaiement modePaiement) {
        em.persist(modePaiement);
        return modePaiement;
    }

    @Override
    public ModePaiement update(ModePaiement modePaiement) {
        ModePaiement updateModePaiement;
        updateModePaiement = em.merge(modePaiement);
        return modePaiement;
    }

    @Override
    public int delete(ModePaiement modePaiement) {
        int nombrsDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM ModePaiement mp WHERE mp.id = :id");
        query.setParameter("id", modePaiement.getId());
        nombrsDeLignesAffectées = query.executeUpdate();
        return nombrsDeLignesAffectées;
    }

    @Override
    public ModePaiement findById(Long id) {
        Query query = em.createNamedQuery("ModePaiement.findById").setParameter("id", id);
        return (ModePaiement)query.getSingleResult();
    }

    @Override
    public List<ModePaiement> findAll() {
        Query query = em.createNamedQuery("ModePaiement.findAll");
        return (List<ModePaiement>)query.getResultList();
    }

}
