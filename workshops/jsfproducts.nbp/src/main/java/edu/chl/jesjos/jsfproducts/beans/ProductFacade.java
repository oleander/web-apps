/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jsfproducts.beans;

import edu.chl.jesjos.jsfproducts.Product;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author jesper
 */
@ManagedBean(name = "pdb")
@RequestScoped
public class ProductFacade {

    @PersistenceContext(unitName = "jsf_pu")
    private EntityManager em;
    @Resource
    private UserTransaction utx;

    /** Creates a new instance of ProductFacade */
    public ProductFacade() {
    }

    public List<Product> getAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Product.class));
        return getEm().createQuery(cq).getResultList();
    }

    public void create(Product p) {
        try {
            utx.begin();
            getEm().persist(p);
            utx.commit();
        } catch (Exception e1) {
            try {
                utx.rollback();
            } catch (Exception e2) {
                System.err.println("Rollback failed" + e2.getMessage());
            }
        }
    }
    
    public Product findById(long id) {
        return getEm().find(Product.class, id);
    }
    
    public void delete(Product p) {
        try {
            utx.begin();
            Product p_ref = em.getReference(Product.class, p.getId());
            getEm().remove(p_ref);
            utx.commit();
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch(Exception e2) {
                System.err.println("Rollback failed");
            }
        }
    }
    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the utx
     */
    public UserTransaction getUtx() {
        return utx;
    }

    /**
     * @param utx the utx to set
     */
    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }
}
