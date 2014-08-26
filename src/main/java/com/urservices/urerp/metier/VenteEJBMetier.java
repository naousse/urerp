/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ICEntrepriseEJBDaoLocal;
import com.urservices.urerp.dao.ICPhysiqueEJBDaoLocal;
import com.urservices.urerp.dao.ILigneOperationEJBDaoLocal;
import com.urservices.urerp.dao.IProduitEJBDaoLocal;
import com.urservices.urerp.dao.IVenteEJBDaoLocal;
import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Produit;
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

    @EJB
    private ICPhysiqueEJBDaoLocal iCPhysiqueEJBDaoLocal;
    
    @EJB
    private ILigneOperationEJBDaoLocal iLigneOperationEJBDaoLocal;
    
    @EJB
    private IProduitEJBDaoLocal iProduitEJBDaoLocal;
    
    @EJB
    private ICEntrepriseEJBDaoLocal iCEntrepriseEJBDaoLocal;
    
    @Override
    public Vente create(Vente vente) {
        return iVenteEJBDaoLocal.create(vente);
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
        CPhysique cPhysiqueTempo = iCPhysiqueEJBDaoLocal.findClientPhysiqueByCni(physique.getCni());
        Produit produit = null;
        if (cPhysiqueTempo == null){
            cPhysiqueTempo = iCPhysiqueEJBDaoLocal.create(physique);
        }
        vente.setPartenaire(cPhysiqueTempo);
        iVenteEJBDaoLocal.create(vente);
        for (LigneOperation ligneOperation : ligneOperations){
            ligneOperation.setId(null);
            ligneOperation.setEtat("old");
            ligneOperation.setOperation(vente);
            iLigneOperationEJBDaoLocal.create(ligneOperation);
            produit =  iProduitEJBDaoLocal.findById(ligneOperation.getProduit().getId());
            produit.setQuantiteEnStock(produit.getQuantiteEnStock()- ligneOperation.getQuantite());
            iProduitEJBDaoLocal.update(produit);
        }
        return vente;
    }

    @Override
    public Vente createCE(Vente vente, CEntreprise entreprise, List<LigneOperation> ligneOperations) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vente update(Vente vente) {
       return iVenteEJBDaoLocal.update(vente);
    }

    @Override
    public Vente update(Vente vente, List<LigneOperation> ligneOperations, List<LigneOperation> ligneOperationsoDelete) {
         iVenteEJBDaoLocal.update(vente);
         Produit produit = null;
        for (LigneOperation ligneOperation : ligneOperations){
            produit =  iProduitEJBDaoLocal.findById(ligneOperation.getProduit().getId());
            if (ligneOperation.getEtat().equals("new")){
                System.out.println("Opération add");
            ligneOperation.setId(null);
            ligneOperation.setOperation(vente);
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
        return vente;
    }

}
