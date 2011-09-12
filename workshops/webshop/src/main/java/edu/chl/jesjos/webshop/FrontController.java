/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.webshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesper
 */
public class FrontController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        String privatePath = "WEB-INF/jsp/";
        String[] actions = {"shop", "pay", "cart", "removeProduct", "addProduct", "confirm", "mail"};
        HttpSession session = request.getSession(true);
        ShoppingCart cart = (ShoppingCart) session.getAttribute(Constants.SHOPPINGCART);
        
        if (Arrays.asList(actions).contains(action)) {
            boolean redirect = false;
            if (action.equals("shop")) {
                session.setAttribute("products", Database.getProducts());
            } else if(action.equals(Constants.REMOVEPROD)) {
                cart.removeProduct(request.getParameter("name"));
                Flash.setFlash("Removed product", session);
                action = "cart";
                redirect = true;
            } else if(action.equals(Constants.ADDPROD)) {
                Product p = Database.getProduct(request.getParameter("name"));
                action = "shop";
                Flash.setFlash("Added product: " + p.getName(), session);
                cart.addProduct(p);
                redirect = true;
            } else if (action.equals(Constants.SHOPPINGCART)) {
                action = "viewCart";
            } else if (action.equals("mail")) {
                sendMail("jesper.josefsson@gmail.com", cart.toString());
                action = Constants.CONFIRM;
                redirect = true;
            }
            if (redirect)
                response.sendRedirect("FrontController?action=" + action);
            else
                request.getRequestDispatcher(privatePath + action + ".jspx").forward(request, response); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void sendMail(String recipient, String messageContent) {
      // Sender's email ID needs to be mentioned
      String from = "robject865@gmail.com";
 
      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";
 
      // Get system properties
      Properties properties = System.getProperties();
 
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      properties.setProperty("mail.smtp.port", "587");
      properties.setProperty("mail.smtp.auth", "true");
      properties.setProperty("mail.user", "robject865");
      properties.setProperty("mail.password", "596bdbab0a0c8836a2aa0f16d891");
        Session session = Session.getDefaultInstance(properties);
 
      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(recipient));
         // Set Subject: header field
         message.setSubject("Order Confirmation");
         // Now set the actual message
         message.setText(messageContent);
         // Send message
         Transport.send(message);
      } catch(Exception e) {
          log("My ERROR: " + e);
      }
    }
}
