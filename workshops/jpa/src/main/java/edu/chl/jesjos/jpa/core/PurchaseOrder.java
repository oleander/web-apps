/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jesper
 */
@Entity
public class PurchaseOrder implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="ORDER_DATE")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    
    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderItem> orderItems;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public PurchaseOrder() {
        this.orderItems = new ArrayList<OrderItem>();
    }
    
    public PurchaseOrder(Date date, Customer customer, List<OrderItem> orderItems) {
        this.date = date;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the orderItems
     */
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public void addOrderItem(OrderItem i) {
        this.orderItems.add(i);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PurchaseOrder) {
            PurchaseOrder other = (PurchaseOrder) o;
            return this.customer == other.customer 
                    && this.orderItems.equals(other.orderItems)
                    && this.date.equals(other.date);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.date != null ? this.date.hashCode() : 0);
        hash = 47 * hash + (this.customer != null ? this.customer.hashCode() : 0);
        hash = 47 * hash + (this.orderItems != null ? this.orderItems.hashCode() : 0);
        return hash;
    }
    
    
    
    
    @Override
    public String toString() {
        String output = "Purchase Order - Customer: " + customer.getFname()
                + " " + customer.getLname() + " Date: " + date
                + " Items: ";
        for (OrderItem i : orderItems) {
            output += "\n" + i.toString();
        }
        return output;
    }
    
}
