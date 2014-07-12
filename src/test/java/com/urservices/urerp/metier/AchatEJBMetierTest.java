/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
import com.urservices.urerp.entities.Achat;
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
public class AchatEJBMetierTest {
    
    private static Context context;
    private Achat achat = new Achat(0L, "1712L", new Date());
    private Long id;
    private static IAchatEJBMetierLocal instance = null;
    
    public AchatEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IAchatEJBMetierLocal)context.lookup("java:global/classes/AchatEJBMetier!com.urservices.urerp.metier.IAchatEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class AchatEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("Achat créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(achat);
        assertTrue("Achat supprimé", delete!=0);
    }

    /**
     * Test of update method, of class AchatEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Achat resultCreate = instance.create(achat);
        resultCreate.setNumero("45L");
        Achat result = instance.update(resultCreate);
        assertTrue("Achat modifié", result.getNumero().equals(resultCreate.getNumero()));
        System.out.println("Result Id "+resultCreate.getId());
        System.out.println("Achat Id "+result.getId());
        achat = result;
    }

    /**
     * Test of delete method, of class AchatEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("Achat créé", id!=0);
        int delete = instance.delete(achat);
        assertTrue("Achat supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class AchatEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Achat resultCreate = instance.create(achat);
        id = resultCreate.getId();
        assertTrue("Achat créé", id!=0);
        Achat result = instance.findById(id);
        assertTrue("Achat trouvé", result.getId()!=0);
        int delete = instance.delete(achat);
        assertTrue("Achat supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class AchatEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Achat result = instance.create(achat);
        id = result.getId();
        assertTrue("Achat créé", id!=0);
        List<Achat> achats = instance.findAll();
        assertTrue("Les éléments ont été retrouvé", !achats.isEmpty());
        int delete = instance.delete(achat);
        assertTrue("Les éléments ont été supprimés", delete!=0);
    }
}