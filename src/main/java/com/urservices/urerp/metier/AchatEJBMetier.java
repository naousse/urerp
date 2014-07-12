/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IAchatEJBDaoLocal;
import com.urservices.urerp.dao.IFournisseurEJBDaoLocal;
import com.urservices.urerp.dao.ILigneOperationEJBDaoLocal;
import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Fournisseur;
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
public class AchatEJBMetier implements IAchatEJBMetierLocal, IAchatEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IAchatEJBDaoLocal
    @EJB
    private IAchatEJBDaoLocal iAchatEJBDaoLocal;
    
    @EJB
    private IFournisseurEJBDaoLocal iFournisseurEJBDaoLocal;
    
    @EJB
    private ILigneOperationEJBDaoLocal iLigneOperationEJBDaoLocal;

    @Override
    public Achat create(Achat achat) {
        return iAchatEJBDaoLocal.create(achat);
    }

    @Override
    public Achat update(Achat achat) {
        return iAchatEJBDaoLocal.update(achat);
    }

    @Override
    public int delete(Achat achat) {
        return iAchatEJBDaoLocal.delete(achat);
    }

    @Override
    public Achat findById(Long id) {
        return iAchatEJBDaoLocal.findById(id);
    }

    @Override
    public List<Achat> findAll() {
        return iAchatEJBDaoLocal.findAll();
    }

    @Override
    public Achat findByNumero(String numero) {
        return iAchatEJBDaoLocal.findByNumero(numero);
    }

    @Override
    public Achat create(Achat achat, Fournisseur fournisseur, List<LigneOperation> ligneOperations) {
       
        Fournisseur fournisseurTempo = iFournisseurEJBDaoLocal.findByCode(fournisseur.getCode());
        
        if (fournisseurTempo == null) {
           fournisseurTempo = iFournisseurEJBDaoLocal.create(fournisseur);
        }
       achat.setPartenaire(fournisseurTempo);
       iAchatEJBDaoLocal.create(achat);
        for (LigneOperation ligneOperation : ligneOperations) {
            ligneOperation.setId(null);
            ligneOperation.setOperation(achat);
            iLigneOperationEJBDaoLocal.create(ligneOperation);
            
        }
        return achat;
    }
}
