/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Address;
import edu.chl.jesjos.jpa.core.PurchaseOrder;
import edu.chl.jesjos.jpa.core.OrderItem;
import edu.chl.jesjos.jpa.core.Customer;
import edu.chl.jesjos.jpa.core.Product;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jesper
 */
public class CustomerTest {
    
    private static EntityManagerFactory mf;
    private static EntityManager m;
    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        mf = Persistence.createEntityManagerFactory("webshop_pu");
        m = mf.createEntityManager();
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
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
    public void graphTest() {
        Customer c = new Customer();
        PurchaseOrder p = new PurchaseOrder();
        OrderItem item1 = new OrderItem();
        OrderItem item2 = new OrderItem();
        Product p1 = new Product();
        Product p2 = new Product();
        
        c.setAddress(new Address("Akervagen 4", "Mariehamn", "Finland"));
        c.setFname("Jesper");
        c.setLname("Josefsson");
        
        p.setCustomer(c);
        Calendar cal = Calendar.getInstance();
        p.setDate(cal.getTime());
        
        p1.setName("Car");
        p1.setPrice(3000.0);
        
        p2.setName("Motorcycle");
        p2.setPrice(300.0);
        
        item1.setProduct(p1);
        item1.setQuantity(3);
        
        item2.setProduct(p2);
        item2.setQuantity(5);
        
        p.addOrderItem(item1);
        p.addOrderItem(item2);
        
        c.addPurchaseOrder(p);
        
        m.getTransaction().begin();
        
        m.persist(c);
        m.persist(p1);
        m.persist(p2);
        
        m.getTransaction().commit();
        
        Customer ca = m.find(Customer.class, c.getId());
        
        System.out.println("Customer after fetch: " + ca);
        System.out.println("Purchase order: " + ca.getPurchaseOrders().get(0));
        
        assertEquals(c, ca);
        assertEquals(c.getPurchaseOrders(), ca.getPurchaseOrders());
        
        m.detach(c);
        
        c.setFname("Apabepa");
        
        ca = m.find(Customer.class, c.getId());
        
        System.out.println("This: " + !c.equals(ca));
        assertTrue(!c.equals(ca));
    }
}
