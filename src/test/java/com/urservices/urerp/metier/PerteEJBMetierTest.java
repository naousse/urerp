/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Perte;
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
public class PerteEJBMetierTest {
    
    private static Context context;
    private Perte perte = new Perte(0L, "12Y", new Date());
    private static IPerteEJBMetierLocal instance = null;
    
    public PerteEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Perte EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IPerteEJBMetierLocal)context.lookup("java:global/classes/PerteEJBMetier!com.urservices.urerp.metier.IPerteEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Perte EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PerteEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Perte result = instance.create(perte);
        assertTrue("Perte créée", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(perte);
        assertTrue("Perte supprimée", delete!=0);
    }

    /**
     * Test of update method, of class PerteEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Perte result = instance.create(perte);
        assertTrue("Perte créée", result.getId()!=0);
        result.setNumero("45R");
        Perte results = instance.update(perte);
        assertTrue("Perte modifiée", results.getNumero().equals(result.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Perte Id " + results.getId());
        perte = results;
    }

    /**
     * Test of delete method, of class PerteEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Perte result = instance.create(perte);
        assertTrue("Perte créée", result.getId()!=0);
        int delete = instance.delete(perte);
        assertTrue("Perte supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class PerteEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Perte result = instance.create(perte);
        assertTrue("Perte créée", result.getId()!=0);
        Perte results = instance.findById(result.getId());
        assertTrue("élément retrouvé", results.getNumero().equals("12Y"));
        int delete = instance.delete(perte);
        assertTrue("Perte supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class PerteEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Perte result = instance.create(perte);
        assertTrue("Perte créée", result.getId()!=0);
        List<Perte> pertes = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !pertes.isEmpty());
        int delete = instance.delete(perte);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}