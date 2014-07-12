/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Stock;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author samuel
 */
@Ignore
public class StockEJBMetierTest {
    
    private static Context context;
    private Stock stock = new Stock(0L, new Date(), new Date(), 50);
    private static IStockEJBMetierLocal instance = null;
    
    public StockEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Stock EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IStockEJBMetierLocal)context.lookup("java:global/classes/StockEJBMetier!com.urservices.urerp.metier.IStockEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test stock EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class StockEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Stock result = instance.create(stock);
        assertTrue("Stock créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
    }

    /**
     * Test of update method, of class StockEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Stock result = instance.create(stock);
        assertTrue("Stock créé", result.getId()!=0);
        result.setDateAlerte(new Date());
        Stock results = instance.update(result);
        assertTrue("Stock modifié", results.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Stock Id " + results.getId());
        stock = results;
    }

    /**
     * Test of delete method, of class StockEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Stock result = instance.create(stock);
        assertTrue("Stock créé", result.getId()!=0);
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class StockEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Stock result = instance.create(stock);
        assertTrue("Stock créé", result.getId()!=0);
        Stock results = instance.findById(result.getId());
        assertTrue("Stock retrouvé", results.getId()!=0);
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class StockEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Stock result = instance.create(stock);
        assertTrue("Stock créé", result.getId()!=0);
        List<Stock> stocks = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !stocks.isEmpty());
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
    }
}