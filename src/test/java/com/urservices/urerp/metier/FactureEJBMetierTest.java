/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Facture;
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
public class FactureEJBMetierTest {
    
    private static Context context;
    private Facture facture = new Facture(0L, "D12", new Date());
    private Long id;
    private static IFactureEJBMetierLocal instance = null;
    
    public FactureEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Facture EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IFactureEJBMetierLocal)context.lookup("java:global/classes/FactureEJBMetier!com.urservices.urerp.metier.IFactureEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Facture EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FactureEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        System.out.println("Result Id " + id);
        int delete = instance.delete(facture);
        assertTrue("Facture supprimée", delete!=0);
    }

    /**
     * Test of update method, of class FactureEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Facture result = instance.create(facture);
        result.setNumero("G14");
        Facture results = instance.update(result);
        assertTrue("Facture modifiée", result.getNumero().equals(results.getNumero()));
        System.out.println("result id " + result.getId());
        System.out.println("Facture id " + results.getId());
        facture = results;
    }

    /**
     * Test of delete method, of class FactureEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Facture result = instance.create(facture);
        assertTrue("Facture créée", result.getId()!=0);
        int delete = instance.delete(facture);
        assertTrue("Facture supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class FactureEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        Facture facture2 = instance.findById(id);
        assertTrue("La facture a été retrouvée", facture2.getId()!=0);
        int delete = instance.delete(facture);
        assertTrue("Facture supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class FactureEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        List<Facture> factures = instance.findAll();
        assertTrue("Des éléments ont été retroué", !factures.isEmpty());
    }
}