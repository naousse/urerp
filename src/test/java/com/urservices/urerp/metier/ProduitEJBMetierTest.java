/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Produit;
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
public class ProduitEJBMetierTest {
    
    private static Context context;
    private Produit produit = new Produit(0L, 02L, "Widal test", 45, 15, null, null);
    private static IProduitEJBMetierLocal instance = null;
    
    public ProduitEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Produit EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IProduitEJBMetierLocal)context.lookup("java:global/classes/ProduitEJBMetier!com.urservices.urerp.metier.IProduitEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Produit EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProduitEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Produit result = instance.create(produit);
        assertTrue("Produit créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(produit);
        assertTrue("Produit supprimé", delete!=0);
    }

    /**
     * Test of update method, of class ProduitEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Produit result = instance.create(produit);
        assertTrue("Produit créé", result.getId()!=0);
        result.setDesignation("H Pylori");
        Produit results = instance.update(result);
        assertTrue("Produit modifié", results.getDesignation().equals(result.getDesignation()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Produit Id " + results.getId());
        produit = results;
    }

    /**
     * Test of delete method, of class ProduitEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Produit result = instance.create(produit);
        assertTrue("Produit créé", result.getId()!=0);
        int delete = instance.delete(produit);
        assertTrue("Produit supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class ProduitEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Produit result = instance.create(produit);
        assertTrue("Produit créé", result.getId()!=0);
        Produit results = instance.findById(result.getId());
        assertTrue("Produit retrouvé", results.getDesignation().equals(result.getDesignation()));
        int delete = instance.delete(produit);
        assertTrue("Produit supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class ProduitEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Produit result = instance.create(produit);
        assertTrue("Produit créé", result.getId()!=0);
        List<Produit> produits = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !produits.isEmpty());
        int delete = instance.delete(produit);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}