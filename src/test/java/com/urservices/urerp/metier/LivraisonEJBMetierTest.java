/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
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
public class LivraisonEJBMetierTest {
    
    private static Context context;
    private Livraison livraison = new Livraison(0L, "GT5212i", new Date());
    private static ILivraisonEJBMetierLocal instance = null;
    
    public LivraisonEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Livraison EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (ILivraisonEJBMetierLocal)context.lookup("java:global/classes/LivraisonEJBMetier!com.urservices.urerp.metier.ILivraisonEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Livraison EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LivraisonEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Livraison result = instance.create(livraison);
        assertTrue("Livraison créée", result.getId()!=0);
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of update method, of class LivraisonEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Livraison result = instance.create(livraison);
        result.setNumero("5212P");
        Livraison results = instance.update(result);
        assertTrue("Livraison modifié", results.getNumero().equals(result.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Livraison Id " + results.getId());
        livraison = results;
    }

    /**
     * Test of delete method, of class LivraisonEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Livraison result = instance.create(livraison);
        assertTrue("Livraison créée", result.getId()!=0);
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class LivraisonEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Livraison result = instance.create(livraison);
        assertTrue("Livraison créée", result.getId()!=0);
        Livraison l = instance.findById(result.getId());
        assertTrue("L'élément a été retrouvé", result.getNumero().equals(l.getNumero()));
        int delete = instance.delete(livraison);
        assertTrue("Livraison supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class LivraisonEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Livraison result = instance.create(livraison);
        assertTrue("Livraison créée", result.getId()!=0);
        List<Livraison> livraisons = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !livraisons.isEmpty());
        int delete = instance.delete(livraison);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}