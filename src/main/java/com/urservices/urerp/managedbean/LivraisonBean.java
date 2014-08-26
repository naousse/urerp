/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.entities.Vente;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
import com.urservices.urerp.metier.ILigneOperationEJBMetierLocal;
import com.urservices.urerp.metier.ILivraisonEJBMetierLocal;
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
@ManagedBean(name = "livraisonBean")
@ViewScoped
public class LivraisonBean implements Serializable {

    private Livraison livraison;
    private Vente vente;
    private CPhysique clientPhysique;
    private Produit produit;
    private List<Produit> produits;
    private LigneOperation ligneOperation;
    private LigneOperation ligneLivraison;
    private static List<LigneOperation> ligneOperations = new ArrayList<LigneOperation>();
    private static List<LigneOperation> ligneOperationsToDelete = new ArrayList<LigneOperation>();
    private static List<LigneOperation> ligneOperationsVente = new ArrayList<LigneOperation>();
    private List<Livraison> livraisons;
    private Long livraisonId;
    private Long venteId;
    private int quantite = 0;
    private boolean buttonDisabled;

    @EJB
    private ILivraisonEJBMetierLocal iLivraisonEJBMetierLocal;

    @EJB
    private IVenteEJBMetierLocal iVenteEJBMetierLocal;

    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;

    @EJB
    private ILigneOperationEJBMetierLocal iLigneOperationEJBMetierLocal;

    /**
     * Creates a new instance of LivraisonBean
     */
    public LivraisonBean() {
        livraison = new Livraison();
        livraisons = new ArrayList<Livraison>();
        produit = new Produit();
        ligneOperation = new LigneOperation();
        ligneLivraison = new LigneOperation();
        ligneOperations = new ArrayList<LigneOperation>();
        buttonDisabled = true;
    }

    public Long getLivraisonId() {
        return livraisonId;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public List<Livraison> getLivraisons() {
        return livraisons;
    }

    public Long getVenteId() {
        return venteId;
    }

    public Vente getVente() {
        return vente;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
        this.buttonDisabled = false;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }

    public void setButtonDisabled(boolean buttonDisabled) {
        this.buttonDisabled = buttonDisabled;
    }

    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }

    public LigneOperation getLigneOperation() {
        return ligneOperation;
    }

    public LigneOperation getLigneLivraison() {
        return ligneLivraison;
    }

    public void setLigneLivraison(LigneOperation ligneLivraison) {
        this.ligneLivraison = ligneLivraison;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public List<Produit> getAllProduitsVente() {
        if (this.produits == null) {

            produits = iProduitEJBMetierLocal.findAll();

            //Si nous sommes en création de la livraison, tenir compte que des produits
            //Déja commandés lorsqu'on construit la liste des produits
            if (ligneOperationsVente != null) {
                this.produits = construireListeProduit(produits, ligneOperationsVente);
            }

            //Si nous sommes en Edition de la livraison, ne pas tenir compte des produits
            //Déja livré lorsqu'on construit la liste des produits
            if (ligneOperations != null) {
                this.produits = construireListeProduit(produits, ligneOperations);
            }

        }
        return produits;
    }

    public CPhysique getClientPhysique() {
        return clientPhysique;
    }

    public void setClientPhysique(CPhysique clientPhysique) {
        this.clientPhysique = clientPhysique;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public void setVenteId(Long venteId) {
        this.venteId = venteId;
        this.vente = iVenteEJBMetierLocal.findById(venteId);
        this.clientPhysique = (CPhysique) this.vente.getPartenaire();
        LivraisonBean.ligneOperationsVente = iLigneOperationEJBMetierLocal.findAllLigneOperationsForOneOperation(this.vente);
    }

    public void setLivraisonId(Long livraisonId) {
        this.livraisonId = livraisonId;
        this.livraison = iLivraisonEJBMetierLocal.findById(livraisonId);
        this.vente = iVenteEJBMetierLocal.findById(this.livraison.getOperation().getId());
        this.clientPhysique = (CPhysique) this.vente.getPartenaire();
        this.setLigneOperations(iLigneOperationEJBMetierLocal.findAllLigneOperationsForOneOperation(this.livraison));

    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }

    public void addProduct(ActionEvent actionEvent) {
        System.out.println("Debut ajout produit");
        ligneOperation = new LigneOperation();
        ligneOperation.setProduit(produit);
        ligneOperation.setQuantite(quantite);
        ligneOperation.setId(Long.valueOf(ligneOperations.size() + 1));
        ligneOperation.setEtat("new");
        ligneOperations.add(ligneOperation);
        produits.remove(produit);
        this.produit = new Produit();
        quantite = 0;
        this.buttonDisabled = true;
        FacesContext newContext = FacesContext.getCurrentInstance();
        newContext.addMessage(null, new FacesMessage("Successful", "Your message: " + ligneOperation.getProduit().getDesignation() + "Ajouté avec succès!"));

        System.out.println("Fin Ajout Produit");
    }

    public void removeLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut retrait");
        System.out.println(this.ligneOperation.getProduit().getDesignation());
        LivraisonBean.ligneOperations.remove(this.ligneOperation);
        produits.add(ligneOperation.getProduit());
        this.buttonDisabled = true;
        System.out.println("Fin retrait");
    }
    
     public void editLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut Modification");
        LivraisonBean.ligneOperations = construireListeLigneOperation(ligneOperations, ligneOperation);
        ligneOperations.add(ligneOperation);
        this.buttonDisabled = true;
        System.out.println("Fin Modification");
    }

    //Nécessaire pour la suppresssion d'une ligne lorsqu'on se trouve en edition de la ventes
    public void deleteLigneOperation(ActionEvent actionEvent) {
        System.out.println("Debut delete");
        System.out.println(this.ligneOperation.getProduit().getDesignation());
        if (this.ligneOperation.getEtat().equals("old")) {
            LivraisonBean.ligneOperationsToDelete.add(this.ligneOperation);
            Produit deleteProduit = ligneOperation.getProduit();
            deleteProduit.setQuantiteEnStock(deleteProduit.getQuantiteEnStock() + ligneOperation.getQuantite());
            produits.add(deleteProduit);
            LivraisonBean.ligneOperations = construireListeLigneOperation(ligneOperations, this.ligneOperation);
            this.buttonDisabled = true;
            System.out.println("Fin delete");
        } else {
            removeLigneOperation(actionEvent);
        }
    }

    public String doCreate() throws IOException {
        livraison.setOperation(vente);
        livraison = iLivraisonEJBMetierLocal.create(livraison, ligneOperations);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("/vente/show.xhtml?q=" + livraison.getOperation().getId());
        return "/vente/show?faces-redirect=true";
    }

    public String doNew() {
        return "/livraison/new?faces-redirect=true";
    }

    public String doList() {
        return "/livraison/list?faces-redirect=true";
    }

    public String getEditUrl() {
        return "/livraison/edit";
    }

    public String doUpdate() throws IOException {
       
       System.out.println(this.clientPhysique.getId() + "doupdate");
        iLivraisonEJBMetierLocal.update(livraison, ligneOperations, ligneOperationsToDelete);
        FacesContext newContext = FacesContext.getCurrentInstance();
        newContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        newContext.getExternalContext().redirect("edit.xhtml?livraison=" + livraison.getId());
        ligneOperations = null;
        return "edit";
    }

    public String doEdit() {
        return "edit.xhtml";
    }

    public String doShow() {
        return "show";
    }

    public String getBackUrl() {
        return "/achat/show";
    }

    public String doDelte() {
        iLivraisonEJBMetierLocal.delete(livraison);
        return "list";
    }

    public String doRetour() {
        return "/achat/show?faces-redirect=true";
    }

    public String getNewLivraisonUrl() {
        return "/livraison/new";
    }

    public void doFind() {
        livraison = iLivraisonEJBMetierLocal.findById(livraisonId);
    }

         //Neccessaire lorsqu'on est en edition pour construire une liste de produit ne contenant
    //pas les produits déjà commandés
    public List<Produit> construireListeProduit(List<Produit> produits, List<LigneOperation> totalLigneOperations) {
        boolean trouve = false;
        System.out.println(totalLigneOperations.size() + " +  " + produits.size());

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

            if (trouve) {
                listeProduits.add(produit1);
            }
        }
        System.out.println("Ici " + listeProduits.size());
        return listeProduits;
    }

      //Neccessaire lorsqu'on est en edition pour construire une liste de ligne opération ne contenant
    //pas les ligne opérations que l'on supprime
    public List<LigneOperation> construireListeLigneOperation(List<LigneOperation> totalLigneOperations, LigneOperation ligneOperationEnCours) {

        List<LigneOperation> listeDesLigneOperations = new ArrayList<LigneOperation>();

        for (LigneOperation ligneOperation1 : totalLigneOperations) {
            if (!ligneOperation1.getId().equals(ligneOperationEnCours.getId())) {
                listeDesLigneOperations.add(ligneOperation1);
            }
        }
        return listeDesLigneOperations;
    }
}
