/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import java.util.List;
import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.component.commandbutton.CommandButton;

/**
 *
 * @author jesper
 */
@ManagedBean
@RequestScoped
public class ViewProductsControllerBean {
    @ManagedProperty(value="#{cartSessionBean}")
    private CartSessionBean cart;
    @ManagedProperty(value="#{pdb}")
    private ProductFacade pdb;
    @ManagedProperty(value="#{viewProductsRequestBean}")
    private ViewProductsRequestBean view;
    
    /** Creates a new instance of ViewProductsControllerBean */
    public ViewProductsControllerBean() {
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
        return "onEmptyCart";
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
    
    public void deleteListener(ActionEvent e) {
        CommandButton button = (CommandButton) e.getSource();
        long id = Long.valueOf((Long) button.getAttributes().get("productId"));
        Product p = new Product();
        p.setId(id);
        getPdb().delete(p);
        List<Product> ps = pdb.getAll();
        view.setProducts(ps);
    }
    
    public void addToCartListener(ActionEvent e) {
        CommandButton button = (CommandButton) e.getSource();
        long id = (Long) button.getAttributes().get("productId");
        Product p = getPdb().findById(id);
        cart.addProduct(p);
    }
    
    /**
     * @return the pdb
     */
    public ProductFacade getPdb() {
        return pdb;
    }

    /**
     * @param pdb the pdb to set
     */
    public void setPdb(ProductFacade pdb) {
        this.pdb = pdb;
    }

    /**
     * @return the view
     */
    public ViewProductsRequestBean getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ViewProductsRequestBean view) {
        this.view = view;
    }
    
}
