/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author jesper
 */
@ManagedBean
@RequestScoped
public class AddProductControllerBean {
    @ManagedProperty(value="#{addProductRequestBean}")
    private AddProductRequestBean request;
    @ManagedProperty(value="#{db}")
    private ProductPersistBean db;
    @ManagedProperty(value="#{pdb}")
    private ProductFacade pdb;
    /** Creates a new instance of AddProductControllerBean */
    public AddProductControllerBean() {
    }
    
    public String addProduct() {
        String name = getRequest().getName();
        String category = getRequest().getCategory();
        Double price = Double.valueOf(getRequest().getPrice());
        Product p = new Product();
        p.setCategory(category);
        p.setName(name);
        p.setPrice(price);
        getPdb().create(p);
//        getDb().getProductController().create(p);
        return "onAddProduct";
    }

    /**
     * @return the request
     */
    public AddProductRequestBean getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(AddProductRequestBean request) {
        this.request = request;
    }

    /**
     * @return the db
     */
    public ProductPersistBean getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(ProductPersistBean db) {
        this.db = db;
    }

    /**
     * @return the sdb
     */
    public ProductFacade getPdb() {
        return pdb;
    }

    /**
     * @param sdb the sdb to set
     */
    public void setPdb(ProductFacade pdb) {
        this.pdb = pdb;
    }


}
