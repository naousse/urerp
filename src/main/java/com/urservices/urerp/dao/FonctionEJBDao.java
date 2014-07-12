/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Fonction;
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
public class FonctionEJBDao implements IFonctionEJBDaoLocal, IFonctionEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état FonctionEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    private EntityManager em;

    @Override
    public Fonction create(Fonction fonction) {
        em.persist(fonction);
        return fonction;
    }

    @Override
    public Fonction update(Fonction fonction) {
        Fonction updateFonction;
        updateFonction = em.merge(fonction);
        return updateFonction;
    }

    @Override
    public int delete(Fonction fonction) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Fonction f WHERE f.id = :id");
        query.setParameter("id", fonction.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Fonction findById(Long id) {
        Query query = em.createNamedQuery(Fonction.FINDByID).setParameter("id", id);
        return (Fonction)query.getSingleResult();
    }

    @Override
    public List<Fonction> findAll() {
        Query query = em.createNamedQuery("Fonction.findAll");
        return (List<Fonction>)query.getResultList();
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        Query query = em.createNamedQuery("Fonction.findByLibelle").setParameter("libelle", libelle);
        int nombreDeResultat = ((List<Fonction>)query.getResultList()).size();
        if (nombreDeResultat == 1) {
            return (Fonction)query.getSingleResult();
        }else{
            return null;
        }
    }

}
