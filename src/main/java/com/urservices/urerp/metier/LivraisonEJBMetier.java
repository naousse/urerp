/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ILigneOperationEJBDaoLocal;
import com.urservices.urerp.dao.ILivraisonEJBDaoLocal;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class LivraisonEJBMetier implements ILivraisonEJBMetierLocal, ILivraisonEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB ILivraisonEJBDaoLocal
    @EJB
    private ILivraisonEJBDaoLocal iLivraisonEJBDaoLocal;
    @EJB
    private ILigneOperationEJBDaoLocal iLigneOperationEJBDaoLocal;

    @Override
    public Livraison create(Livraison livraison) {
        return iLivraisonEJBDaoLocal.create(livraison);
    }

    @Override
    public Livraison update(Livraison livraison) {
        return iLivraisonEJBDaoLocal.update(livraison);
    }

    @Override
    public int delete(Livraison livraison) {
        return iLivraisonEJBDaoLocal.delete(livraison);
    }

    @Override
    public Livraison findById(Long id) {
        return iLivraisonEJBDaoLocal.findById(id);
    }

    @Override
    public List<Livraison> findAll() {
        return iLivraisonEJBDaoLocal.findAll();
    }

    @Override
    public Livraison create(Livraison livraison, List<LigneOperation> ligneOperations) {
       
        iLivraisonEJBDaoLocal.create(livraison);
        for (LigneOperation ligneOperation : ligneOperations) {
            ligneOperation.setId(null);
            ligneOperation.setOperation(livraison);
            iLigneOperationEJBDaoLocal.create(ligneOperation);
            
        }
        return livraison;
    }

}
