/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.core;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author jesper
 */
@Embeddable
public class Address implements Serializable {
    private String street, city, country;
    
    public Address () {
        
    }
    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
