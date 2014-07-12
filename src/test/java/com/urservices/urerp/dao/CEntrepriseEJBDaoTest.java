/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class CEntrepriseEJBDaoTest {
    
    private static Context context;
    private CEntreprise cEntreprise = new CEntreprise(0L, "Diapharma", new Adresse(33333333L, "diapharma@yahoo.fr", "BP 45 "));
    private CEntreprise cEntreprisePersistent = new CEntreprise(0L, "Diapharma", new Adresse(33333333L, "diapharma@yahoo.fr", "BP 45 "));
    private Long id;
    private static ICEntrepriseEJBDaoLocal instance = null;
    
    public CEntrepriseEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (ICEntrepriseEJBDaoLocal)context.lookup("java:global/classes/CEntrepriseEJBDao!com.urservices.urerp.dao.ICEntrepriseEJBDaoLocal");
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
     * Test of create method, of class CEntrepriseEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("Client créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(cEntreprise);
        assertTrue("Client supprimé", delete!=0);
    }

    /**
     * Test of update method, of class CEntrepriseEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(cEntreprisePersistent);
        cEntreprise.setNom("samuel");
        CEntreprise result = instance.update(cEntreprisePersistent);
        assertTrue("Client Entreprise modifié", result.getNom().equals(cEntreprisePersistent.getNom()));
        System.out.println("Result Id " + result.getId());
        System.out.println("CEntreprise Id " + cEntreprisePersistent.getId());
        cEntreprise = result;
    }

    /**
     * Test of delete method, of class CEntrepriseEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("CLient Entreprise créé", id!=0);
        int nbDeLignesAffectées = instance.delete(cEntreprise);
        assertTrue("Client Entreprise supprimé", nbDeLignesAffectées!=0);
    }

    /**
     * Test of findById method, of class CEntrepriseEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("Client Entreprise créé", id!=0);
        CEntreprise results = instance.findById(cEntreprise.getId());
        assertTrue("Le Client Entreprise a bien été trouvé", results.getId()!=0);
        int nbDeLignesAffectées = instance.delete(cEntreprise);
        assertTrue("Client Entreprise supprimé", nbDeLignesAffectées!=0);
    }

    /**
     * Test of findAll method, of class CEntrepriseEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        CEntreprise result = instance.create(cEntreprise);
        id = result.getId();
        assertTrue("Client Entreprise créé", id!=0);
        List<CEntreprise> results = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !results.isEmpty());
        int delete = instance.delete(cEntreprise);
        assertTrue("Client Entreprise supprimé", delete!=0);
    }
}