/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.LigneOperation;
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
public class LigneOperationEJBDaoTest {
    
    private static Context context;
    private LigneOperation ligneOperation = new LigneOperation(0L, 12, 125f);
    private LigneOperation ligneOperationPersistent = new LigneOperation(0L, 13, 450f);
    private Long id;
    private static ILigneOperationEJBDaoLocal instance = null;
    
    public LigneOperationEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (ILigneOperationEJBDaoLocal)context.lookup("java:global/classes/LigneOperationEJBDao!com.urservices.urerp.dao.ILigneOperationEJBDaoLocal");
        
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
     * Test of create method, of class LigneOperationEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        LigneOperation result = instance.create(ligneOperation);
        id = result.getId();
        assertTrue("LigneOperation créée", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(ligneOperation);
        assertTrue("LigneOperation supprimée", delete!=0);
    }

    /**
     * Test of update method, of class LigneOperationEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(ligneOperationPersistent);
        ligneOperationPersistent.setPrixU(300f);
        LigneOperation result = instance.update(ligneOperationPersistent);
        assertTrue("modification éffectuée", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Ligneoperation Id " + ligneOperationPersistent.getId());
        ligneOperation = result;
    }

    /**
     * Test of delete method, of class LigneOperationEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        LigneOperation result = instance.create(ligneOperation);
        id = result.getId();
        assertTrue("LigneOperation créée", id!=0);
        int delete = instance.delete(ligneOperation);
        assertTrue("LigneOperation supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class LigneOperationEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        LigneOperation result = instance.create(ligneOperation);
        id = result.getId();
        assertTrue("Ligne Operation créée", id!=0);
        LigneOperation ligne = instance.findById(id);
        assertTrue("Des éléments ont été retrouvés", ligne.getId()!=0);
        int delete = instance.delete(ligneOperation);
        assertTrue("Ligne supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class LigneOperationEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        instance.create(ligneOperation);
        id = ligneOperation.getId();
        assertTrue("Ligne créée", id!=0);
        List<LigneOperation> results = instance.findAll();
        assertTrue("Des éléments ont été retrouvés", !results.isEmpty());
        int delete = instance.delete(ligneOperation);
        assertTrue("Ligne supprimée", delete!=0);
    }
}