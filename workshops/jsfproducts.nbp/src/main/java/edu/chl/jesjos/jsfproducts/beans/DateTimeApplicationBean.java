/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author jesper
 */
@ManagedBean
@ApplicationScoped
public class DateTimeApplicationBean {
    Calendar cal;
    DateFormat df;
    /** Creates a new instance of DateTimeApplicationBean */
    public DateTimeApplicationBean() {
        cal = Calendar.getInstance();
        df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
    }
    
    public String getCurrentDateTime() {
        return df.format(cal.getTime());
    }
}
