/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jesper
 */
@ManagedBean
@SessionScoped
public class CartSessionBean implements Serializable {
    private ArrayList<Product> products;
    /** Creates a new instance of cartSessionBean */
    public CartSessionBean() {
        products = new ArrayList<Product>();
    }
    
    public int getItemCount() {
        System.err.println("Getting item count: " + products.size());
        return products.size();
    }
    
    public void emptyCart() {
        products = new ArrayList<Product>();
    }
    
    public void addProduct(Product p) {
        products.add(p);
    }
    
    public boolean removeProduct(Product p) {
        return products.remove(p);
    }
}
