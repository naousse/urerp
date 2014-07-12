/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Stock;
import com.urservices.urerp.metier.IStockEJBMetierLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author samuel
 */
//Bean géré
@ManagedBean(name = "stockBean")

//Matérialise la durée de vie du bean (temps d'une requête pour @RequestScoped)
@RequestScoped
public class StockBean implements Serializable{
    
    private Stock stock;
    
    private List<Stock> stocks;
    
    private Long stockId;
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    //Injection d'une référence vers l'EJB IStockEJBMetierLocal
    @EJB
    private IStockEJBMetierLocal iStockEJBMetierLocal;

    /**
     * Creates a new instance of StockBean
     */
    public StockBean() {
        stock = new Stock();
        stocks = new ArrayList<Stock>();
    }

    public Stock getStock() {
        return stock;
    }

    public Long getStockId() {
        return stockId;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    
    public String doCreate() throws IOException{
        iStockEJBMetierLocal.create(stock);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement avec succès", "Enregistrement avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + stock.getId());
        return "show";
    }
    
    public String doNew() {
        return "/stock/new?faces-redirect=true";
    }

    public String doList() {
        return "/stock/list?faces-redirect=true";
    }

    public String doUpdate() throws IOException {
        iStockEJBMetierLocal.update(stock);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification avec succès", "Modification avec succès"));
        context.getExternalContext().redirect("show.xhtml?q=" + stock.getId());
        return "show";
    }

    public String doEdit() {
        return "edit.xhtml";
    }

    public String doShow() {
        return "show";
    }

    public void doFind() {
        stock = iStockEJBMetierLocal.findById(stockId);
    }
}
