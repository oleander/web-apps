/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jaxb;

import javax.xml.bind.annotation.*;

/**
 * Immutable !!
 * @author hajo
 */

@XmlRootElement
public class Customer {

    @XmlElement
    private long id;
    @XmlElement
    private String fname;
    @XmlElement
    private String lname;
    @XmlElement
    private int age;
    @XmlElement
    private String address;
    @XmlElement
    private String email;

    public Customer() {
    }

    public Customer(long id, String fname, String lname, int age, String address, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public long getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }
}
