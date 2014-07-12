/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Employe;
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
public class EmployeEJBDao implements IEmployeEJBDaoLocal, IEmployeEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état EmployeEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    private EntityManager em;
    
    @Override
    public Employe create(Employe employe) {
        em.persist(employe);
        return employe;
    }

    @Override
    public Employe update(Employe employe) {
        Employe updateEmploye;
        updateEmploye = em.merge(employe);
        return updateEmploye;
    }

    @Override
    public int delete(Employe employe) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Employe e WHERE e.id = :id");
        query.setParameter("id", employe.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Employe findById(Long id) {
        Query query = em.createNamedQuery("Employe.findById").setParameter("id", id);
        return (Employe)query.getSingleResult();
    }

    @Override
    public List<Employe> findAll() {
        Query query = em.createNamedQuery("Employe.findAll");
        return (List<Employe>)query.getResultList();
    }

    @Override
    public Employe findByCni(String cni) {
        Query query = em.createNamedQuery("Employe.findByCni").setParameter("cni", cni);        
        int nombreDeResultat = ((List<Employe>)query.getResultList()).size();
        if(nombreDeResultat ==1){
            return (Employe)query.getSingleResult();
        }else{
            return null;
        }
    }

    
}
