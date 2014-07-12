/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Partenaire;
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
public class PartenaireEJBDao implements IPartenaireEJBDaoLocal, IPartenaireEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état PartenaireEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Partenaire create(Partenaire partenaire) {
        em.persist(partenaire);
        return partenaire;
    }

    @Override
    public Partenaire update(Partenaire partenaire) {
        Partenaire updatePartenaire;
        updatePartenaire = em.merge(partenaire);
        return updatePartenaire;
    }

    @Override
    public int delete(Partenaire partenaire) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Partenaire p WHERE p.id = :id");
        query.setParameter("id", partenaire.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Partenaire findById(Long id) {
        Query query = em.createNamedQuery("Partenaire.findById").setParameter("id", id);
        return (Partenaire)query.getSingleResult();
    }

    @Override
    public List<Partenaire> findAll() {
        Query query = em.createNamedQuery("Partenaire.findAll");
        return (List<Partenaire>)query.getResultList();
    }

}
