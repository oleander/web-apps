/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author hajo
 */
public interface IJpaCtrl<T> {

    void create(T t);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(T t) throws NonexistentEntityException, Exception;

    T findEntity(Long id);

    List<T> findEntities();

    List<T> findEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getEntityCount();
    
}
