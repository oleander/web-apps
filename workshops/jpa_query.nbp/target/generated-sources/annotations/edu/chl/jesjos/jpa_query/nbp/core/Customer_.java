package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.DiscountCode;
import edu.chl.jesjos.jpa_query.nbp.core.MicroMarket;
import edu.chl.jesjos.jpa_query.nbp.core.PurchaseOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, MicroMarket> zip;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> fax;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile SingularAttribute<Customer, Integer> creditLimit;
    public static volatile CollectionAttribute<Customer, PurchaseOrder> purchaseOrderCollection;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, String> addressline2;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, String> addressline1;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, DiscountCode> discountCode;

}