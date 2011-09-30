/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.IJpaCtrl;
import edu.chl.jesjos.jsfproducts.Product;
import edu.chl.jesjos.jsfproducts.ProductJpaCtrl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author jesper
 */
@ManagedBean(name="db")
@ApplicationScoped
public class ProductPersistBean implements Serializable {
    private IJpaCtrl<Product> prodctrl;
    @PersistenceUnit(name="jsf_pu")
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    /** Creates a new instance of ProductPersistBean */
    public ProductPersistBean() {
    }
    
    @PostConstruct
    private void init() {
        this.prodctrl = new ProductJpaCtrl(utx, emf);
    }
    
    public IJpaCtrl<Product> getProductController() {
        return prodctrl;
    }
    
    public List<Product> getProducts() {
        return prodctrl.findEntities();
    }
}
