/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class ProduitEJBDaoTest {
    
    private static Context context;
    private Produit produit = new Produit(0L, 39L, "widal test", 45, 25, null, null);
    private Produit produitPersistent = new Produit(01L, 329L, "widal test", 45, 25, null, null);
    private Long id;
    private static IProduitEJBDaoLocal instance = null;
    
    public ProduitEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IProduitEJBDaoLocal)context.lookup("java:global/classes/ProduitEJBDao!com.urservices.urerp.dao.IProduitEJBDaoLocal");
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
     * Test of create method, of class ProduitEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Produit result = instance.create(produit);
        id = result.getId();
        assertTrue("Produit créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(produit);
        assertTrue("Produit supprimé", delete!=0);
    }

    /**
     * Test of update method, of class ProduitEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
//        instance.create(produitPersistent);
        produitPersistent.setDesignation("H pylori");
        Produit result = instance.update(produitPersistent);
//        assertTrue("Modification effectuée ", result.getDesignation().equals("paracetamol"));
        System.out.println("Result Id " + result.getId());
        System.out.println("Produit Id" + produitPersistent.getId());
        produit = result;
    }

    /**
     * Test of delete method, of class ProduitEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Produit result = instance.create(produit);
        id = result.getId();
        assertTrue("Nouveau produit crée", id!=0);
        int results = instance.delete(produit);
        assertTrue("Le produit a bien été supprimée", results!=0);
    }

    /**
     * Test of findById method, of class ProduitEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Produit result = instance.create(produit);
        id = result.getId();
        assertTrue("Nouveau produit crée", id!=0);
        Produit results = instance.findById(produit.getId());
//        assertTrue("La fonction a bien été trouvé", results.getDesignation().equals("H pylori"));
        int delete = instance.delete(produit);
        assertTrue("Le produit a été crée", delete!=0);
    }

    /**
     * Test of findAll method, of class ProduitEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Produit result = instance.create(produit);
        id = result.getId();
        assertTrue("Nouveau produit crée", id!=0);
        List<Produit> produits = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !produits.isEmpty());
        int delete = instance.delete(produit);
        assertTrue("Le produit été crée", delete!=0);
    }
}