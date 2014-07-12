/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Adresse;
import com.urservices.urerp.entities.Fournisseur;
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
public class FournisseurEJBDaoTest {
    
    private static Context context;
    private Fournisseur fournisseur = new Fournisseur("pays", 0L,"00001", "nom", new Adresse(79330469L, "hcgd", "jgfs"));
    private Fournisseur fournisseurPersistent = new Fournisseur("pays", 0L,"00002", "nom", new Adresse(79330469L, "hcgd", "jgfs"));
    private Long id;
    private static IFournisseurEJBDaoLocal instance = null;
    
    public FournisseurEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        context = EJBDaoTestSuite.context;
        instance = (IFournisseurEJBDaoLocal)context.lookup("java:global/classes/FournisseurEJBDao!com.urservices.urerp.dao.IFournisseurEJBDaoLocal");
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
     * Test of create method, of class FournisseurEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Fournisseur result = instance.create(fournisseur);
        id = result.getId();
        assertTrue("fournisseur crée", id!=0);
        System.out.println("Result Id "+result.getId());
        int nbDeLignesAffectées = instance.delete(fournisseur);
        assertTrue("Le fournisseur a été créé", nbDeLignesAffectées!=0);
    }

    /**
     * Test of update method, of class FournisseurEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(fournisseurPersistent);
        fournisseurPersistent.setNom("samuel");
        Fournisseur result = instance.update(fournisseurPersistent);
        assertTrue("Le fournisseur a été modifié", result.getNom().equals(fournisseurPersistent.getNom()));
        System.out.println("Result Id "+result.getId());
        System.out.println("Fournisseur Id "+fournisseurPersistent.getId());
        fournisseur = result;
    }

    /**
     * Test of delete method, of class FournisseurEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Fournisseur result = instance.create(fournisseur);
        id = result.getId();
        assertTrue("Fournisseur créé", id!=0);
        int delete = instance.delete(fournisseur);
        assertTrue("Fournisseur supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class FournisseurEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Fournisseur result = instance.create(fournisseur);
        id = result.getId();
        assertTrue("Fournisseur créé", id!=0);
        Fournisseur results = instance.findById(fournisseur.getId());
        assertTrue("Le fournisseur a bien été trouvé", results.getNom().equals("nom"));
        int delete = instance.delete(fournisseur);
        assertTrue("Le fournisseur a été créé", delete!=0);
    }

    /**
     * Test of findAll method, of class FournisseurEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Fournisseur result = instance.create(fournisseur);
        id = result.getId();
        assertTrue("Nouveau Fournisseur crée", id!=0);
        List<Fournisseur> results = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !results.isEmpty());
        int delete = instance.delete(fournisseur);
        assertTrue("Le fournisseur a été crée", delete!=0);
    }
}