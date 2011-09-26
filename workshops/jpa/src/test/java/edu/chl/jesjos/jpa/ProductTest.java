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
    private static EntityManagerFactory mf;
    private static EntityManager m;
    private Product p;
    
    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        mf = Persistence.createEntityManagerFactory("webshop_pu");
        m = mf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        m.close();
        mf.close();
    }
    
    @Before
    public void setUp() {
        p = new Product();
        p.setCategory("Vehicles");
        p.setName("Car");
        p.setPrice(3000.0);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void crud() {
        try {
            m.getTransaction().begin();
            m.persist(p);
            m.getTransaction().commit();
        } catch(Exception e) {
            fail("Caught exception: " + e);
        }
        m.getTransaction().begin();
        p.setPrice(265.2);
        p.setName("Car");
        long id = (long) p.getId();
        m.getTransaction().commit();
        p = null;
        p = m.find(Product.class, id);
        System.out.println("After nulling" + p);
        m.getTransaction().begin();
        m.remove(p);
        m.getTransaction().commit();
        p = null;
        p = m.find(Product.class, id);
        if (p != null)
            fail("p should be null");
    }
}
