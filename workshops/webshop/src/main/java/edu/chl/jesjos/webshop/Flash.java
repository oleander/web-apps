/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.webshop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesper
 */
public class Flash {
    private String message;

    public String getMessage() {
        String output = message;
        message = null;
        return output;
    }
    
    public boolean isSet(){
        return message != null;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Flash() {
        message = null;
    }
    
    public Flash(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
    
    public static void setFlash(String message, HttpSession session) {
        Flash flash = (Flash) session.getAttribute(Constants.FLASH);
        if (flash == null) {
            session.setAttribute(Constants.FLASH,new Flash(message));

        } else {
            flash.setMessage(message);
        }
    }
}
