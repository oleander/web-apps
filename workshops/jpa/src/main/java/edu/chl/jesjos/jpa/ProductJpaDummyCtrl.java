/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.jpa;

import edu.chl.jesjos.jpa.core.Product;
import edu.chl.jesjos.jpa.jpactrl.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Not finished
 * @author hajo
 */
public class ProductJpaDummyCtrl implements IJpaCtrl<Product> {

    private List<Product> ps = new ArrayList<Product>();

    public ProductJpaDummyCtrl() {
        for (int i = 0; i < 10; i++) {
            ps.add(new Product((long) i, "test", "test", (double) i));
        }
    }

    @Override
    public void create(Product t) {
        ps.add(t);
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
        return new Product(id, "test", "test", Integer.valueOf(123).doubleValue());
    }

    @Override
    public List<Product> findEntities() {
        return ps;
    }

    @Override
    public List<Product> findEntities(int maxResults, int firstResult) {
        int begin = 0 <= firstResult && firstResult < ps.size() ? firstResult : ps.size();
        int end = firstResult + maxResults < ps.size() ? firstResult + maxResults : ps.size();
        return ps.subList(begin, end);
    }

    @Override
    public EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getEntityCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
