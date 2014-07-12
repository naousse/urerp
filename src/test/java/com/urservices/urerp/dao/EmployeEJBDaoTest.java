/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Adresse;
import com.urservices.urerp.entities.Employe;
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
public class EmployeEJBDaoTest {
    
    private static Context context;
    private Employe employe = new Employe(0L, "1889087", "samuel", "pro", new Adresse(79330469L, "gdvckdcvhdcjd", "dhgddh"));
    private Employe employePersistent = new Employe(0L, "452672", "folong", "sam", new Adresse(94303836L, "djcgdcdkjch", "jdchdhc"));
    private Long id;
    private static IEmployeEJBDaoLocal instance = null;
    
    public EmployeEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        
        context = EJBDaoTestSuite.context;
        instance = (IEmployeEJBDaoLocal)context.lookup("java:global/classes/EmployeEJBDao!com.urservices.urerp.dao.IEmployeEJBDaoLocal");
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
     * Test of create method, of class EmployeEJBDao.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Employe result = instance.create(employe);
        id = result.getId();
        assertTrue("Employe créé", id!=0);
        System.out.println(" Result Id " + result.getId());
        int delete = instance.delete(employe);
        assertTrue("L'employé a bien été créé ", delete!=0);
    }

    /**
     * Test of update method, of class EmployeEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(employePersistent);
        employePersistent.setNom("Kamdoum");
        Employe result = instance.update(employePersistent);
        assertTrue("L'employé a été modifié", result.getNom().equals(employePersistent.getNom()));
        System.out.println("Result Id "+result.getId());
        System.out.println("Fonction Id "+employePersistent.getId());
        employe = result;
    }

    /**
     * Test of delete method, of class EmployeEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("findById");
        Employe result = instance.create(employe);
        id = result.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        result = instance.findById(employe.getId());
        assertTrue("La fonction a bien été trouvé", result.getNom().equals("samuel"));
        int delete = instance.delete(employe);
        assertTrue("La fonction a été Fonction crée", delete!=0);
    }

    /**
     * Test of findById method, of class EmployeEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findAll");
        Employe result = instance.create(employe);
        id = result.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        List<Employe> employes = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !employes.isEmpty());
        int nbDeLignesAffectées = instance.delete(employe);
        assertTrue("La fonction a été Fonction crée", nbDeLignesAffectées!=0);
    }

    /**
     * Test of findAll method, of class EmployeEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("delete");
        Employe result = instance.create(employe);
        id = result.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        int nbDeLignesAffectées = instance.delete(employe);
        assertTrue("La fonction a bien été supprimée", nbDeLignesAffectées!=0);
    }
}