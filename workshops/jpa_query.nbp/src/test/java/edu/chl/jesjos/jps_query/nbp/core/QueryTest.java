/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jps_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.PurchaseOrder;
import java.util.Collection;
import edu.chl.jesjos.jpa_query.nbp.core.Customer_;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;
import com.sun.xml.internal.ws.util.StringUtils;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import edu.chl.jesjos.jpa_query.nbp.core.Customer;
import edu.chl.jesjos.jpa_query.nbp.core.PurchaseOrder_;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
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
public class QueryTest {
    private static EntityManagerFactory mf;
    private static EntityManager m;   
    private CriteriaBuilder cb;
    private CriteriaQuery<Customer> qc;
    private Root<Customer> customer;
    
    public QueryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        mf = Persistence.createEntityManagerFactory("sample_pu");
        m = mf.createEntityManager();
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        cb = m.getCriteriaBuilder();
        qc = cb.createQuery(Customer.class);
        customer = qc.from(Customer.class);
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
    public void queryTest() {
        String getCustomer = "SELECT c FROM Customer c WHERE LOWER(c.name) LIKE :name";
        TypedQuery<Customer> getCustomerQuery = m.createQuery(getCustomer, Customer.class);
        getCustomerQuery.setParameter("name", "jumbo%");
        Customer c = getCustomerQuery.getSingleResult();
        System.out.println("Address of " + c.getName() + " is:\n" + 
                c.getAddressline1() + "\n" + c.getAddressline2()
                + "\n" + c.getCity());
        
        String getCustomersForCity = "SELECT c FROM Customer c WHERE LOWER(c.city)=:city";
        TypedQuery<Customer> getCustomersForCityQuery = m.createQuery(getCustomersForCity, Customer.class);
        getCustomersForCityQuery.setParameter("city", "New York".toLowerCase());
        List<Customer> customers = getCustomersForCityQuery.getResultList();
        System.out.println("\nCustomers in New York:" + customers.size());
        for (Customer x : customers) {
            System.out.println(x.getName());
        }
        
        String numberQuery = "SELECT p.customerId FROM PurchaseOrder p WHERE p.quantity > 250";
        TypedQuery<Customer> numberQ = m.createQuery(numberQuery, Customer.class);
        System.out.println("Customers with purchase orders with quantity over 250");
        for (Customer y : numberQ.getResultList()) {
            System.out.println(y.getName());
        }
        
        String averageQuery = "SELECT AVG(p.shippingCost) FROM PurchaseOrder p";
        TypedQuery<Double> avgQuery = m.createQuery(averageQuery, Double.class);
        Double apa = avgQuery.getSingleResult();
        System.out.println("Average shipping cost: " + apa);
    }
    
    @Test
    public void criteriaJumbo() {
        Path<String> name = customer.get(Customer_.name);
        Predicate nameEq = cb.like(name, "%umbo%");
        qc.where(nameEq);
        
        TypedQuery<Customer> q = m.createQuery(qc);
        Customer c = q.getSingleResult();
        
        System.out.println("\nCriteria says address for Jumbo:\n" + c.getAddressline1()
                + "\n" + c.getAddressline2() + "\n"
                + c.getCity() +"\n");        
    }
    
    @Test
    public void criteriaNY () {
        Path<String> city = customer.get(Customer_.city);
        Predicate cityEq = cb.like(cb.lower(city), "%new york%");
        qc.where(cityEq);
        
        TypedQuery<Customer> q = m.createQuery(qc);
        Collection<Customer> cs = q.getResultList();
        
        System.out.println("\nCriteria says the following customers are based in NY: ");
        for(Customer c : cs) {
            System.out.println(c.getName());
        }
    }
    
    @Test
    public void criteriaGT250Orders () {
        CriteriaQuery cquery = cb.createQuery(PurchaseOrder.class);
        Root<PurchaseOrder> po = cquery.from(PurchaseOrder.class);
        Path<Short> quantity = po.get(PurchaseOrder_.quantity);
        Predicate quantityGT = cb.gt(quantity, 250);
        
        cquery.where(quantityGT);
        cquery.select(po.get(PurchaseOrder_.customerId));
        TypedQuery<Customer> typedQuery = m.createQuery(cquery);
        
        Collection<Customer> customers = typedQuery.getResultList();
        
        System.out.println("\nCriteria says the following customers have "
                + "purchased more than 250 pieces of a single product");
        for(Customer c : customers) {
            System.out.println(c.getName());
        }
        
    }
    
    @Test
    public void criteriaAverageShippingCost () {
        CriteriaQuery cquery = cb.createQuery(PurchaseOrder.class);
        Root<PurchaseOrder> po = cquery.from(PurchaseOrder.class);
        Path<BigDecimal> shippingCost = po.get(PurchaseOrder_.shippingCost);
        cquery.select(cb.avg(shippingCost));
        
        TypedQuery<Double> typedQuery = m.createQuery(cquery);
        Double average = typedQuery.getSingleResult();
        
        System.out.println("\nCriteria says that the average shipping cost is: " + average);
        
    }
    
    
}
