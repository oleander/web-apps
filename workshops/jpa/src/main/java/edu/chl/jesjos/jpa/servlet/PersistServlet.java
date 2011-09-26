/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.servlet;

import edu.chl.jesjos.jpa.core.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesper
 */
@WebServlet(name = "PersistServlet", urlPatterns = {"/PersistServlet", "/find"})
public class PersistServlet extends HttpServlet {
    private static EntityManagerFactory mf;
    private EntityManager m;
    public PersistServlet () {
        mf = Persistence.createEntityManagerFactory("webshop_pu");
        m = mf.createEntityManager();
    }
    
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
        try {
            if(request.getServletPath().contains("PersistServlet")) {
                EntityTransaction tx = m.getTransaction();
                Product p = new Product();
                p.setName("Car");
                p.setPrice(2000.0);
                tx.begin();
                m.persist(p);
                tx.commit();

                tx.begin();
                p = m.find(Product.class, p.getId());
                p.setCategory("Vehicle");
                p.setName("Car");
                p.setPrice(3000.0);
                m.merge(p);
                tx.commit();

                out.println("<h1>" + p.toString() + "</h1>");
            } else {
                Long id = Long.valueOf(request.getParameter("id"));
                Product p1 = new Product();
                EntityTransaction tx = m.getTransaction();
                tx.begin();
                p1 = m.find(Product.class, id);
                tx.commit();
                out.println(p1);
            }
        } finally {            
            out.close();
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
}
