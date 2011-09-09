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

/**
 *
 * @author jesper
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/auth"})
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String LOGOUT = "logout";
    private static final String REGISTER = "register";
    
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
        String completeAction = Constants.HOMEPATH;
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
                    request.getSession(true).setAttribute(Constants.USER, theUser);
                } else {
                    /*
                     * Login failed
                     */
                    completeAction = Constants.REGISTERPATH;
                }
            }
            else if (action.equals(LOGOUT)) {
                request.getSession().invalidate();
            }
            else if (action.equals(REGISTER)) {
                if (Database.addUser(user, password)) {
                    /*
                     * Registration succeeded
                     */
                    request.getSession(true).setAttribute(Constants.USER, Database.getUser(user, password));
                } else {
                    /*
                     * Registration failed
                     */
                    completeAction = Constants.REGISTERPATH;
                }
                
            }
        } finally {
            request.getRequestDispatcher(completeAction).forward(request, response);
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
