/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
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
public class FournisseurEJBMetierTest {
    
    private static Context context;
    private Fournisseur fournisseur = new Fournisseur("Canada", 0L,"00001", "Mege Mix", new Adresse(436835L, "ge", "th"));
    private Long id;
    private static IFournisseurEJBMetierLocal instance = null;
    
    public FournisseurEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Fournisseur EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IFournisseurEJBMetierLocal)context.lookup("java:global/classes/FournisseurEJBMetier!com.urservices.urerp.metier.IFournisseurEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Fournisseur EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FournisseurEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Fournisseur result = instance.create(fournisseur);
        assertTrue("Fournisseur créé", result.getId()!=0);
        int delete = instance.delete(fournisseur);
        assertTrue("fournisseur supprimé", delete!=0);
    }

    /**
     * Test of update method, of class FournisseurEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Fournisseur result = instance.create(fournisseur);
        result.setPays("Espagne");
        Fournisseur results = instance.update(result);
        assertTrue("Fournisseur modifié", results.getPays().equals(result.getPays()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Fournisseur Id " + results.getId());
        fournisseur = results;
    }

    /**
     * Test of delete method, of class FournisseurEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Fournisseur result = instance.create(fournisseur);
        assertTrue("Fournisseur créé", result.getId()!=0);
        int delete = instance.delete(fournisseur);
        assertTrue("Fournisseur supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class FournisseurEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Fournisseur result = instance.create(fournisseur);
        assertTrue("ournisseur créé", result.getId()!=0);
        Fournisseur fournisseurs = instance.findById(result.getId());
        assertTrue("Le fournisseur a été retrouvé", fournisseurs.getPays().equals("Canada"));
        int delete = instance.delete(fournisseur);
        assertTrue("élément supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class FournisseurEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Fournisseur result = instance.create(fournisseur);
        assertTrue("Fournisseur créé", result.getId()!=0);
        List<Fournisseur> fournisseurs = instance.findAll();
        assertTrue("Les éléments ont été retrouvé", !fournisseurs.isEmpty());
        int delete = instance.delete(fournisseur);
        assertTrue("Fournisseur supprimé", delete!=0);
    }
}