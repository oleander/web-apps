package edu.chl.jesjos.jpa.core;

import edu.chl.jesjos.jpa.core.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated("EclipseLink - Mon Sep 19 10:54:04 CEST 2011")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

	public static volatile SingularAttribute<OrderItem, Long> id;
	public static volatile SingularAttribute<OrderItem, Product> product;
	public static volatile SingularAttribute<OrderItem, Integer> quantity;

}