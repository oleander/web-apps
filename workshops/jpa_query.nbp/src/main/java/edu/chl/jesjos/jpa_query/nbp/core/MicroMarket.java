/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa_query.nbp.core;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jesper
 */
@Entity
@Table(name = "MICRO_MARKET")
@NamedQueries({
    @NamedQuery(name = "MicroMarket.findAll", query = "SELECT m FROM MicroMarket m")})
public class MicroMarket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ZIP_CODE")
    private String zipCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RADIUS")
    private Double radius;
    @Column(name = "AREA_LENGTH")
    private Double areaLength;
    @Column(name = "AREA_WIDTH")
    private Double areaWidth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zip")
    private Collection<Customer> customerCollection;

    public MicroMarket() {
    }

    public MicroMarket(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipCode != null ? zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MicroMarket)) {
            return false;
        }
        MicroMarket other = (MicroMarket) object;
        if ((this.zipCode == null && other.zipCode != null) || (this.zipCode != null && !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.chl.jesjos.jpa_query.nbp.core.MicroMarket[ zipCode=" + zipCode + " ]";
    }
    
}
