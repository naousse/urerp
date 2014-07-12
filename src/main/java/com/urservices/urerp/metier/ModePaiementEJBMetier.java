/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IModePaiementEJBDaoLocal;
import com.urservices.urerp.entities.ModePaiement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class ModePaiementEJBMetier implements IModePaiementEJBMetierLocal, IModePaiementEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IModePaiementEJBDaoLocal
    @EJB
    private IModePaiementEJBDaoLocal iModePaiementEJBDaoLocal;

    @Override
    public ModePaiement create(ModePaiement modePaiement) {
        return iModePaiementEJBDaoLocal.create(modePaiement);
    }

    @Override
    public ModePaiement update(ModePaiement modePaiement) {
        return iModePaiementEJBDaoLocal.update(modePaiement);
    }

    @Override
    public int delete(ModePaiement modePaiement) {
        return iModePaiementEJBDaoLocal.delete(modePaiement);
    }

    @Override
    public ModePaiement findById(Long id) {
        return iModePaiementEJBDaoLocal.findById(id);
    }

    @Override
    public List<ModePaiement> findAll() {
        return iModePaiementEJBDaoLocal.findAll();
    }

}
