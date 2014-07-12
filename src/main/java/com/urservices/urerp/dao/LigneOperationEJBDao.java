/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.LigneOperation;
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
public class LigneOperationEJBDao implements ILigneOperationEJBDaoLocal, ILigneOperationEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état LigneOperationEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public LigneOperation create(LigneOperation ligneOperation) {
        em.persist(ligneOperation);
        return ligneOperation;
    }

    @Override
    public LigneOperation update(LigneOperation ligneOperation) {
        LigneOperation updateLigneOperation;
        updateLigneOperation = em.merge(ligneOperation);
        return updateLigneOperation;
    }

    @Override
    public int delete(LigneOperation ligneOperation) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM LigneOperation lo WHERE lo.id = :id");
        query.setParameter("id", ligneOperation.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public LigneOperation findById(Long id) {
        Query query = em.createNamedQuery("LigneOperation.findById").setParameter("id", id);
        return (LigneOperation)query.getSingleResult();
    }

    @Override
    public List<LigneOperation> findAll() {
        Query query = em.createNamedQuery("LigneOperation.findAll");
        return (List<LigneOperation>)query.getResultList();
    }

}
