/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 * A lot to do here Use supplied exceptions if method should throw!!
 * @author hajo
 */
public class ProductJpaCtrl  implements IJpaCtrl<Product> {

    // UserTransaction not used in non container (i.e. for now)
    private final UserTransaction utx;
    // Get from Database
    private final EntityManagerFactory emf;
    private EntityManager em;
    
    public ProductJpaCtrl(EntityManagerFactory emf) {
        this.emf = emf;
        this.utx = null;
    }
    
    public ProductJpaCtrl(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    @Override
    public void create(Product t) {
        openEM();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        closeEM();
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(Product t) throws NonexistentEntityException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product findEntity(Long id) {
        openEM();
        Product p = em.find(Product.class, id);
        closeEM();
        return p;
    }
    
    @Override
    public List<Product> findEntities() {
        openEM();
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        List<Product> products = tq.getResultList();
        closeEM();
        return products;
    }

    @Override
    public List<Product> findEntities(int maxResults, int firstResult) {
        openEM();
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        tq.setFirstResult(firstResult);
        tq.setMaxResults(maxResults);
        List<Product> products = tq.getResultList();
        closeEM();
        return products;
    }

    @Override
    public EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private EntityManager openEM () {
        em = emf.createEntityManager();
        return em;
    }
    
    private void closeEM() {
        try {
            em.close();
        } catch (IllegalStateException e) {
            closeEM();
        }
    }

}
