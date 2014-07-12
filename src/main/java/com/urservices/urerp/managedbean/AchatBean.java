/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.Facture;
import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Paiement;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
import com.urservices.urerp.metier.IAjoutProduitEJBMetierLocal;
import com.urservices.urerp.metier.IFactureEJBMetierLocal;
import com.urservices.urerp.metier.IFournisseurEJBMetierLocal;
import com.urservices.urerp.metier.ILivraisonEJBMetierLocal;
import com.urservices.urerp.metier.IPaiementEJBMetierLocal;
import com.urservices.urerp.metier.IProduitEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
//Bean géré
@ManagedBean(name = "achatBean")
//Matérialise la durée de vie du bean (temps d'une requête pour @RequestScoped)
@ViewScoped
public class AchatBean implements Serializable{
    
    private Achat achat;
    private List<Achat> achats;
    private static Long achatId;
    private  int activTab = 0;
    private Produit produit;
    private LigneOperation ligneOperation;
    private static List<LigneOperation> ligneOperations = new ArrayList<LigneOperation>();
    private List<Produit> produits;
    private int quantite =0;
    private float prixU = 0f;
    private Fournisseur fournisseur;
    private List<Fournisseur> fournisseurs;
    private Facture facture;
    private List<Facture> factures;
    private Livraison livraison;
    private List<Livraison> livraisons;
    private Paiement paiement = new Paiement();
    private List<Paiement> paiements;
   
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    //Injection d'une référence vers l'EJB IAchatEJBMetierLocal
    @EJB
    private IAchatEJBMetierLocal iAchatEJBMetierLocal;
    
    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;
    
    @EJB
    private IFournisseurEJBMetierLocal iFournisseurEJBMetierLocal;

    @EJB
    private IAjoutProduitEJBMetierLocal iAjoutProduitEJBMetierLocal;
    
    @EJB
    private ILivraisonEJBMetierLocal iLivraisonEJBMetierLocal;
    
    @EJB
    private IFactureEJBMetierLocal iFactureEJBMetierLocal;
    
    @EJB
    private IPaiementEJBMetierLocal iPaiementEJBMetierLocal;
    /**
     * Creates a new instance of AchatBean
     */
    public AchatBean() {
        activTab = 0;
        achat = new Achat();
        achats = new ArrayList<Achat>();
        produit = new Produit();
        fournisseur = new Fournisseur();
        ligneOperation = new LigneOperation();
        facture = new Facture();
        factures = new ArrayList<Facture>();
        livraison = new Livraison();
        livraisons = new ArrayList<Livraison>();
        paiement = new Paiement();
        paiements = new ArrayList<Paiement>();
        
    }

    public Achat getAchat() {
        return achat;
    }

    public Long getAchatId() {
        return achatId;
    }

    public int getActivTab() {
        return activTab;
    }

    public List<Achat> getAchats() {
        return achats;
    }

    public Produit getProduit() {
        return produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public float getPrixU() {
        return prixU;
    }

    public Facture getFacture() {
        return facture;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public Paiement getPaiement() {
        if (paiement==null) {
            paiement = new Paiement();
        }
        return paiement;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }
    
    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public void setAchatId(Long achatId) {
        this.achatId = achatId;
        this.achat = iAchatEJBMetierLocal.findById(achatId);
    }

    public void setActivTab(int activTab) {
        System.out.println("ici");
        this.activTab = activTab;
    }

    public void setAchats(List<Achat> achats) {
        this.achats = achats;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
        System.out.println("Selection Produit "+this.produit);
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
    }

    public void setPrixU(float prixU) {
        this.prixU = prixU;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
    
    public LigneOperation getLigneOperation() {
        return ligneOperation;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        ligneOperations = ligneOperations;
    }

    public List<LigneOperation> getLigneOperations() {
        
        for (LigneOperation lo : ligneOperations) {
            System.out.println(lo.getId()+" "+lo.getQuantite() +" "+lo.getProduit());
        }
        
        return ligneOperations;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }
    
    
    
    /*Cette méthode permet de créer un achat
     * en invoquant l'EJB sans état correspondant*/
    public void findFournisseur(ActionEvent actionEvent) {
        System.out.println("Debut Recherche");
        System.out.println(this.fournisseur.getCode());
        this.fournisseur = iFournisseurEJBMetierLocal.findByCode(this.fournisseur.getCode());
       System.out.println(this.fournisseur.getId());
       System.out.println("Fin Recherche");
    }
    
    public void addProduct(ActionEvent actionEvent) {
        System.out.println("Add Product "+produit+" Quantité "+quantite);
        System.out.println(ligneOperations.size());
        ligneOperation = new LigneOperation();
        ligneOperation.setProduit(produit);
        ligneOperation.setQuantite(quantite);
        ligneOperation.setPrixU(prixU);
        ligneOperation.setId(Long.valueOf(ligneOperations.size()+1));
        ligneOperations.add(ligneOperation);
        System.out.println(ligneOperation.getId());
        System.out.println(ligneOperation.getProduit());
    }
    
    
     /*Cette méthode permet de créer un achat
     * en invoquant l'EJB sans état correspondant*/
    public void  addPaiement(ActionEvent actionEvent) {
        System.out.println("Add Paiement");
        System.out.println(paiement.getDateOperation());
        System.out.println(paiement.getMontant());
        System.out.println(paiement.getNumero());
        this.achat = new Achat();
        this.achat.setId(achatId);
        this.paiement.setOperation(this.achat);
        System.out.println(this.achat.getId());
        System.out.println(this.paiement.getOperation().getId());
        iPaiementEJBMetierLocal.create(paiement);
        System.out.println("Fin Paiement ");
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Le paiement a été effectué avec succès"));
    }
    
    
    /*Cette méthode permet de créer un achat
     * en invoquant l'EJB sans état correspondant*/
    public String doCreate() throws IOException {
        System.out.println(this.fournisseur.getId()+"docreate");
        iAchatEJBMetierLocal.create(achat, fournisseur,ligneOperations);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + achat.getId());
        ligneOperations = null;
        return "show";
    }
    
    /*Cette méthode permet de créer un achat
     * en invoquant l'EJB sans état correspondant*/
    public String doPaiement() throws IOException {
        System.out.println("doPaiement");
        System.out.println(paiement.getDateOperation());
        System.out.println(paiement.getMontant());
        System.out.println(paiement.getNumero());
        System.out.println("Fin doPaiement");
        context.getExternalContext().redirect("show.xhtml?q=" + achat.getId());
        ligneOperations = null;
        return "show";
    }
    
    //Cette méthode permet de naviguer vers new.xhtml
    public String doNew() {
        ligneOperations = new ArrayList<LigneOperation>();
        return "/achat/new?faces-redirect=true";
        
    }
    
    public String doNewLivraison() throws IOException {
       // context.getExternalContext().redirect("new.xhtml?q=" +achat.getId());
        return "/livraison/new";
    }
    
    //Cette méthode permet de naviguer vers list.xhtml
    public String doList() {
        return "/achat/list?faces-redirect=true";
    }
    
    /*Cette méthode permet de modifier un achat
        en invoquant l'EJB sans état correspondant*/
    public String doUpdate() throws IOException {
        iAchatEJBMetierLocal.update(achat);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + achat.getId());
        return "show";
    }
    
    //Cette méthode permet de naviguer vers edit.xhtml
    public String doEdit() {
        return "edit";
    }
    
    //Cette méthode permet de naviguer vers edit.xhtml
    public String doDelete() {
        iAchatEJBMetierLocal.delete(achat);
        return "list";
    }
    
    //Cette méthode permet de naviguer vers show.xhtml
    public String doShow() {
        return "show";
    }
    
    /*Cette méthode permet de rechercher la liste des achats
     *en invoquant l'EJB sans état correspondant*/
    public void doFind() {
        achat = iAchatEJBMetierLocal.findById(achatId);
    }
    
    public List<Produit> getAllProduits() {
        return iProduitEJBMetierLocal.findAll();
    }
    
    public List<Paiement> getAllPaiementsAchat() {
        System.out.println("Debut recherche");
        return iPaiementEJBMetierLocal.findAllPaiementsAchat(achatId);
    }
    
    public String getEditUrl() {
        return "/produit/edit";
    }
    
    public String getShowUrl() {
        return "/produit/show";
    }
    
    public List<Fournisseur> getAllFournisseurs() {
        return iFournisseurEJBMetierLocal.findAll();
    }
    
    public List<Produit> getAllAjoutProduits() {
        return iAjoutProduitEJBMetierLocal.findAll();
    }
}
