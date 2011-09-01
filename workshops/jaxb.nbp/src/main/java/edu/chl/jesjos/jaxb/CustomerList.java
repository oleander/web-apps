/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesper
 */
@XmlRootElement
public class CustomerList {
    private List<Customer> customers;
    private int id;
    
    public CustomerList() {
        
    }
    public CustomerList(int id,List<Customer> list) {
        this.id = id;
        customers = list;
    }
    @XmlElement (name="customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    @XmlElement
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
