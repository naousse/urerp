/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.managedbean;

import com.urservices.urerp.entities.Stock;
import com.urservices.urerp.metier.IStockEJBMetierLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author samuel
 */
@Named(value = "stockListBean")
@ViewScoped
public class StockListBean implements Serializable{

    private Stock stock;
    
    private List<Stock> stocks;
    
    private boolean buttonDisabled = true;
    
    @EJB
    private IStockEJBMetierLocal iStockEJBMetierLocal;
    
    /**
     * Creates a new instance of StockListBean
     */
    public StockListBean() {
        stock = new Stock();
        buttonDisabled = true;
    }

    public Stock getStock() {
        return stock;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        buttonDisabled = false;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled;
    }
    
    public List<Stock> getAllStocks() {
        return iStockEJBMetierLocal.findAll();
    }

    public String getEditUrl() {
        return "/stock/edit";
    }

    public String getShowUrl() {
        return "/stock/show";
    }
}
