/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.core.OrderItem;
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
    private final EntityManager em;
    
    public ProductJpaCtrl(EntityManagerFactory emf) {
        this(null, emf);
    }
    
    public ProductJpaCtrl(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
        this.em = emf.createEntityManager();
    }
    
    @Override
    public void create(Product t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        Product p = em.find(Product.class, id);
        if (p == null)
            throw new NonexistentEntityException("Entity not found");
        else {
            String query = "SELECT oi FROM OrderItem oi WHERE oi.product.id=:id";
            TypedQuery<OrderItem> tq = em.createQuery(query, OrderItem.class);
            tq.setParameter("id", id);
            List<OrderItem> orders = tq.getResultList();
            em.getTransaction().begin();
            for (OrderItem o : orders) {
                em.remove(o);
            }
            em.remove(p);
            em.getTransaction().commit();
        }
    }

    @Override
    public void edit(Product t) throws NonexistentEntityException, Exception {
        Product dbProduct = em.find(Product.class, t.getId());
        if (dbProduct == null) {
            throw new NonexistentEntityException("Product with id " + t.getId() + " could not be found");
        } else {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        }
    }

    @Override
    public Product findEntity(Long id) {
        Product p = em.find(Product.class, id);
        return p;
    }
    
    @Override
    public List<Product> findEntities() {
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        List<Product> products = tq.getResultList();
        return products;
    }

    @Override
    public List<Product> findEntities(int maxResults, int firstResult) {
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        tq.setFirstResult(firstResult);
        tq.setMaxResults(maxResults);
        List<Product> products = tq.getResultList();
        return products;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public int getEntityCount() {
        String query = "SELECT COUNT(p) FROM Product p";
        TypedQuery<Long> tp = em.createQuery(query, Long.class);
        return tp.getSingleResult().intValue();
    }
    

}
