package edu.chl.jesjos.jpa_query.nbp.core;

import edu.chl.jesjos.jpa_query.nbp.core.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-23T17:02:34")
@StaticMetamodel(Manufacturer.class)
public class Manufacturer_ { 

    public static volatile SingularAttribute<Manufacturer, String> addressline2;
    public static volatile SingularAttribute<Manufacturer, String> zip;
    public static volatile SingularAttribute<Manufacturer, String> phone;
    public static volatile SingularAttribute<Manufacturer, String> addressline1;
    public static volatile SingularAttribute<Manufacturer, String> fax;
    public static volatile SingularAttribute<Manufacturer, Integer> manufacturerId;
    public static volatile SingularAttribute<Manufacturer, String> email;
    public static volatile SingularAttribute<Manufacturer, String> name;
    public static volatile SingularAttribute<Manufacturer, String> state;
    public static volatile CollectionAttribute<Manufacturer, Product> productCollection;
    public static volatile SingularAttribute<Manufacturer, String> rep;
    public static volatile SingularAttribute<Manufacturer, String> city;

}