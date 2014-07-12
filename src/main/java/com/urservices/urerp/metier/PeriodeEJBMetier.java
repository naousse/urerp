/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IFonctionEJBDaoLocal;
import com.urservices.urerp.dao.IPeriodeEJBDaoLocal;
import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.entities.Periode;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class PeriodeEJBMetier implements IPeriodeEJBMetierLocal, IPeriodeEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IPeriodeEJBDaoLocal
    @EJB
    private IPeriodeEJBDaoLocal iPeriodeEJBDaoLocal;
   
    //Injection d'une référence vers l'EJB IPeriodeEJBDaoLocal
    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;

    @Override
    public Periode create(Periode periode) {
        return iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public Periode update(Periode periode) {
        return iPeriodeEJBDaoLocal.update(periode);
    }

    @Override
    public int delete(Periode periode) {
        return iPeriodeEJBDaoLocal.delete(periode);
    }

    @Override
    public Periode findById(Long id) {
        return iPeriodeEJBDaoLocal.findById(id);
    }

    @Override
    public List<Periode> findAll() {
        return iPeriodeEJBDaoLocal.findAll();
    }

    @Override
    public Periode findPeriodeActifEmploye(Employe employe) {
       return iPeriodeEJBDaoLocal.findPeriodeActifEmploye(employe);
    }

    @Override
    public void update(Employe employe, Periode periode) {
         periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        periode.setEmploye(employe);
        iPeriodeEJBDaoLocal.update(periode);
    }

    @Override
    public List<Periode> findPeriodesEmploye(Employe employe) {
        
        return iPeriodeEJBDaoLocal.findPeriodesEmploye(employe);
    }

}
