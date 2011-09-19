package edu.chl.jesjos.jpa.core;

import edu.chl.jesjos.jpa.core.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated("EclipseLink - Mon Sep 19 10:54:04 CEST 2011")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

	public static volatile SingularAttribute<PurchaseOrder, Long> id;
	public static volatile SingularAttribute<PurchaseOrder, Date> date;
	public static volatile SingularAttribute<PurchaseOrder, Customer> customer;

}