/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ILigneOperationEJBDaoLocal;
import com.urservices.urerp.entities.LigneOperation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class LigneOperationEJBMetier implements ILigneOperationEJBMetierLocal, ILigneOperationEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB ILigneOperationEJBDaoLocal
    @EJB
    private ILigneOperationEJBDaoLocal iLigneOperationEJBDaoLocal;

    @Override
    public LigneOperation create(LigneOperation ligneOperation) {
        return iLigneOperationEJBDaoLocal.create(ligneOperation);
    }

    @Override
    public LigneOperation update(LigneOperation ligneOperation) {
        return iLigneOperationEJBDaoLocal.update(ligneOperation);
    }

    @Override
    public int delete(LigneOperation ligneOperation) {
        return iLigneOperationEJBDaoLocal.delete(ligneOperation);
    }

    @Override
    public LigneOperation findById(Long id) {
        return iLigneOperationEJBDaoLocal.findById(id);
    }

    @Override
    public List<LigneOperation> findAll() {
        return iLigneOperationEJBDaoLocal.findAll();
    }

}
