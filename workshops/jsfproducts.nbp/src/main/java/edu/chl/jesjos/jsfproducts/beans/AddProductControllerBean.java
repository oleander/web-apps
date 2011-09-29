/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import javax.annotation.PostConstruct;
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
    private addProductRequestBean request;
    @ManagedProperty(value="#{db}")
    private ProductPersistBean db;
    /** Creates a new instance of AddProductControllerBean */
    public AddProductControllerBean() {
    }
    
    public String addProduct() {
        String name = request.getName();
        String category = request.getCategory();
        Double price = Double.valueOf(request.getPrice());
        Product p = new Product();
        db.getProductController().create(p);
        return "onAddProduct";
    }

    /**
     * @param request the request to set
     */
    public void setRequest(addProductRequestBean request) {
        this.request = request;
    }
    
    public ProductPersistBean getRequest() {
        return db;
    }

}
