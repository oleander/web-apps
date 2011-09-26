package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.Customer;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(DiscountCode.class)
public class DiscountCode_ { 

    public static volatile SingularAttribute<DiscountCode, BigDecimal> rate;
    public static volatile CollectionAttribute<DiscountCode, Customer> customerCollection;
    public static volatile SingularAttribute<DiscountCode, Character> discountCode;

}