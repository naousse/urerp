/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Stock;
import java.util.List;

/**
 *
 * @author samuel
 */
public interface IStockEJBDao {
    
    public Stock create(Stock stock);
    
    public Stock update(Stock stock);
    
    public int delete(Stock stock);
    
    public Stock findById(Long id);
    
    public List<Stock> findAll();
    
}
