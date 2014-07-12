/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IEmployeEJBDaoLocal;
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
public class EmployeEJBMetier implements IEmployeEJBMetierLocal, IEmployeEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IEmployeEJBDaoLocal
    @EJB
    private IEmployeEJBDaoLocal iEmployeEJBDaoLocal;
    
    //Injection d'une référence vers l'EJB IPeriodeEJBDaoLocal
    @EJB
    private IPeriodeEJBDaoLocal iPeriodeEJBDaoLocal;
    
    //Injection d'une référence vers l'EJB IFonctionEJBDaoLocal
    @EJB
    private IFonctionEJBDaoLocal iFonctionEJBDaoLocal;

    @Override
    public Employe create(Employe employe) {
        return iEmployeEJBDaoLocal.create(employe);
    }
    
    @Override
    public void create(Employe employe, Periode periode) {
       periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
       iEmployeEJBDaoLocal.create(employe);
       periode.setEmploye(employe);
       iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public Employe update(Employe employe) {
        return iEmployeEJBDaoLocal.update(employe);
    }
    
    @Override
    public Employe update(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        Employe updateEmploye = iEmployeEJBDaoLocal.update(employe);
        periode.setEmploye(updateEmploye);
        iPeriodeEJBDaoLocal.update(periode);
        
        return updateEmploye;
    }

    @Override
    public int delete(Employe employe) {
        return iEmployeEJBDaoLocal.delete(employe);
    }

    @Override
    public List<Employe> findAll() {
        return iEmployeEJBDaoLocal.findAll();
    }

    @Override
    public Employe findById(Long id) {
        return iEmployeEJBDaoLocal.findById(id);
    }

    @Override
    public void changer(Employe employe, Periode periode) {
        periode.setFonction(iFonctionEJBDaoLocal.findById(periode.getFonction().getId()));
        periode.setEmploye(employe);
        iPeriodeEJBDaoLocal.create(periode);
    }

    @Override
    public Employe findByCni(String cni) {
        return iEmployeEJBDaoLocal.findByCni(cni);
    }

    @Override
    public Employe findById(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
