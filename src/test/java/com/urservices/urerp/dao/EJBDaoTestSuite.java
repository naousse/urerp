/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.dao;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.metier.AchatEJBMetierTest;
import com.urservices.urerp.metier.CEntrepriseEJBMetierTest;
import com.urservices.urerp.metier.EmployeEJBMetierTest;
import com.urservices.urerp.metier.FactureEJBMetierTest;
import com.urservices.urerp.metier.FonctionEJBMetierTest;
import com.urservices.urerp.metier.FournisseurEJBMetierTest;
import com.urservices.urerp.metier.LigneOperationEJBMetierTest;
import com.urservices.urerp.metier.LivraisonEJBMetierTest;
import com.urservices.urerp.metier.ModePaiementEJBMetierTest;
import com.urservices.urerp.metier.PaiementEJBMetierTest;
import com.urservices.urerp.metier.PeriodeEJBMetierTest;
import com.urservices.urerp.metier.PerteEJBMetierTest;
import com.urservices.urerp.metier.ProduitEJBMetierTest;
import com.urservices.urerp.metier.ProduitManquantsEJBMetierTest;
import com.urservices.urerp.metier.StockEJBMetierTest;
import com.urservices.urerp.metier.VenteEJBMetierTest;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author samuel
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ModePaiementEJBDaoTest.class, FonctionEJBDaoTest.class, EmployeEJBDaoTest.class, ProduitEJBDaoTest.class,
PaiementEJBDaoTest.class, StockEJBDaoTest.class, AchatEJBDaoTest.class, FonctionEJBMetierTest.class, CEntrepriseEJBDaoTest.class
,FournisseurEJBDaoTest.class, PeriodeEJBDaoTest.class, LigneOperationEJBDaoTest.class, CPhysiqueEJBDaoTest.class, FactureEJBDaoTest.class, 
 AchatEJBMetierTest.class, LivraisonEJBDaoTest.class, PerteEJBDaoTest.class, VenteEJBDaoTest.class, CEntrepriseEJBMetierTest.class, 
    EmployeEJBMetierTest.class, FactureEJBMetierTest.class, FournisseurEJBMetierTest.class, LigneOperationEJBMetierTest.class, LivraisonEJBMetierTest.class,
    ModePaiementEJBMetierTest.class, PaiementEJBMetierTest.class, PeriodeEJBMetierTest.class, PerteEJBMetierTest.class, ProduitEJBMetierTest.class, 
    ProduitManquantsEJBMetierTest.class, StockEJBMetierTest.class, VenteEJBMetierTest.class})
public class EJBDaoTestSuite {

    public static EJBContainer container = EJBContainer.createEJBContainer();
    public static Context context = container.getContext();
    public static Employe employe = null;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        container.close();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public static EJBContainer getContainer() {
        return container;
    }

    public static Context getContext() {
        return context;
    }
    
}