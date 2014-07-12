/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.CEntreprise;
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
public class CEntrepriseEJBDao implements ICEntrepriseEJBDaoLocal, ICEntrepriseEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état CEntrepriseEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public CEntreprise create(CEntreprise cEntreprise) {
        System.out.println("Dans EJBDAO");
        System.out.println(cEntreprise.getNom());
        System.out.println(cEntreprise.getAdresse().getEmail());
        System.out.println(cEntreprise.getAdresse().getTelephone());
        System.out.println(cEntreprise.getAdresse().getBoitePostal());
        em.persist(cEntreprise);
        return cEntreprise;
    }

    @Override
    public CEntreprise update(CEntreprise cEntreprise) {
        CEntreprise updateCEntreprise;
        updateCEntreprise = em.merge(cEntreprise);
        return updateCEntreprise;
    }

    @Override
    public int delete(CEntreprise cEntreprise) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM CEntreprise ce WHERE ce.id = :id");
        query.setParameter("id", cEntreprise.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public CEntreprise findById(Long id) {
        Query query = em.createNamedQuery("CEntreprise.findById").setParameter("id", id);
        return (CEntreprise)query.getSingleResult();
    }

    @Override
    public List<CEntreprise> findAll() {
        Query query = em.createNamedQuery("CEntreprise.findAll");
        return (List<CEntreprise>)query.getResultList();
    }

    @Override
    public CEntreprise findByName(String nom) {
        Query query = em.createNamedQuery("CEntreprise.findByName").setParameter("nom", nom);
        int totalResultat = ((List<CEntreprise>)query.getResultList()).size();
        if (totalResultat == 1) {
            return (CEntreprise)query.getSingleResult();
        }
        return null;
    }

}
