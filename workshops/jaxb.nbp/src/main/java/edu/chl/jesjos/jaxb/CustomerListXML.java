/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Marshalling to XML
 * @author hajo
 */
public class CustomerListXML {

    public static void marshal(CustomerList c) throws JAXBException {
       JAXBContext jc;
       jc = JAXBContext.newInstance(CustomerList.class);
       Marshaller m = jc.createMarshaller();
       m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
        // Dump XML data
       m.marshal(c, System.out);
    }
    
    /*
    public static void marshal(CustomerList c) throws JAXBException {
        // TODO
    }*/
}
