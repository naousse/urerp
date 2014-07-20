/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.CEntreprise;
import com.urservices.urerp.entities.CPhysique;
import com.urservices.urerp.entities.LigneOperation;
import com.urservices.urerp.entities.Produit;
import com.urservices.urerp.entities.Vente;
import com.urservices.urerp.metier.ICEntrepriseEJBMetierLocal;
import com.urservices.urerp.metier.ICPhysiqueEJBMetierLocal;
import com.urservices.urerp.metier.IProduitEJBMetierLocal;
import com.urservices.urerp.metier.IVenteEJBMetierLocal;
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
@ManagedBean(name = "venteBean")
@ViewScoped
public class VenteBean implements Serializable{
    
    private Vente vente;
    private List<Vente> ventes;
    private Long venteId;
    private Produit produit;
    private List<Produit> produits;
    private CPhysique clientPhysique;
    private List<CPhysique> clientPhysiques;
    private CEntreprise clientEntreprise;
    private List<CEntreprise> clientEntreprises;
    private LigneOperation ligneOperation;
    private static List<LigneOperation> ligneOperations = new ArrayList<LigneOperation>();
    private int quantite = 0;
    private float prixUnitaire = 0f;
    
    private FacesContext context = FacesContext.getCurrentInstance();
    
    @EJB
    private IVenteEJBMetierLocal iVenteEJBMetierLocal;
    @EJB
    private IProduitEJBMetierLocal iProduitEJBMetierLocal;
    @EJB
    private ICEntrepriseEJBMetierLocal iCEntrepriseEJBMetierLocal;
    @EJB
    private ICPhysiqueEJBMetierLocal iCPhysiqueEJBMetierLocal;
    /**
     * Creates a new instance of VenteBean
     */
    public VenteBean() {
        vente = new Vente();
        ventes = new ArrayList<Vente>();
        produit = new Produit();
        produits = new ArrayList<Produit>();
        clientEntreprise = new CEntreprise();
        clientEntreprises = new ArrayList<CEntreprise>();
        clientPhysique = new CPhysique();
        clientPhysiques = new ArrayList<CPhysique>();
        ligneOperation = new LigneOperation();
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

    public List<Produit> getProduits() {
        return produits;
    }

    public LigneOperation getLigneOperation() {
        return ligneOperation;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public void setVenteId(Long venteId) {
        this.venteId = venteId;
        vente = iVenteEJBMetierLocal.findById(venteId);
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
        this.produit = produit;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        ligneOperations = ligneOperations;
    }

    public List<LigneOperation> getLigneOperations() {
        
        for (LigneOperation lo : ligneOperations) {
            System.out.println("Id = "+lo.getId()+" "+"Qté = "+lo.getQuantite() +" "+"Produit = "+lo.getProduit());
        }
        return ligneOperations;
    }
    
    public void addProduct(ActionEvent actionEvent) {
        ligneOperation = new LigneOperation();
        ligneOperation.setProduit(produit);
        ligneOperation.setQuantite(quantite);
        ligneOperation.setPrixU(prixUnitaire);
        ligneOperation.setId(Long.valueOf(ligneOperations.size()+1));
        ligneOperations.add(ligneOperation);
    }
    
    public String doCreate() throws IOException {
        iVenteEJBMetierLocal.create(vente);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show?q=" + vente.getId());
        return "show";
    }
    
    public String doNew() {
        ligneOperations = new ArrayList<LigneOperation>();
        return "/vente/new?faces-redirect=true";
    }
    
    public String doList() {
        return "/vente/list?faces-redirect=true";
    }
    
    public String doUpdate() throws IOException {
        iVenteEJBMetierLocal.update(vente);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show?q=" + vente.getId());
        return "show";
    }
    
    public String doEdit() {
        return "show";
    }
    
    public String doSnow() {
        return "show";
    }
    
    public void doFind() {
        vente = iVenteEJBMetierLocal.findById(venteId);
    }
    
    public List<Produit> getAllProduits() {
        produits = iProduitEJBMetierLocal.findAll();
        return produits;
    }
    
    public void findClientPhysique(ActionEvent actionEvent) {
        this.clientPhysique = iCPhysiqueEJBMetierLocal.findClientPhysiqueByCni(this.clientPhysique.getCni());
    }
    
    public void findClientEntreprise(ActionEvent actionEvent) {
        this.clientEntreprise = iCEntrepriseEJBMetierLocal.findByName(this.clientEntreprise.getNom());
    }
    
}
