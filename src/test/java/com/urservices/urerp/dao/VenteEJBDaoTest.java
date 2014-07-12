/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class VenteEJBDaoTest {
    
    private static Context context;
    private Vente vente = new Vente(0L, "3310", new Date());
    private Vente ventePersistent = new Vente(0L, "3310L", new Date());
    private Long id;
    private static IVenteEJBDaoLocal instance = null;
    
    public VenteEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IVenteEJBDaoLocal)context.lookup("java:global/classes/VenteEJBDao!com.urservices.urerp.dao.IVenteEJBDaoLocal");
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
     * Test of create method, of class VenteEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Vente result = instance.create(vente);
        id = result.getId();
        System.out.println("Result Id " + result.getId());
        assertTrue("vente créée", id!=0);
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of update method, of class VenteEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(ventePersistent);
        ventePersistent.setNumero("1022C");
        Vente result = instance.update(ventePersistent);
        assertTrue("Vente modifiée", result.getNumero().equals(ventePersistent.getNumero()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Vente Id " + ventePersistent.getId());
        vente = result;
    }

    /**
     * Test of delete method, of class VenteEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Vente result = instance.create(vente);
        id = result.getId();
        assertTrue("Vente créée", id!=0);
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class VenteEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Vente resultCreate = instance.create(vente);
        id = resultCreate.getId();
        assertTrue("Vente créée", id!=0);
        Vente result = instance.findById(id);
        assertTrue("L'élément a été retrouvé", result.getNumero().equals("3310"));
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class VenteEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Vente result = instance.create(vente);
        id = result.getId();
        assertTrue("Vente créée", id!=0);
        List<Vente> ventes = instance.findAll();
        int delete = instance.delete(vente);
        assertTrue("Vente supprimée", delete!=0);
    }
}