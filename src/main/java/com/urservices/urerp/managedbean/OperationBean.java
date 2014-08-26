/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Paiement;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.entities.Vente;
import com.urservices.urerp.metier.ICEntrepriseEJBMetierLocal;
import com.urservices.urerp.metier.ICPhysiqueEJBMetierLocal;
import com.urservices.urerp.metier.ILigneOperationEJBMetierLocal;
import com.urservices.urerp.metier.ILivraisonEJBMetierLocal;
import com.urservices.urerp.metier.IPaiementEJBMetierLocal;
import com.urservices.urerp.metier.IProduitEJBMetierLocal;
import com.urservices.urerp.metier.IVenteEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author samuel
 */
@ManagedBean(name = "operationBean")
@ViewScoped
public class OperationBean implements Serializable {

    private Vente vente;
    private List<Vente> ventes;
    private static Long venteId;
    private Produit produit;
    private Paiement paiement;
    private List<Produit> produits;
    private Livraison livraison;
    private CPhysique clientPhysique;
    private List<CPhysique> clientPhysiques;
    private CEntreprise clientEntreprise;
    private List<CEntreprise> clientEntreprises;
    private LigneOperation ligneOperation;
    private boolean buttonDisabled = true;
    private static List<LigneOperation> ligneOperations = new ArrayList<LigneOperation>();
    private List<Paiement> paiements = new ArrayList<Paiement>();
    private static List<LigneOperation> ligneOperationsLivraison = new ArrayList<LigneOperation>();
    private static List<LigneOperation> ligneOperationsToDelete = new ArrayList<LigneOperation>();

    //Information pour l'ajout d'un produit
    private int quantite = 0;
    private float prixUnitaire = 0f;
    //Fin Information pour l'ajout d'un produit


    @EJB
    private IVenteEJBMetierLocal iVenteEJBMetierLocal;
    @EJB
    private ILigneOperationEJBMetierLocal iLigneOperationEJBMetierLocal;
    @EJB
    private ILivraisonEJBMetierLocal iLivraisonEJBMetierLocal;
    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;
    @EJB
    private ICEntrepriseEJBMetierLocal iCEntrepriseEJBMetierLocal;
    @EJB
    private ICPhysiqueEJBMetierLocal iCPhysiqueEJBMetierLocal;
    @EJB
    private IPaiementEJBMetierLocal iPaiementEJBMetierLocal;

    /**
     * Creates a new instance of VenteBean
     */
    public OperationBean() {
        vente = new Vente();
        ventes = new ArrayList<Vente>();
        produit = new Produit();
        clientEntreprise = new CEntreprise();
        clientPhysique = new CPhysique();
        ligneOperation = new LigneOperation();
        ligneOperations = new ArrayList<LigneOperation>();
    }

    public Long getVenteId() {
        return venteId;
    }

    public Vente getVente() {
        return vente;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public CEntreprise getClientEntreprise() {
        return clientEntreprise;
    }

    public List<CEntreprise> getClientEntreprises() {
        return clientEntreprises;
    }

    public CPhysique getClientPhysique() {
        return clientPhysique;
    }

    public List<CPhysique> getClientPhysiques() {
        return clientPhysiques;
    }

    public Produit getProduit() {
        return produit;
    }

    public Paiement getPaiement() {
        return paiement;
    }
    
    public List<Produit> getProduits() {
        return produits;
    }

    public LigneOperation getLigneOperation() {
        return this.ligneOperation;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }

    public List<Livraison> getLivraisons() {
        return  iLivraisonEJBMetierLocal.findAllLivraisonsOperation(this.vente);
       
    }

    public List<LigneOperation> getLigneOperationsLivraison() {
        return iLigneOperationEJBMetierLocal.findAllLigneOperationsForOneOperation(this.livraison);
    }
    
    public Livraison getLivraison() {
        return this.livraison;
    }

    public List<Paiement> getPaiements() {
        if(paiements==null || paiements.isEmpty()){
            this.paiements.add(new Paiement(1l,0f));
            this.paiements.add(new Paiement(2l,0f));
            this.paiements.add(new Paiement(3l,0f));
        }
        System.out.println("paiement = 0"+paiements.size());
        return paiements;
    }

    public  void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
    
    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public void setButtonDisabled(boolean buttonDisabled) {
        this.buttonDisabled = buttonDisabled;
    }

    public void setVenteId(Long venteId) {
        OperationBean.venteId = venteId;
        vente = iVenteEJBMetierLocal.findById(venteId);
        this.setClientPhysique((CPhysique) vente.getPartenaire());
        this.setLigneOperations(iLigneOperationEJBMetierLocal.findAllLigneOperationsForOneOperation(vente));
        this.setPaiements(iPaiementEJBMetierLocal.findAllPaiementsOperation(vente));
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public void setClientEntreprise(CEntreprise clientEntreprise) {
        this.clientEntreprise = clientEntreprise;
    }

    public void setClientEntreprises(List<CEntreprise> clientEntreprises) {
        this.clientEntreprises = clientEntreprises;
    }

    public void setClientPhysique(CPhysique clientPhysique) {
        this.clientPhysique = clientPhysique;
    }

    public void setClientPhysiques(List<CPhysique> clientPhysiques) {
        this.clientPhysiques = clientPhysiques;
    }

    public void setProduit(Produit produit) {
        System.out.println("Selection du Produit");
        this.produit = produit;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
        this.buttonDisabled = false;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setLigneOperations(List<LigneOperation> liOperations) {
        ligneOperations = liOperations;
    }

    public List<LigneOperation> getLigneOperations() {

        for (LigneOperation lo : ligneOperations) {
            System.out.println("Id = " + lo.getId() + " " + "Qté = " + lo.getQuantite() + " " + "Produit = " + lo.getProduit());
        }
        return ligneOperations;
    }

    public void addProduct(ActionEvent actionEvent) {
        System.out.println("Debut ajout produit");

        ligneOperation = new LigneOperation();
        ligneOperation.setProduit(produit);
        ligneOperation.setQuantite(quantite);
        ligneOperation.setPrixU(prixUnitaire);
        ligneOperation.setId(Long.valueOf(ligneOperations.size() + 1));
        ligneOperation.setEtat("new");
        ligneOperations.add(ligneOperation);
        produits.remove(produit);
        this.produit = new Produit();
        quantite = 0;
        prixUnitaire = 0;
        this.buttonDisabled = true;
        FacesContext newContext = FacesContext.getCurrentInstance();
        newContext.addMessage(null, new FacesMessage("Successful", "Your message: " + ligneOperation.getProduit().getDesignation() + "Ajouté avec succès!"));

        System.out.println("Fin Ajout Produit");
    }

    public String doCreate() throws IOException {
        System.out.println(this.clientPhysique.getId() + "docreate");
        iVenteEJBMetierLocal.createCP(vente, clientPhysique, ligneOperations);
        FacesContext newContext = FacesContext.getCurrentInstance();
        newContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        newContext.getExternalContext().redirect("show.xhtml?q=" + vente.getId());
        ligneOperations = null;
        return "show";
    }

    public String doNew() {
        ligneOperations = new ArrayList<LigneOperation>();
        return "/vente/new?faces-redirect=true";
    }
    
    public void onPaiementRowEdit(ActionEvent actionEvent) {
       
    }

    public void onPaiementRowCancel(ActionEvent actionEvent) {
       
    }


    public String doList() {
        return "/vente/list?faces-redirect=true";
    }

    public String doUpdate() throws IOException {
        System.out.println(this.clientPhysique.getId() + "doupdate");
        iVenteEJBMetierLocal.update(vente, ligneOperations, ligneOperationsToDelete);
        FacesContext newContext = FacesContext.getCurrentInstance();
        newContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        newContext.getExternalContext().redirect("edit.xhtml?q=" + vente.getId());
        ligneOperations = null;
        return "edit";
    }

    public String doEdit() {
        return "show";
    }

    public String doShow() {
        return "show";
    }

    public void doFind() {
        vente = iVenteEJBMetierLocal.findById(venteId);
    }

    public List<Produit> getAllProduits() {
        if (this.produits == null) {
            produits = iProduitEJBMetierLocal.findAll();

            //Si nous sommes en Edition de la vente, ne pas tenir compte des produits
            //Déja commandé lorsqu'on construit la liste des produits
            if (ligneOperations != null) {
              this.produits =  construireListeProduit(produits, ligneOperations);
            }
        }
        return produits;
    }

    public void findClientPhysique(ActionEvent actionEvent) {
        System.out.println("Debut Recherche");
        System.out.println("CNI: " + this.clientPhysique.getCni());
        this.clientPhysique = iCPhysiqueEJBMetierLocal.findClientPhysiqueByCni(this.clientPhysique.getCni());
        System.out.println(this.clientPhysique.getId());
        System.out.println("Fin Recherche");
    }

    public void findClientEntreprise(ActionEvent actionEvent) {
        this.clientEntreprise = iCEntrepriseEJBMetierLocal.findByName(this.clientEntreprise.getNom());
    }

    public void editLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut Modification");
        OperationBean.ligneOperations.remove(this.ligneOperation);
        ligneOperations.add(ligneOperation);
        this.buttonDisabled = true;
        System.out.println("Fin Modification");
    }

    public void removeLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut retrait");
        System.out.println(this.ligneOperation.getProduit().getDesignation());
        OperationBean.ligneOperations.remove(this.ligneOperation);
        produits.add(ligneOperation.getProduit());
        this.buttonDisabled = true;
        System.out.println("Fin retrait");
    }

    //Nécessaire pour la suppresssion d'une ligne lorsqu'on se trouve en edition de la ventes
    public void deleteLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut delete");
        System.out.println(this.ligneOperation.getProduit().getDesignation());
        if(this.ligneOperation.getEtat().equals("old")){
         OperationBean.ligneOperationsToDelete.add(this.ligneOperation);
        Produit deleteProduit = ligneOperation.getProduit();
        deleteProduit.setQuantiteEnStock(deleteProduit.getQuantiteEnStock() + ligneOperation.getQuantite());
        produits.add(deleteProduit);
        OperationBean.ligneOperations = construireListeLigneOperation(ligneOperations, this.ligneOperation);
        this.buttonDisabled = true;
        System.out.println("Fin delete");
        }else{
            removeLigneOperation(actionEvent);
        }
    }
    
        //Neccessaire lorsqu'on est en edition pour construire une liste de produit ne contenant
        //pas les produits déjà commandés
    public List<Produit> construireListeProduit(List<Produit> produits, List<LigneOperation> totalLigneOperations) {
        boolean trouve = false;
        System.out.println(totalLigneOperations.size() + " +  " +produits.size() );
        
        List<Produit> listeProduits = new ArrayList<Produit>();
        for (Produit produit1 : produits) {
            trouve = false;
            Iterator<LigneOperation> it = totalLigneOperations.iterator();
            while (it.hasNext() && !trouve) {
                System.out.println("Premiere Iteration");
                LigneOperation ligneOperation1 = it.next();
                if (ligneOperation1.getProduit().getDesignation().equals(produit1.getDesignation())) {
                    trouve = true;
                }
            }

            if (!trouve) {
                listeProduits.add(produit1);
            }
        }
        System.out.println("Ici "+listeProduits.size());
        return listeProduits;
    }
    
      //Neccessaire lorsqu'on est en edition pour construire une liste de ligne opération ne contenant
        //pas les ligne opérations que l'on supprime
    public List<LigneOperation> construireListeLigneOperation(List<LigneOperation> totalLigneOperations, LigneOperation ligneOperationEnCours) {
       
        List<LigneOperation> listeDesLigneOperations = new ArrayList<LigneOperation>();
        
        for (LigneOperation ligneOperation1 : totalLigneOperations) {
            if(!ligneOperation1.getId().equals(ligneOperationEnCours.getId())){
                listeDesLigneOperations.add(ligneOperation1);
            }
        }
        return listeDesLigneOperations;
    }

}
