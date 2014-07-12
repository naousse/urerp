/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Fournisseur;
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
public class FournisseurEJBDao implements IFournisseurEJBDaoLocal, IFournisseurEJBDaoRemote, Serializable{

    /* Injection d'une référence à un gestionnaire d'entités 
        dans l'EJB sans état FournisseurEJBDao */
    @PersistenceContext(unitName = "urerpPU")
    protected EntityManager em;

    @Override
    public Fournisseur create(Fournisseur fournisseur) {
        em.persist(fournisseur);
        return fournisseur;
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        Fournisseur updateFournisseur;
        updateFournisseur = em.merge(fournisseur);
        return updateFournisseur;
    }

    @Override
    public int delete(Fournisseur fournisseur) {
        int nombreDeLignesAffectées = 0;
        Query query = em.createQuery("DELETE FROM Fournisseur f WHERE f.id = :id");
        query.setParameter("id", fournisseur.getId());
        nombreDeLignesAffectées = query.executeUpdate();
        return nombreDeLignesAffectées;
    }

    @Override
    public Fournisseur findById(Long id) {
        Query query = em.createNamedQuery("Fournisseur.findById").setParameter("id", id);
        return (Fournisseur)query.getSingleResult();
    }

    @Override
    public List<Fournisseur> findAll() {
        Query query = em.createNamedQuery("Fournisseur.findAll");
        return (List<Fournisseur>)query.getResultList();
    }

    @Override
    public Fournisseur findByCode(String code) {
        Query query = em.createNamedQuery("Fournisseur.findByCode").setParameter("code", code);
        int nombreDeResultat = ((List<Fournisseur>)query.getResultList()).size();
        if (nombreDeResultat == 1) {
            return (Fournisseur)query.getSingleResult();
        }
        return null;
    }

    @Override
    public Fournisseur findFournisseurAchat(Achat achat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
