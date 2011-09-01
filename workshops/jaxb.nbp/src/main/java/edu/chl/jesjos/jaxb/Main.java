package edu.chl.jesjos.jaxb;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *  Java to/from XML (possible using a schema)
 *
 */
public class Main{
    public static void main( String[] args ){
        try {
            
            CustomerXML.marshal(new Customer(1, "qqq", "www", 111, "rrr", "ttt"));
            
            List<Customer> cs = new ArrayList<Customer>();
            for (int i = 0; i < 10; i++) {
                cs.add(new Customer(i,"qqq","www",i*4,"rrr","ttt"));
            }
            CustomerListXML.marshal(new CustomerList(1,cs));
            
            
           // CustomerXML.marshal(new CustomerList());
            
            
          /*  
                   UNCOMMENT HERE for Advanced converions!!
             
            System.out.println("*** Whatch output tab ***");
            System.out.println("*** NOTE: See script xcj.sh ***");
            PurchaseOrderXML.marshal();
            PurchaseOrderXML.unmarshal();
            */ 
        //} catch (SAXException ex) {
        //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        //} catch (DatatypeConfigurationException ex) {
        //    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
