/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.core;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author jesper
 */
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fname;
    private String lname;
    private String email;
    @Embedded
    private Address address;
    @OneToMany
    private List<PurchaseOrder> purchaseOrders;
    
    public Customer() {
        
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the purchaseOrders
     */
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    /**
     * @param purchaseOrders the purchaseOrders to set
     */
    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
    
    
    
}
