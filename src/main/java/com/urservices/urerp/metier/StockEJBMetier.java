/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.IStockEJBDaoLocal;
import com.urservices.urerp.entities.Stock;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class StockEJBMetier implements IStockEJBMetierLocal, IStockEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB IStockEJBDaoLocal
    @EJB
    private IStockEJBDaoLocal iStockEJBDaoLocal;

    @Override
    public Stock create(Stock stock) {
        return iStockEJBDaoLocal.create(stock);
    }

    @Override
    public Stock update(Stock stock) {
        return iStockEJBDaoLocal.update(stock);
    }

    @Override
    public int delete(Stock stock) {
        return iStockEJBDaoLocal.delete(stock);
    }

    @Override
    public Stock findById(Long id) {
        return iStockEJBDaoLocal.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        return iStockEJBDaoLocal.findAll();
    }

}
