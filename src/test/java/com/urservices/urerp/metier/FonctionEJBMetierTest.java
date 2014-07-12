/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Fonction;
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
public class FonctionEJBMetierTest {
    
    private static Context context;
    private Fonction fonction = new Fonction(0L,"Laveur");
    private Long id;
    private static IFonctionEJBMetierLocal instance = null;
    
    
    public FonctionEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("EJB Metier Fonction Debut des tests");
        
         context = EJBDaoTestSuite.context;
        instance = (IFonctionEJBMetierLocal)context.lookup("java:global/classes/FonctionEJBMetier!com.urservices.urerp.metier.IFonctionEJBMetierLocal");

    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("EJB Metier Fonction Fin des tests");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class FonctionEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Fonction result = instance.create(fonction);
        id = result.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        System.out.println("Result Id "+result.getId());
        int delete = instance.delete(fonction);
        assertTrue("La fonction a été Fonction crée", delete!=0);
    }

    /**
     * Test of update method, of class FonctionEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Fonction result = instance.create(fonction);
        result.setLibelle("Livreur");
        Fonction fonctions = instance.update(fonction);
        assertTrue("Fonction modifiée", fonctions.getId()!=0);
        System.out.println("Result Id "+result.getId());
        System.out.println("Fonction Id "+fonctions.getId());
        fonction = fonctions;
    }

    /**
     * Test of delete method, of class FonctionEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Fonction result = instance.create(fonction);
        id = result.getId();
        assertTrue("Fonction créée", id!=0);
        int delete = instance.delete(fonction);
        assertTrue("Fonction supprimée", delete!=0);
    }

    /**
     * Test of findById method, of class FonctionEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Fonction result = instance.create(fonction);
        id = result.getId();
        assertTrue("Fonction créée", id!=0);
        Fonction fonction2 = instance.findById(id);
        assertTrue("La Fonction a été retrouvée", fonction2.getLibelle().equals("Laveur"));
        int delete = instance.delete(fonction);
        assertTrue("Fonction supprimée", delete!=0);
    }

    /**
     * Test of findAll method, of class FonctionEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Fonction result = instance.create(fonction);
        id = result.getId();
        assertTrue("Fonction créée", id!=0);
        List<Fonction> fonctions = instance.findAll();
        assertTrue("Les fonctions ont été retrouvée", !fonctions.isEmpty());
        int delete = instance.delete(fonction);
        assertTrue("Les éléments ont été supprimée", delete!=0);
    }
}