/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;


import com.urservices.urerp.entities.ModePaiement;
import com.urservices.urerp.entities.TypePaiement;
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
public class ModePaiementEJBDaoTest {
    
    private static Context context;
    private ModePaiement modePaiement = new ModePaiement(0L, TypePaiement.paiementCasch);
    private ModePaiement modePaiementPersistent = new ModePaiement(0L, TypePaiement.paiementCasch);
    private Long id;
    private static IModePaiementEJBDaoLocal instance = null;
    
    public ModePaiementEJBDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
       context = EJBDaoTestSuite.context;
       instance = (IModePaiementEJBDaoLocal)context.lookup("java:global/classes/ModePaiementEJBDao!com.urservices.urerp.dao.IModePaiementEJBDaoLocal");
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
     * Test of create method, of class ModePaiementEJBDao.
     */
   
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ModePaiement result = instance.create(modePaiement);
        id = result.getId();
        assertTrue("Mode de paiement créé", id!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(modePaiement);
        assertTrue("Mode de paiement supprimé ", delete!=0);
    }

    /**
     * Test of update method, of class ModePaiementEJBDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        instance.create(modePaiementPersistent);
        modePaiementPersistent.setTypePaiement(TypePaiement.paiementPartiel);
        ModePaiement result = instance.update(modePaiementPersistent);
        assertTrue("Le mode de paiement a été modifié", result.getTypePaiement().equals(modePaiementPersistent.getTypePaiement()));
        System.out.println("Result Id "+result.getId());
        System.out.println("Mode de paiement Id "+modePaiementPersistent.getId());
        modePaiement = result;
    }

    /**
     * Test of delete method, of class ModePaiementEJBDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ModePaiement result = instance.create(modePaiement);
        id = result.getId();
        assertTrue("Nouveau mode de paiement crée", id!=0);
        int results = instance.delete(modePaiement);
        assertTrue("Le mode de paiement a bien été supprimé", results!=0);
    }

    /**
     * Test of findById method, of class ModePaiementEJBDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        ModePaiement result = instance.create(modePaiement);
        id = result.getId();
        assertTrue("Nouveau mode de paiement crée", id!=0);
        ModePaiement results = instance.findById(modePaiement.getId());
        assertTrue("Le mode de paiement a bien été trouvé", result.getId()!=0);
        int delete = instance.delete(modePaiement);
        assertTrue("Le mode de paiement a été supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class ModePaiementEJBDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ModePaiement result = instance.create(modePaiement);
        id = result.getId();
        assertTrue("Nouvelle Fonction crée", id!=0);
        List<ModePaiement> results = instance.findAll();
        assertTrue("Des éléments ont bien été retourné", !results.isEmpty());
        int delete = instance.delete(modePaiement);
        assertTrue("Le mode de paiement a été crée", delete!=0);
    }
}