/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Livraison;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
import com.urservices.urerp.metier.ILigneOperationEJBMetierLocal;
import com.urservices.urerp.metier.ILivraisonEJBMetierLocal;
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
@ManagedBean(name = "livraisonBean")
@ViewScoped
public class LivraisonBean implements Serializable{
    
    private Livraison livraison;
    private Achat achat;
    private Produit produit;
    private List<Produit> produits;
    private LigneOperation ligneOperation;
    private LigneOperation ligneLivraison;
    private static List<LigneOperation> ligneOperations = new ArrayList<LigneOperation>();
    private List<Livraison> livraisons;
    private Long livraisonId;
    private Long achatId;
    private int quantite = 0;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private ILivraisonEJBMetierLocal iLivraisonEJBMetierLocal;
    
    @EJB
    private IAchatEJBMetierLocal iAchatEJBMetierLocal;

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
        produits = new ArrayList<Produit>();
        ligneOperation = new LigneOperation();
        ligneLivraison = new LigneOperation();
        ligneOperations = new ArrayList<LigneOperation>();
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

    public Long getAchatId() {
        return achatId;
    }

    public Achat getAchat() {
        return achat;
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
        this.produit = ligneOperation.getProduit();
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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

    public Produit getProduit() {
        return produit;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public void setAchatId(Long achatId) {
        this.achatId = achatId;
        this.achat = iAchatEJBMetierLocal.findById(achatId);
    }

    public void setLivraisonId(Long livraisonId) {
        this.livraisonId = livraisonId;
        this.livraison = iLivraisonEJBMetierLocal.findById(livraisonId);
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public void setLivraisons(List<Livraison> livraisons) {
        this.livraisons = livraisons;
    }
    
    
    public void addProductLivraison(ActionEvent actionEvent) {
        System.out.println(ligneOperations.size());
        ligneOperation = new LigneOperation();
        ligneOperation.setProduit(produit);
        ligneOperation.setQuantite(quantite);
        ligneOperation.setId(Long.valueOf(ligneOperations.size()+1));
        ligneOperations.add(ligneOperation);
    }
    
    public String doCreate() throws IOException {
        livraison.setOperation(achat);
        livraison = iLivraisonEJBMetierLocal.create(livraison,ligneOperations);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("/achat/show.xhtml?q=" + livraison.getOperation().getId()+"&activ_tab=2");
        return "/achat/show?faces-redirect=true";
    }

    public String doNew() {
        return "/livraison/new?faces-redirect=true";
    }

    public String doList() {
        return "/livraison/list?faces-redirect=true";
    }

    public String doUpdate() throws IOException {
        iLivraisonEJBMetierLocal.update(livraison);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + livraison.getId());
        return "show";
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
    
    public void doFind() {
        livraison = iLivraisonEJBMetierLocal.findById(livraisonId);
    }
    
    public void getAllProduitAchat() {
        
    }
}
