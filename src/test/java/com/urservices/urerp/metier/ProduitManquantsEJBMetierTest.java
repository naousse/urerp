/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.ProduitManquants;
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
public class ProduitManquantsEJBMetierTest {
    
    private static Context context;
    private ProduitManquants produitManquants = new ProduitManquants(0L, "56H", new Date());
    private static IProduitManquantsEJBMetierLocal instance = null;
    
    public ProduitManquantsEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Liste Produits Manquants");
        
        context = EJBDaoTestSuite.context;
        instance = (IProduitManquantsEJBMetierLocal)context.lookup("java:global/classes/ProduitManquantsEJBMetier!com.urservices.urerp.metier.IProduitManquantsEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test EJB Metier Produits Manquants");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProduitManquantsEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ProduitManquants result = instance.create(produitManquants);
        assertTrue("Liste Produit Manquants créée", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(produitManquants);
        assertTrue("Liste Produit Manquants supprimée", delete!=0);
    }

    /**
     * Test of update method, of class ProduitManquantsEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ProduitManquants result = instance.create(produitManquants);
        assertTrue("Liste Produit Manquants créée", result.getId()!=0);
        result.setNumero("46Y");
        ProduitManquants results = instance.update(produitManquants);
        assertTrue("Liste Produit Manquants modifiée", results.getNumero().equals(result.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Produit Manquants Id " + results.getId());
        produitManquants = results;
    }

    /**
     * Test of delete method, of class ProduitManquantsEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ProduitManquants result = instance.create(produitManquants);
        assertTrue("Liste Produit Manquants créée", result.getId()!=0);
        int delete = instance.delete(produitManquants);
        assertTrue("Liste Produit Manquants supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class ProduitManquantsEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        ProduitManquants result = instance.create(produitManquants);
        assertTrue("Liste Produit Manquants créée", result.getId()!=0);
        ProduitManquants results = instance.findById(result.getId());
        assertTrue("Liste Produit Manquants retrouvée", results.getNumero().equals("56H"));
        int delete = instance.delete(produitManquants);
        assertTrue("Liste Produit Manquants supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class ProduitManquantsEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ProduitManquants result = instance.create(produitManquants);
        assertTrue("Liste Produit Manquants créée", result.getId()!=0);
        List<ProduitManquants> results = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !results.isEmpty());
        int delete = instance.delete(produitManquants);
        assertTrue("Liste supprimée", delete!=0);
    }
}