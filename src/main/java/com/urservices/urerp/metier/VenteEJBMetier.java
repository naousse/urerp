/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IVenteEJBDaoLocal;
import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Vente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class VenteEJBMetier implements IVenteEJBMetierLocal, IVenteEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IVenteEJBDaoLocal
    @EJB
    private IVenteEJBDaoLocal iVenteEJBDaoLocal;

    @Override
    public Vente create(Vente vente) {
        return iVenteEJBDaoLocal.create(vente);
    }

    @Override
    public Vente update(Vente vente) {
        return iVenteEJBDaoLocal.update(vente);
    }

    @Override
    public int delete(Vente vente) {
        return iVenteEJBDaoLocal.delete(vente);
    }

    @Override
    public Vente findById(Long id) {
        return iVenteEJBDaoLocal.findById(id);
    }

    @Override
    public List<Vente> findAll() {
        return iVenteEJBDaoLocal.findAll();
    }

    @Override
    public Vente createCP(Vente vente, CPhysique physique, List<LigneOperation> ligneOperations) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vente createCE(Vente vente, CEntreprise entreprise, List<LigneOperation> ligneOperations) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
