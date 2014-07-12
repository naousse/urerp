/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

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
public class FonctionEJBDaoTest {
    
   
    private static Context context;
    private Fonction fonction = new Fonction(0L,"Directeur");
    private Fonction fonctionPersistent = new Fonction(0L,"Réceptioniste");
    private Long id;
    private static IFonctionEJBDaoLocal instance = null;
    
    public FonctionEJBDaoTest() throws NamingException {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
       
        context = EJBDaoTestSuite.context;
        instance = (IFonctionEJBDaoLocal)context.lookup("java:global/classes/FonctionEJBDao!com.urservices.urerp.dao.IFonctionEJBDaoLocal");
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
     * Test of create method, of class FonctionEJBDao.
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
     * Test of update method, of class FonctionEJBDao.
     */
   @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(fonctionPersistent);
        fonctionPersistent.setLibelle("Boss");
        Fonction result = instance.update(fonctionPersistent);
        assertTrue("La fonction a été modifié", result.getLibelle().equals(fonctionPersistent.getLibelle()));
        System.out.println("Result Id "+result.getId());
        System.out.println("Fonction Id "+fonctionPersistent.getId());
        fonction = result;
    }


    /**
     * Test of findById method, of class FonctionEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Fonction resultCreation = instance.create(fonction);
        id = resultCreation.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        Fonction result = instance.findById(fonction.getId());
        assertTrue("La fonction a bien été trouvé", result.getLibelle().equals("Directeur"));
        int delete = instance.delete(fonction);
        assertTrue("La fonction a été Fonction crée", delete!=0);
    }

    /**
     * Test of findAll method, of class FonctionEJBDao.
     */
   @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Fonction resultCreation = instance.create(fonction);
        id = resultCreation.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        List<Fonction> result = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !result.isEmpty());
        int delete = instance.delete(fonction);
        assertTrue("La fonction a été Fonction crée", delete!=0);
        
    }
    
    /**
     * Test of delete method, of class FonctionEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Fonction resultCreation = instance.create(fonction);
        id = resultCreation.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        int result = instance.delete(fonction);
        assertTrue("La fonction a bien été supprimée", result!=0);
       
    }
}