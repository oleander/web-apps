package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.Manufacturer;
import edu.chl.jesjos.jpa_query.nbp.core.ProductCode;
import edu.chl.jesjos.jpa_query.nbp.core.PurchaseOrder;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, BigDecimal> markup;
    public static volatile SingularAttribute<Product, Integer> quantityOnHand;
    public static volatile SingularAttribute<Product, Manufacturer> manufacturerId;
    public static volatile SingularAttribute<Product, ProductCode> productCode;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, BigDecimal> purchaseCost;
    public static volatile CollectionAttribute<Product, PurchaseOrder> purchaseOrderCollection;
    public static volatile SingularAttribute<Product, String> available;
    public static volatile SingularAttribute<Product, Integer> productId;

}