package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(ProductCode.class)
public class ProductCode_ { 

    public static volatile SingularAttribute<ProductCode, String> description;
    public static volatile SingularAttribute<ProductCode, String> prodCode;
    public static volatile CollectionAttribute<ProductCode, Product> productCollection;
    public static volatile SingularAttribute<ProductCode, Character> discountCode;

}