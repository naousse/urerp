/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ILigneOperationEJBDaoLocal;
import com.urservices.urerp.dao.ILivraisonEJBDaoLocal;
import com.urservices.urerp.dao.IProduitEJBDaoLocal;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Operation;
import com.urservices.urerp.entities.Produit;
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
    
    @EJB
    private IProduitEJBDaoLocal iProduitEJBDaoLocal;

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
        Produit produit = null;
        iLivraisonEJBDaoLocal.create(livraison);
        for (LigneOperation ligneOperation : ligneOperations) {
            ligneOperation.setId(null);
            //Modification de la quantité en stock du produit
            produit = ligneOperation.getProduit();
            produit.setQuantiteEnStock(produit.getQuantiteEnStock()-ligneOperation.getQuantite());
            iProduitEJBDaoLocal.update(produit);
            //La modification do normalement affecté les stocks de produits aussi
            //La modification doit également affecté la ligne opération de la livraison afin de
            //suivre l'évolution des livraison
            ligneOperation.setOperation(livraison);
            
            iLigneOperationEJBDaoLocal.create(ligneOperation);
            
        }
        return livraison;
    }

    @Override
    public List<Livraison> findAllLivraisonsOperation(Operation operation) {
        return iLivraisonEJBDaoLocal.findAllLivraisonsOperation(operation);
    }

    @Override
    public Livraison update(Livraison livraison, List<LigneOperation> ligneOperations, List<LigneOperation> ligneOperationsoDelete) {
         iLivraisonEJBDaoLocal.update(livraison);
         Produit produit = null;
        for (LigneOperation ligneOperation : ligneOperations){
            produit =  iProduitEJBDaoLocal.findById(ligneOperation.getProduit().getId());
            if (ligneOperation.getEtat().equals("new")){
                System.out.println("Opération add");
            ligneOperation.setId(null);
            ligneOperation.setOperation(livraison);
            ligneOperation.setEtat("old");
            produit.setQuantiteEnStock(produit.getQuantiteEnStock()- ligneOperation.getQuantite());
            iLigneOperationEJBDaoLocal.create(ligneOperation);
            }else{
                System.out.println("Opération update");
            produit.setQuantiteEnStock(produit.getQuantiteEnStock() +(iLigneOperationEJBDaoLocal.findById(ligneOperation.getId()).getQuantite())- ligneOperation.getQuantite());
            
              iLigneOperationEJBDaoLocal.update(ligneOperation);  
            }
           
        }
        
        for (LigneOperation ligneOperation : ligneOperationsoDelete) {
            System.out.println("Opération delete");
            produit = iProduitEJBDaoLocal.findById(ligneOperation.getProduit().getId());
            produit.setQuantiteEnStock(produit.getQuantiteEnStock()+ ligneOperation.getQuantite());
             System.out.println(iLigneOperationEJBDaoLocal.delete(ligneOperation));
        }
        
            
        iProduitEJBDaoLocal.update(produit);
        return livraison;
    }

}
