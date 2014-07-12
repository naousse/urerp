/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Paiement;
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
public class PaiementEJBMetierTest {
    
    private static Context context;
    private Paiement paiement = new Paiement(0L, 500f);
    private static IPaiementEJBMetierLocal instance = null;
    
    public PaiementEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Paiement EJB metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IPaiementEJBMetierLocal)context.lookup("java:global/classes/PaiementEJBMetier!com.urservices.urerp.metier.IPaiementEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Paiement EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PaiementEJBMetier.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Paiement result = instance.create(paiement);
        assertTrue("Paiement créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(paiement);
        assertTrue("Paiement supprimé", delete!=0);
    }

    /**
     * Test of update method, of class PaiementEJBMetier.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Paiement result = instance.create(paiement);
        result.setMontant(450f);
        Paiement results = instance.update(result);
        assertTrue("Paiement créé", result.getMontant().equals(results.getMontant()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Paiement Id " + results.getId());
        paiement = results;
    }

    /**
     * Test of delete method, of class PaiementEJBMetier.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Paiement result = instance.create(paiement);
        assertTrue("Paiement créé", result.getId()!=0);
        int delete = instance.delete(paiement);
        assertTrue("Paiement supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class PaiementEJBMetier.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Paiement result = instance.create(paiement);
        assertTrue("Paiement créé", result.getId()!=0);
        Paiement results = instance.findById(result.getId());
        assertTrue("élément retrouvé", results.getMontant().equals(result.getMontant()));
        int delete = instance.delete(paiement);
        assertTrue("Paiement supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class PaiementEJBMetier.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Paiement result = instance.create(paiement);
        assertTrue("Paiement créé", result.getId()!=0);
        List<Paiement> paiements = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !paiements.isEmpty());
        int delete = instance.delete(paiement);
        assertTrue("Les éléments ont été supprimé", delete!=0);
    }
}