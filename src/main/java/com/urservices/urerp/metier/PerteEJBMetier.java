/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IPerteEJBDaoLocal;
import com.urservices.urerp.entities.Perte;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class PerteEJBMetier implements IPerteEJBMetierLocal, IPerteEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IPerteEJBDaoLocal
    @EJB
    private IPerteEJBDaoLocal iPerteEJBDaoLocal;

    @Override
    public Perte create(Perte perte) {
        return iPerteEJBDaoLocal.create(perte);
    }

    @Override
    public Perte update(Perte perte) {
        return iPerteEJBDaoLocal.update(perte);
    }

    @Override
    public int delete(Perte perte) {
        return iPerteEJBDaoLocal.delete(perte);
    }

    @Override
    public Perte findById(Long id) {
        return iPerteEJBDaoLocal.findById(id);
    }

    @Override
    public List<Perte> findAll() {
        return iPerteEJBDaoLocal.findAll();
    }

}
