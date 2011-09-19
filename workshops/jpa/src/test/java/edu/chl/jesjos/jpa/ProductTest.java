/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import edu.chl.jesjos.jpa.core.Product;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author jesper
 */
public class ProductTest {
    private EntityManagerFactory mf;
    private EntityManager m;
    
    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        mf = Persistence.createEntityManagerFactory("webshop_test_pu");
        m = mf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        m.close();
        mf.close();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test1() {
        Product p = new Product();
        p.setId(3000);
        try {
        m.getTransaction().begin();
        m.persist(p);
        m.getTransaction().commit();
        } catch(Exception e) {
            fail("Caught exception: " + e);
        }
        
    }
}
