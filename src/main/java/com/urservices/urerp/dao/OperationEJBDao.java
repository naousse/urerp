/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Operation;
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
public class OperationEJBDao implements IOperationEJBDaoLocal, IOperationEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état OperationEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Operation create(Operation operation) {
        em.persist(operation);
        return operation;
    }

    @Override
    public Operation update(Operation operation) {
        Operation updateOperation;
        updateOperation = em.merge(operation);
        return updateOperation;
    }

    @Override
    public int delete(Operation operation) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Operation o WHERE o.id = :id");
        query.setParameter("id", operation.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Operation findById(Long id) {
        Query query = em.createNamedQuery("Operation.findById").setParameter("id", id);
        return (Operation)query.getSingleResult();
    }

    @Override
    public List<Operation> findAll() {
        Query query = em.createNamedQuery("Operation.findAll");
        return (List<Operation>)query.getResultList();
    }

}
