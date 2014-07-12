/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Periode;
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
public class PeriodeEJBMetierTest {
    
    private static Context context;
    private Periode periode = new Periode(0L, new Date(), new Date());
    private static IPeriodeEJBMetierLocal instance = null;
    
    public PeriodeEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Periode EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IPeriodeEJBMetierLocal)context.lookup("java:global/classes/PeriodeEJBMetier!com.urservices.urerp.metier.IPeriodeEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Periode EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class PeriodeEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Periode result = instance.create(periode);
        assertTrue("Periode créée", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(periode);
        assertTrue("Periode supprimée", delete!=0);
    }

    /**
     * Test of update method, of class PeriodeEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Periode result = instance.create(periode);
        result.setDateDebut(new Date());
        Periode results = instance.update(result);
        assertTrue("Periode modifiée", results.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Periode Id " + results.getId());
        periode = results;
    }

    /**
     * Test of delete method, of class PeriodeEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Periode result = instance.create(periode);
        assertTrue("Periode créée", result.getId()!=0);
        int delete = instance.delete(periode);
        assertTrue("Periode supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class PeriodeEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Periode result = instance.create(periode);
        assertTrue("Periode créée", result.getId()!=0);
        Periode results = instance.findById(result.getId());
        assertTrue("L'élément a été retrouvé", results.getDateDebut().equals(result.getDateDebut()));
        int delete = instance.delete(periode);
        assertTrue("élément supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class PeriodeEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Periode result = instance.create(periode);
        assertTrue("Periode créée", result.getId()!=0);
        List<Periode> periodes = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !periodes.isEmpty());
        int delete = instance.delete(periode);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}