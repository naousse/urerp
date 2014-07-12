/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ICEntrepriseEJBDaoLocal;
import com.urservices.urerp.entities.CEntreprise;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class CEntrepriseEJBMetier implements ICEntrepriseEJBMetierLocal, ICEntrepriseEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB ICEntrepriseEJBDaoLocal
    @EJB
    private ICEntrepriseEJBDaoLocal iCEntrepriseEJBDaoLocal;

    @Override
    public CEntreprise create(CEntreprise cEntreprise) {
        System.out.println("Dans EJBMetier");
        return iCEntrepriseEJBDaoLocal.create(cEntreprise);
    }

    @Override
    public CEntreprise update(CEntreprise cEntreprise) {
        return iCEntrepriseEJBDaoLocal.update(cEntreprise);
    }

    @Override
    public int delete(CEntreprise cEntreprise) {
        return iCEntrepriseEJBDaoLocal.delete(cEntreprise);
    }

    @Override
    public CEntreprise findById(Long id) {
        return iCEntrepriseEJBDaoLocal.findById(id);
    }

    @Override
    public List<CEntreprise> findAll() {
        return iCEntrepriseEJBDaoLocal.findAll();
    }

    @Override
    public CEntreprise findByName(String nom) {
        return iCEntrepriseEJBDaoLocal.findByName(nom);
    }

}
