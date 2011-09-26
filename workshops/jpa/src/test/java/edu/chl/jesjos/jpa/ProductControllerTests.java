/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.db.Database;
import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
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
public class ProductControllerTests {
    IJpaCtrl<Product> ctrl;
    public ProductControllerTests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        ctrl = Database.getProductController();
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
    public void testCount() {
        Integer count = ctrl.getEntityCount();
        System.out.println("===========================> Count: " + count);
        assertTrue(count > 1);
    }
    
    @Test
    public void testMerge() {
        Product p = new Product();
        p.setCategory("Hej");
        p.setName("Before");
        p.setPrice(3000.0);
        
        ctrl.create(p);
        assertNotNull(p.getId());
        Long id = p.getId();
        
        Product p2 = new Product(id, "After", "Hej2", 2000.0);
        try {
            ctrl.edit(p2);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProductControllerTests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductControllerTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Product p3 = ctrl.findEntity(id);
        
        assertEquals("After", p3.getName());
        
        
        
    }
}
