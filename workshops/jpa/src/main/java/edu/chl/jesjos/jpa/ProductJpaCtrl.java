/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 * A lot to do here Use supplied exceptions if method should throw!!
 * @author hajo
 */
public class ProductJpaCtrl  {

    // UserTransaction not used in non container (i.e. for now)
    private final UserTransaction utx;
    // Get from Database
    private final EntityManagerFactory emf;
    
    
    public ProductJpaCtrl(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

}
