/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.EJBDaoTestSuite;
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
public class ModePaiementEJBMetierTest {
    
    private static Context context;
    private ModePaiement modePaiement = new ModePaiement(0L, TypePaiement.paiementCasch);
    private Long id;
    private static IModePaiementEJBMetierLocal instance = null;
    
    public ModePaiementEJBMetierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        System.out.println("Debut test Mode Paiement EJB Metier");
        
        context = EJBDaoTestSuite.context;
        instance = (IModePaiementEJBMetierLocal)context.lookup("java:global/classes/ModePaiementEJBMetier!com.urservices.urerp.metier.IModePaiementEJBMetierLocal");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin test Mode Paiement EJB Metier");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ModePaiementEJBMetier.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ModePaiement result = instance.create(modePaiement);
        assertTrue("Mode paiement créé", result.getId()!=0);
        System.out.println("Result Id " + result.getId());
        int delete = instance.delete(modePaiement);
        assertTrue("Mode paiement supprimé", delete!=0);
    }

    /**
     * Test of update method, of class ModePaiementEJBMetier.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        ModePaiement result = instance.create(modePaiement);
        result.setTypePaiement(TypePaiement.paiementPartiel);
        ModePaiement results = instance.update(result);
        assertTrue("Mode paiement modifié", results.getId()!=0);
        System.out.println("Result Id " + result.getId());
        System.out.println("Mode Paiement Id " + results.getId());
        modePaiement = results;
    }

    /**
     * Test of delete method, of class ModePaiementEJBMetier.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ModePaiement result = instance.create(modePaiement);
        assertTrue("Mode paiement créé", result.getId()!=0);
        int delete = instance.delete(modePaiement);
        assertTrue("Mode paiement supprimé", delete!=0);
    }

    /**
     * Test of findById method, of class ModePaiementEJBMetier.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        ModePaiement result = instance.create(modePaiement);
        assertTrue("Mode paiement créé", result.getId()!=0);
        ModePaiement results = instance.findById(result.getId());
        assertTrue("élément retrouvé", results.getTypePaiement().equals(TypePaiement.paiementCasch));
        int delete = instance.delete(modePaiement);
        assertTrue("Mode paiement supprimé", delete!=0);
    }

    /**
     * Test of findAll method, of class ModePaiementEJBMetier.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ModePaiement result = instance.create(modePaiement);
        assertTrue("Mode paiement créé", result.getId()!=0);
        List<ModePaiement> modePaiements = instance.findAll();
        assertTrue("Des éléments ont été retrouvé", !modePaiements.isEmpty());
        int delete = instance.delete(modePaiement);
        assertTrue("Des éléments ont été supprimé", delete!=0);
    }
}