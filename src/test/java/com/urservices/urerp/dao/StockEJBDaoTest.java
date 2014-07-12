package com.urservices.urerp.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class StockEJBDaoTest {
    
    private static Context context;
    private Stock stock = new Stock(0L, new Date(), new Date(), 45);
    private Stock stockPersistent = new Stock(0L, new Date(), new Date(), 45);
    private Long id;
    private static IStockEJBDaoLocal instance = null;
    
    public StockEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IStockEJBDaoLocal)context.lookup("java:global/classes/StockEJBDao!com.urservices.urerp.dao.IStockEJBDaoLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class StockEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Stock result = instance.create(stock);
        id = result.getId();
        assertTrue("Nouveau Stock crée", id!=0);
        System.out.println("Result Id "+result.getId());
        int delete = instance.delete(stock);
        assertTrue("Le stock a été crée", delete!=0);
       
        
    }

    /**
     * Test of update method, of class StockEJBDao.
     */
   @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(stockPersistent);
        stockPersistent.setDateDePeremption(new Date());
        Stock result = instance.update(stockPersistent);
        System.out.println("Result Id "+result.getId());
        System.out.println("Stock Id "+stockPersistent.getId());
        stock = result;
    }


    /**
     * Test of findById method, of class StockEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Stock result = instance.create(stock);
        id = result.getId();
        assertTrue("Stock crée", id!=0);
        Stock results = instance.findById(stock.getId());
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class StockEJBDao.
     */
   @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Stock resultCreation = instance.create(stock);
        id = resultCreation.getId();
        assertTrue("Stock crée", id!=0);
        List<Stock> stocks = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !stocks.isEmpty());
        int delete = instance.delete(stock);
        assertTrue("Stock supprimé", delete!=0);
        
    }
    
    /**
     * Test of delete method, of class StockEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Stock result = instance.create(stock);
        id = result.getId();
        assertTrue("Stock crée", id!=0);
        int results = instance.delete(stock);
        assertTrue("La stock a bien été supprimée", results!=0);
       
    }
}