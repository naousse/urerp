/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class PaiementEJBDaoTest {
    
    private static Context context;
    private Paiement paiement = new Paiement(0L, 450f);
    private Paiement paiementPersistent = new Paiement(0L, 450f);
    private Long id;
    private static IPaiementEJBDaoLocal instance = null;
    
    public PaiementEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IPaiementEJBDaoLocal)context.lookup("java:global/classes/PaiementEJBDao!com.urservices.urerp.dao.IPaiementEJBDaoLocal");
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
     * Test of create method, of class PaiementEJBDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Paiement result = instance.create(paiement);
        id = result.getId();
        assertTrue("Paiement créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(paiement);
        assertTrue("Paiement supprimé", delete!=0);
    }

    /**
     * Test of update method, of class PaiementEJBDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(paiementPersistent);
        paiementPersistent.setMontant(900f);
        Paiement result = instance.update(paiement);
        paiement = result;
    }

    /**
     * Test of delete method, of class PaiementEJBDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Paiement result = instance.create(paiement);
        id = result.getId();
        assertTrue("Nouveau Paiement crée", id!=0);
        int results = instance.delete(paiement);
        assertTrue("Le paiement a bien été supprimé", results!=0);
    }

    /**
     * Test of findById method, of class PaiementEJBDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Paiement result = instance.create(paiement);
        id = result.getId();
        assertTrue("Nouveau Paiement crée", id!=0);
        Paiement results = instance.findById(paiement.getId());
        int delete = instance.delete(paiement);
        assertTrue("Paiement crée", delete!=0);
    }

    /**
     * Test of findAll method, of class PaiementEJBDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Paiement result = instance.create(paiement);
        id = result.getId();
        assertTrue("Nouveau Paiement crée", id!=0);
        List<Paiement> results = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !results.isEmpty());
        int delete = instance.delete(paiement);
        assertTrue("Le paiement a été supprimé", delete!=0);
    }
}