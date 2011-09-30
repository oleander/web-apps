/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesper
 */
@ManagedBean
@RequestScoped
public class ViewCartControllerBean {
    @ManagedProperty(value="#{cartSessionBean}")
    private CartSessionBean cart;
    /** Creates a new instance of ViewCartControllerBean */
    public ViewCartControllerBean() {
    }
    
    public String emptyCart() {
        getCart().emptyCart();
        HttpSession session = 
                (HttpSession) 
                FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(true);
        session.invalidate();
        return "onViewProducts";
        
    }

    /**
     * @return the cart
     */
    public CartSessionBean getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(CartSessionBean cart) {
        this.cart = cart;
    }
}
