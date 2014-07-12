/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Livraison;
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
public class LivraisonEJBDaoTest {
    
    private static Context context;
    private Livraison livraison = new Livraison(0L, "456T", new Date());
    private Livraison livraisonPersistent = new Livraison(0L, "76L", new Date());
    private Long id;
    private static ILivraisonEJBDaoLocal instance = null;
    
    public LivraisonEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        
        context = EJBDaoTestSuite.context;
        instance = (ILivraisonEJBDaoLocal)context.lookup("java:global/classes/LivraisonEJBDao!com.urservices.urerp.dao.ILivraisonEJBDaoLocal");
        
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
     * Test of create method, of class LivraisonEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Livraison result = instance.create(livraison);
        id = result.getId();
        assertTrue("Livraison créée", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of update method, of class LivraisonEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(livraisonPersistent);
        livraisonPersistent.setNumero("78Y");
        Livraison result = instance.update(livraisonPersistent);
        assertTrue("livraison modifiée", result.getNumero().equals(livraisonPersistent.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Livraison Id " + livraisonPersistent.getId());
        livraison = result;
    }

    /**
     * Test of delete method, of class LivraisonEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Livraison result = instance.create(livraison);
        id = result.getId();
        assertTrue("Livraison créée", id!=0);
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class LivraisonEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Livraison result = instance.create(livraison);
        id = result.getId();
        assertTrue("Livraison créée", id!=0);
        Livraison results = instance.findById(id);
        assertTrue("L'élément a été retrouvé", results.getNumero().equals("456T"));
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class LivraisonEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Livraison result = instance.create(livraison);
        id = result.getId();
        assertTrue("Livraison créée", id!=0);
        List<Livraison> livraisons = instance.findAll();
        assertTrue("Les éléments ont été retrouvé", !livraisons.isEmpty());
        int delete = instance.delete(livraison);
        assertTrue("Les éléments ont été supprimée", delete!=0);
    }
}