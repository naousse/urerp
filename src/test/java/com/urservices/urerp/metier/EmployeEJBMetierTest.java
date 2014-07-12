/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
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
public class EmployeEJBMetierTest {
    
    private static Context context;
    private Employe employe = new Employe(0L, "679876780L", "samy", "sam", new Adresse(3243262L, "samuel@yahoo.fr", "BP 12"));
    private Long id;
    private static IEmployeEJBMetierLocal instance = null;
    
    public EmployeEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test EJB Metier Employé");
        
        context = EJBDaoTestSuite.context;
        instance = (IEmployeEJBMetierLocal)context.lookup("java:global/classes/EmployeEJBMetier!com.urservices.urerp.metier.IEmployeEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test EJB Metier Employé");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class EmployeEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Employe result = instance.create(employe);
        assertTrue("Employé créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(employe);
        assertTrue("Employé supprimé", delete!=0);
    }

    /**
     * Test of update method, of class EmployeEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Employe result = instance.create(employe);
        result.setNom("Charly");
        Employe results = instance.update(result);
        assertTrue("Employé modifié", result.getNom().equals(results.getNom()));
        System.out.println("Result Id " + result.getId());
        System.out.println("Employé Id " + results.getId());
        employe = results;
    }

    /**
     * Test of delete method, of class EmployeEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Employe result = instance.create(employe);
        assertTrue("Employé créé", result.getId()!=0);
        int delete = instance.delete(employe);
        assertTrue("Employé supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class EmployeEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Employe result = instance.create(employe);
        assertTrue("Employé créé", result.getId()!=0);
        List<Employe> results = instance.findAll();
        assertTrue("Les éléments ont été retrouvé", !results.isEmpty());
        int delete = instance.delete(employe);
        assertTrue("Employé supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class EmployeEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Employe result = instance.create(employe);
        assertTrue("Employé créé", result.getId()!=0);
        Employe employes = instance.findById(result.getId());
        assertTrue("élément retrouvé", employes.getId()!=0);
        int delete = instance.delete(employe);
        assertTrue("élément supprimé", delete!=0);
    }
}