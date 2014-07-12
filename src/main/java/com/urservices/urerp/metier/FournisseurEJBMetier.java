/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IFournisseurEJBDaoLocal;
import com.urservices.urerp.entities.Fournisseur;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class FournisseurEJBMetier implements IFournisseurEJBMetierLocal, IFournisseurEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IFournisseurEJBDaoLocal
    @EJB
    private IFournisseurEJBDaoLocal iFournisseurEJBDaoLocal;

    @Override
    public Fournisseur create(Fournisseur fournisseur) {
        return iFournisseurEJBDaoLocal.create(fournisseur);
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        return iFournisseurEJBDaoLocal.update(fournisseur);
    }

    @Override
    public int delete(Fournisseur fournisseur) {
        return iFournisseurEJBDaoLocal.delete(fournisseur);
    }

    @Override
    public Fournisseur findById(Long id) {
        return iFournisseurEJBDaoLocal.findById(id);
    }

    @Override
    public List<Fournisseur> findAll() {
        return iFournisseurEJBDaoLocal.findAll();
    }

    @Override
    public Fournisseur findByCode(String code) {
        return iFournisseurEJBDaoLocal.findByCode(code);
    }
}
