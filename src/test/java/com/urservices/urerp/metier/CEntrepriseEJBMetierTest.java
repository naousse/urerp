/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Adresse;
import com.urservices.urerp.entities.CEntreprise;
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
public class CEntrepriseEJBMetierTest {
    
    private static Context context;
    private CEntreprise cEntreprise = new CEntreprise(0L, "Diapharma", new Adresse(5652927L, "diapharma@yahoo.fr", "BP 61 baf"));
    private Long id;
    private static ICEntrepriseEJBMetierLocal instance = null;
    
    public CEntrepriseEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (ICEntrepriseEJBMetierLocal)context.lookup("java:global/classes/CEntrepriseEJBMetier!com.urservices.urerp.metier.ICEntrepriseEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test EJB metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CEntrepriseEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("Client créé", id!=0);
        System.out.println("Result Id " + id);
        int delete = instance.delete(cEntreprise);
        assertTrue("Client supprimé", delete!=0);
    }

    /**
     * Test of update method, of class CEntrepriseEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        CEntreprise result = instance.create(cEntreprise);
        result.setNom("Baf");
        CEntreprise result2 = instance.update(result);
        assertTrue("Client modifié", result2.getNom().equals(result.getNom()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Client Id " + result2.getId());
        cEntreprise = result2;
    }

    /**
     * Test of delete method, of class CEntrepriseEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("Client créé", id!=0);
        int delete = instance.delete(cEntreprise);
        assertTrue("Client supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class CEntrepriseEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        CEntreprise result = instance.create(cEntreprise);
        assertTrue("client créé", result.getId()!=0);
        CEntreprise results = instance.findById(result.getId());
        assertTrue("Client retrouvé", results.getNom().equals("Diapharma"));
        int delete = instance.delete(cEntreprise);
        assertTrue("Client supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class CEntrepriseEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CEntreprise result = instance.create(cEntreprise);
        assertTrue("Client créé", result.getId()!=0);
        List<CEntreprise> cEntreprises = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !cEntreprises.isEmpty());
        int delete = instance.delete(cEntreprise);
        assertTrue("Client supprimé", delete!=0);
    }
}