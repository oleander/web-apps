package edu.chl.jesjos.jsfproducts;

import edu.chl.jesjos.jsfproducts.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-30T13:07:47")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Long> id;
    public static volatile SingularAttribute<OrderItem, Product> product;
    public static volatile SingularAttribute<OrderItem, Integer> quantity;

}