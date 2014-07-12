/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class PerteEJBDaoTest {
    
    private static Context context;
    private Perte perte = new Perte(0L, "44R", new Date());
    private Perte pertePersistent = new Perte(0L, "54R", new Date());
    private Long id;
    private static IPerteEJBDaoLocal instance = null;
    
    public PerteEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IPerteEJBDaoLocal)context.lookup("java:global/classes/PerteEJBDao!com.urservices.urerp.dao.IPerteEJBDaoLocal");
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
     * Test of create method, of class PerteEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Perte result = instance.create(perte);
        id = result.getId();
        assertTrue("Perte créée", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(perte);
        assertTrue("Perte supprimée", delete!=0);
    }

    /**
     * Test of update method, of class PerteEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(pertePersistent);
        pertePersistent.setNumero("670L");
        Perte result = instance.update(pertePersistent);
        assertTrue("Perte modifiée", result.getNumero().equals(pertePersistent.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Perte Id " + pertePersistent.getId());
        perte = result;
    }

    /**
     * Test of delete method, of class PerteEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Perte result = instance.create(perte);
        id = result.getId();
        assertTrue("Perte créée", id!=0);
        int delete = instance.delete(perte);
        assertTrue("Perte supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class PerteEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Perte result = instance.create(perte);
        id = result.getId();
        assertTrue("L'élément a été retrouvé", id!=0);
        Perte results = instance.findById(id);
        assertTrue("Perte supprimée", results.getNumero().equals("44R"));
        
    }

    /**
     * Test of findAll method, of class PerteEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Perte result = instance.create(perte);
        id = result.getId();
        assertTrue("Perte créée", id!=0);
        List<Perte> pertes = instance.findAll();
        assertTrue("Les éléments ont été retrouvé", !pertes.isEmpty());
        int delete = instance.delete(perte);
        assertTrue("Liste supprimée", delete!=0);
    }
}