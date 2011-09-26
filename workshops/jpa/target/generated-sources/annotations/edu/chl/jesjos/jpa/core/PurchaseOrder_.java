package edu.chl.jesjos.jpa.core;

import edu.chl.jesjos.jpa.core.Customer;
import edu.chl.jesjos.jpa.core.OrderItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated("EclipseLink - Mon Sep 26 15:27:03 CEST 2011")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

	public static volatile SingularAttribute<PurchaseOrder, Long> id;
	public static volatile ListAttribute<PurchaseOrder, OrderItem> orderItems;
	public static volatile SingularAttribute<PurchaseOrder, Date> date;
	public static volatile SingularAttribute<PurchaseOrder, Customer> customer;

}