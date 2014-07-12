/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class PeriodeEJBDaoTest {
    
    private static Context context;
    private Periode periode = new Periode(0L, new Date(), new Date());
    private Periode periodePersistent = new Periode(0L, new Date(), new Date());
    private Long id;
    private static IPeriodeEJBDaoLocal instance = null;
    
    public PeriodeEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IPeriodeEJBDaoLocal)context.lookup("java:global/classes/PeriodeEJBDao!com.urservices.urerp.dao.IPeriodeEJBDaoLocal");
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
     * Test of create method, of class PeriodeEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Periode result = instance.create(periode);
        id = result.getId();
        assertTrue("Result id", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(periode);
        assertTrue("Periode supprimée", delete!=0);
    }

    /**
     * Test of update method, of class PeriodeEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(periodePersistent);
        periodePersistent.setDateDebut(new Date());
        Periode result = instance.update(periodePersistent);
        assertTrue("Période modifiée", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Periode Id " + periodePersistent.getId());
        periode = result;
    }

    /**
     * Test of delete method, of class PeriodeEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Periode result = instance.create(periode);
        id = result.getId();
        assertTrue("Période créée", id!=0);
        int delete = instance.delete(periode);
        assertTrue("Période supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class PeriodeEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Periode result = instance.create(periode);
        id = result.getId();
        assertTrue("Periode créée", id!=0);
        Periode periodes = instance.findById(id);
        assertTrue("Des éléments ont été retrouvés", periode.getId()!=0);
        int delete = instance.delete(periodes);
        assertTrue("Periode supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class PeriodeEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Periode result = instance.create(periode);
        id = result.getId();
        assertTrue("Periode créée", id!=0);
        List<Periode> periodes = instance.findAll();
        assertTrue("Des éléments ont été retrouvés", !periodes.isEmpty());
        int delete = instance.delete(periode);
        assertTrue("Periode supprimée", delete!=0);
    }
}