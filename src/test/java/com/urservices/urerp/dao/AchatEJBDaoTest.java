/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Achat;
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
public class AchatEJBDaoTest {
    
    private static Context context;
    private Achat achat = new Achat(0L, "12A", new Date());
    private Achat achatPersistent = new Achat(1L, "12B", new Date());
    private Long id;
    private static IAchatEJBDaoLocal instance = null;
    
    public AchatEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IAchatEJBDaoLocal)context.lookup("java:global/classes/AchatEJBDao!com.urservices.urerp.dao.IAchatEJBDaoLocal");
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
     * Test of create method, of class AchatEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        achat.setNumero("13");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("L'achat a été créé ", result.getId() !=0);
        System.out.println("Result Id " + result.getId());
        int nbDeLignesAffectées = instance.delete(achat);
        assertTrue("L'achat a été supprimé", nbDeLignesAffectées !=0);
    }

    /**
     * Test of update method, of class AchatEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(achatPersistent);
        achatPersistent.setNumero("7");
        Achat result = instance.update(achatPersistent);
        assertTrue("Achat modifié", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Achat Id " + achatPersistent.getId());
        achat = result;
    }

    /**
     * Test of delete method, of class AchatEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("Achat créé", id!=0);
        int delete = instance.delete(achat);
        assertTrue("Achat supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class AchatEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("achat créé", id!=0);
        Achat results = instance.findById(achat.getId());
        assertTrue("L'achat a bien été trouvé", results.getId()!=0);
        int delete = instance.delete(achat);
        assertTrue("achat supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class AchatEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("achat crée", id!=0);
        List<Achat> results = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !results.isEmpty());
        int nbDeLignesAffectées = instance.delete(achat);
        assertTrue("achat supprimé", nbDeLignesAffectées!=0);
    }
}