/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Adresse;
import com.urservices.urerp.entities.CPhysique;
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
public class CPhysiqueEJBDaoTest {
    
    private static Context context;
    private CPhysique cPhysique = new CPhysique("10252627", "sam", 0L, "folong", new Adresse(222222L, "samuel@yahoo.fr", "BP 61 Mda"));
    private CPhysique cPhysiquePersistent = new CPhysique("10252627", "samuel", 0L, "Kamdoum", new Adresse(222222L, "samuel@yahoo.fr", "BP 61 Mda"));
    private Long id;
    private static ICPhysiqueEJBDaoLocal instance = null;
    
    public CPhysiqueEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (ICPhysiqueEJBDaoLocal)context.lookup("java:global/classes/CPhysiqueEJBDao!com.urservices.urerp.dao.ICPhysiqueEJBDaoLocal");
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
     * Test of create method, of class CPhysiqueEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CPhysique result = instance.create(cPhysique);
        id = result.getId();
        assertTrue("Client Physique créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(cPhysique);
        assertTrue("Client Physique supprimé", delete!=0);
    }

    /**
     * Test of update method, of class CPhysiqueEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(cPhysiquePersistent);
        cPhysiquePersistent.setPrenom("Charly");
        CPhysique result = instance.update(cPhysiquePersistent);
        assertTrue("Client modifié", result.getPrenom().equals(cPhysiquePersistent.getPrenom()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Client Id " + cPhysiquePersistent.getId());
        cPhysique = result;
    }

    /**
     * Test of delete method, of class CPhysiqueEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        CPhysique result = instance.create(cPhysique);
        id = result.getId();
        assertTrue("Client Physique créé", id!=0);
        int delete = instance.delete(cPhysique);
        assertTrue("Client Physique supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class CPhysiqueEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        CPhysique result = instance.create(cPhysique);
        id = result.getId();
        assertTrue("Client Physique créé", id!=0);
        CPhysique physique = instance.findById(id);
        assertTrue("Le client a bien été retrouvé", physique.getPrenom().equals("sam"));
        int delete = instance.delete(cPhysique);
        assertTrue("Client supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class CPhysiqueEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CPhysique result = instance.create(cPhysique);
        id = result.getId();
        assertTrue("Client créé", id!=0);
        List<CPhysique> cPhysiques = instance.findAll();
        assertTrue("Les éléments ont été retrouvés", !cPhysiques.isEmpty());
        int delete = instance.delete(cPhysique);
        assertTrue("Liste supprimée", delete!=0);
    }
}