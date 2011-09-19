/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa.servlet;

import edu.chl.jesjos.jpa.servlet.*;
import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.db.Database;
import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hajo
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    /*
     * A wrapper class, JAXB can't handle lists directly 
     */
    @XmlRootElement
    static class ProductList {

        @XmlElement
        private List<Product> product; // name shows up in XML

        public ProductList() {
        }

        public ProductList(List<Product> product) {
            this.product = product;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/xml;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        Logger.getAnonymousLogger().log(Level.INFO, "AJAX");

        String action = request.getParameter("action");

        if ("find".equals(action)) {
            response.setContentType("text/xml;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String first = request.getParameter("first");
            String max = request.getParameter("max");
            List<Product> ps = Database.getProductController().
                    findEntities(Integer.valueOf(max), Integer.valueOf(first));
            ProductList wrapper = new ProductList(ps);
            JAXBContext jc;
            try {
                jc = JAXBContext.newInstance(ProductList.class);
                Marshaller m = jc.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                        Boolean.TRUE);
                // Dump XML data
                m.marshal(wrapper, out);
            } catch (JAXBException ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                out.close();
            }
        } else if ("add".equals(action)) {
            Database.getProductController().create(getProduct(request));
        } else if ("del".equals(action)) {
            String id = request.getParameter("id");
            try {
                Database.getProductController().destroy(Long.valueOf(id));
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("edit".equals(action)) {
            Product p = getProduct(request);
            try {
                Database.getProductController().edit(p);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new IllegalArgumentException("No action for " + action);
        }
    }

    private Product getProduct(HttpServletRequest req) {
        long id = 0;
        try {
            id = Long.valueOf(req.getParameter("id"));
        } catch (Exception e) {
            // No problem 
        }
        String name = req.getParameter("name");
        String cat = req.getParameter("cat");
        String price = req.getParameter("price");
        return new Product(id, name, cat, Double.valueOf(price));
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
