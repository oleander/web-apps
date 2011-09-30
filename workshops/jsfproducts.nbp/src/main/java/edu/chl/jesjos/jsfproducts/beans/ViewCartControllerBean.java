/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.component.commandbutton.CommandButton;

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
    
    public void removeListener (ActionEvent e) {
        CommandButton b = (CommandButton) e.getSource();
        Product p = (Product) b.getAttributes().get("product");
        cart.removeProduct(p);
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
