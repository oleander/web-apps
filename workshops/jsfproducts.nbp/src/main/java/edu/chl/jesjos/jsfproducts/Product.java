/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author jesper
 */
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable=false)
    private String name;
    private String category;
    @Column(nullable=false)
    private Double price;

    public Product() {
    }
    
    public Product(long id, String name, String cat, Double price) {
        this.id = id;
        this.name = name;
        this.category = cat;
        this.price = price;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product other = (Product) o;
            return
                    this.getName().equals(other.getName()) && this.getPrice() == other.getPrice();
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 29 * hash + (this.price != null ? this.price.hashCode() : 0);
        return hash;
    }
    
    
    
    @Override
    public String toString() {
        return "Product: " + this.name + "(" + this.id + ")" + "\n" 
                + "price: " + this.price + "\n"
                + "category: " + this.category;
    }
}
