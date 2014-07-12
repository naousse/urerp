/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Vente;
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
public class VenteEJBMetierTest {
    
    private static Context context;
    private Vente vente = new Vente(0L, "Stock 25", new Date());
    private static IVenteEJBMetierLocal instance = null;
    
    public VenteEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Vente EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IVenteEJBMetierLocal)context.lookup("java:global/classes/VenteEJBMetier!com.urservices.urerp.metier.IVenteEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Vente EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class VenteEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Vente result = instance.create(vente);
        assertTrue("Vente créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of update method, of class VenteEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Vente result = instance.create(vente);
        assertTrue("Vente créée", result.getId()!=0);
        result.setNumero("Stock 5");
        Vente results = instance.update(vente);
        assertTrue("Vente modifiée", results.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("vente Id " + results.getId());
        vente = results;
    }

    /**
     * Test of delete method, of class VenteEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Vente result = instance.create(vente);
        assertTrue("Vente créée", result.getId()!=0);
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class VenteEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Vente result = instance.create(vente);
        assertTrue("Vente créée", result.getId()!=0);
        Vente results = instance.findById(result.getId());
        assertTrue("Vente retrouvée", results.getNumero().equals(result.getNumero()));
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class VenteEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Vente result = instance.create(vente);
        assertTrue("Vente créée", result.getId()!=0);
        List<Vente> ventes = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !ventes.isEmpty());
        int delete = instance.delete(vente);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}