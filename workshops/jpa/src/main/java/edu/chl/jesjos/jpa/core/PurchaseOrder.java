/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.core;

import java.io.Serializable;
import java.util.Date;
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
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public PurchaseOrder() {
        
    }
    
}
