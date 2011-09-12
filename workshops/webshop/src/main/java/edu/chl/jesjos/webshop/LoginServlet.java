/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.webshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesper
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/auth"})
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String LOGOUT = "logout";
    private static final String REGISTER = "register";
    private static final String REGISTER_SUCCESS = "User was successfully created!";
    private static final String REGISTER_FAILURE = "User registration failed, try again.";
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
        /*
         * Default page for redirect.
         */
        String redirectPage = Constants.HOMEPATH;
        HttpSession session = request.getSession();
        Boolean valid = true;
        try {
            String action = request.getParameter("action");
            String user = request.getParameter("login");
            String password = request.getParameter("passwd");
            if (action.equals(LOGIN)) {
                User theUser = Database.getUser(user, password);
                if (theUser != null) {
                    /*
                     * Login succeeded
                     */
                    session.setAttribute(Constants.USER, theUser);
                    Flash.setFlash("Login succeeded!", session);
                } else {
                    /*
                     * Login failed
                     */
                    Flash.setFlash("Login failed", session);
                    redirectPage = Constants.REGISTERPATH;
                }
            }
            else if (action.equals(LOGOUT)) {
                session.invalidate();
                redirectPage = Constants.HOMEPATH;
                valid = false;
            }
            else if (action.equals(REGISTER)) {
                boolean userDidGetCreated = Database.addUser(user, password);
                if (userDidGetCreated) {
                    /*
                     * Registration succeeded
                     */
                    Flash.setFlash("User registered!", session);
                    session.setAttribute(Constants.USER, Database.getUser(user, password));
                } else {
                    /*
                     * Registration failed
                     */
                    Flash.setFlash("Registration failed, username most likely taken", session);
                    redirectPage = Constants.REGISTERPATH;
                }
                
            }
        } finally {
            if (valid && session.getAttribute(Constants.USER) != null)
                session.setAttribute(Constants.SHOPPINGCART, new ShoppingCart());
            response.sendRedirect(redirectPage);
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

    private void doLogin(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String password = request.getParameter("passwd");
        User theUser = Database.getUser(user, password);
        try {
            if (theUser != null) {
                request.setAttribute("user", theUser);
                request.getRequestDispatcher(Constants.HOMEPATH).forward(request, response);
            } else {
                request.getRequestDispatcher(Constants.REGISTERPATH).forward(request, response);
            }
        } catch (Exception e){
            // Handle?
        }
    }

    private void doLogout() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void doRegister() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
