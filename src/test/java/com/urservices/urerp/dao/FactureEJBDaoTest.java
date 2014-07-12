/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class FactureEJBDaoTest {
    
    private static Context context;
    private Facture facture = new Facture(0L, "45R", new Date());
    private Facture facturePersistent = new Facture(0L, "459R", new Date());
    private Long id;
    private static IFactureEJBDaoLocal instance = null;
    
    public FactureEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        
        context = EJBDaoTestSuite.context;
        instance = (IFactureEJBDaoLocal)context.lookup("java:global/classes/FactureEJBDao!com.urservices.urerp.dao.IFactureEJBDaoLocal");
        
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
     * Test of create method, of class FactureEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Facture result = instance.create(facture);
        id = result.getId();
        System.out.println("Result Id " + result.getId());
        assertTrue("Facture créée", id!=0);
        int delete = instance.delete(facture);
        assertTrue("Facture supprimée", delete!=0);
    }

    /**
     * Test of update method, of class FactureEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(facturePersistent);
        facturePersistent.setNumero("45G");
        Facture f = instance.update(facturePersistent);
        assertTrue("Facture modifiée", f.getNumero().equals(facturePersistent.getNumero()));
        System.out.println("Result Id " + f.getId());
        System.out.println("Facture Id " + facturePersistent.getId());
        facture = f;
    }

    /**
     * Test of delete method, of class FactureEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        int delete = instance.delete(facture);
        assertTrue("Facture supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class FactureEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        Facture results = instance.findById(id);
        assertTrue("L'élément a été retrouvé", results.getNumero().equals("45R"));
        int delete = instance.delete(facture);
        assertTrue("facture supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class FactureEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Facture result = instance.create(facture);
        id = result.getId();
        assertTrue("Facture créée", id!=0);
        List<Facture> factures = instance.findAll();
        assertTrue("Des éléments ont été retrouvés", !factures.isEmpty());
        int delete = instance.delete(facture);
        assertTrue("Des éléments ont été supprimés", delete!=0);
    }
}