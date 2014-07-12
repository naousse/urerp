/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IFonctionEJBDaoLocal;
import com.urservices.urerp.entities.Fonction;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class FonctionEJBMetier implements IFonctionEJBMetierLocal, IFonctionEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IFonctionEJBDaoLocal
    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;
    
    @Override
    public Fonction create(Fonction fonction) {
        return iFonctionEJBDaoLocal.create(fonction);
    }

    @Override
    public Fonction update(Fonction fonction) {
        return iFonctionEJBDaoLocal.update(fonction);
    }

    @Override
    public int delete(Fonction fonction) {
        return iFonctionEJBDaoLocal.delete(fonction);
    }

    @Override
    public Fonction findById(Long id) {
        return iFonctionEJBDaoLocal.findById(id);
    }

    @Override
    public List<Fonction> findAll() {
        return iFonctionEJBDaoLocal.findAll();
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        return iFonctionEJBDaoLocal.findByLibelle(libelle);
    }

    

}
