package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.Customer;
import edu.chl.jesjos.jpa_query.nbp.core.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, Customer> customerId;
    public static volatile SingularAttribute<PurchaseOrder, Date> salesDate;
    public static volatile SingularAttribute<PurchaseOrder, Integer> orderNum;
    public static volatile SingularAttribute<PurchaseOrder, BigDecimal> shippingCost;
    public static volatile SingularAttribute<PurchaseOrder, Short> quantity;
    public static volatile SingularAttribute<PurchaseOrder, Date> shippingDate;
    public static volatile SingularAttribute<PurchaseOrder, String> freightCompany;
    public static volatile SingularAttribute<PurchaseOrder, Product> productId;

}