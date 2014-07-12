/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
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
public class LigneOperationEJBMetierTest {
    
    private static Context context;
    private LigneOperation ligneOperation = new LigneOperation(0L, 43, 500f);
    private Long id;
    private static ILigneOperationEJBMetierLocal instance = null;
    
    public LigneOperationEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Ligne Operation EJB Metier");
         context = EJBDaoTestSuite.context;
         instance = (ILigneOperationEJBMetierLocal)context.lookup("java:global/classes/LigneOperationEJBMetier!com.urservices.urerp.metier.ILigneOperationEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Ligne Operation EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LigneOperationEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        LigneOperation result = instance.create(ligneOperation);
        assertTrue("Ligne Operation créée", result.getId()!=0);
        int delete = instance.delete(ligneOperation);
        assertTrue("Ligne supprimée", delete!=0);
    }

    /**
     * Test of update method, of class LigneOperationEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        LigneOperation result = instance.create(ligneOperation);
        assertTrue("Ligne créée", result.getId()!=0);
        result.setPrixU(450f);
        LigneOperation results = instance.update(result);
        assertTrue("Ligne modifiée", results.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Ligne Operation Id " + results.getId());
        ligneOperation = results;
    }

    /**
     * Test of delete method, of class LigneOperationEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        LigneOperation result = instance.create(ligneOperation);
        assertTrue("Ligne Operation créée", result.getId()!=0);
        int delete = instance.delete(ligneOperation);
        assertTrue("ligne supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class LigneOperationEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        LigneOperation result = instance.create(ligneOperation);
        assertTrue("Ligne créée", result.getId()!=0);
        LigneOperation operation = instance.findById(result.getId());
        assertTrue("Ligne operation retrouvée", result.getPrixU().equals(operation.getPrixU()));
        int delete = instance.delete(ligneOperation);
        assertTrue("Ligne supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class LigneOperationEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        LigneOperation result = instance.create(ligneOperation);
        assertTrue("Ligne créée", result.getId()!=0);
        List<LigneOperation> ligneOperations = instance.findAll();
        assertTrue("Les éléments ont été retrouvés", !ligneOperations.isEmpty());
        int delete = instance.delete(ligneOperation);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}