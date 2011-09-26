package edu.chl.jesjos.jpa.core;

import edu.chl.jesjos.jpa.core.Address;
import edu.chl.jesjos.jpa.core.PurchaseOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated("EclipseLink - Mon Sep 26 15:27:03 CEST 2011")
@StaticMetamodel(Customer.class)
public class Customer_ { 

	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, String> lname;
	public static volatile SingularAttribute<Customer, String> email;
	public static volatile SingularAttribute<Customer, Address> address;
	public static volatile SingularAttribute<Customer, String> fname;
	public static volatile ListAttribute<Customer, PurchaseOrder> purchaseOrders;

}