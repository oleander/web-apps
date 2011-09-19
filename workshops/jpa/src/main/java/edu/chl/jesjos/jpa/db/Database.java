/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.db;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.IJpaCtrl;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A locator for JPA controllers and others...
 * 
 * @author hajo
 */
public final class Database {

    private static final EntityManagerFactory emf =
           Persistence.createEntityManagerFactory("webshop_pu");
    //private static final IJpaCtrl productCtrl = new ProductJpaCtrl(null, emf); 
           // new ProductJpaDummyCtrl();
    
    private Database() {
    }
    
    public static IJpaCtrl<Product> getProductController() {
        return null; //productCtrl;
    }
}
