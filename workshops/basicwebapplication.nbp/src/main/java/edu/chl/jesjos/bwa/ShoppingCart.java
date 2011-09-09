/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.hajo.out;

import java.util.ArrayList;
import java.util.List;

/**
 * The users shopping cart
 * @author hajo
 */
public class ShoppingCart {

    // Utility rows in the cart
    public class Row {

        private final Product product;
        private int qty;

        private Row(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }

        public Product getProduct() {
            return product;
        }

        public int getQty() {
            return qty;
        }

        public double getCost() {
            // TODO
            return Math.round(qty * product.getPrice());
        }
    };
    private final List<Row> rows = new ArrayList<Row>();

    public List<Row> getRows() {
        return rows;
    }

    public double getTotal() {
        double total = 0;
        for (Row r : rows) {
            total += r.getCost();
        }
        return Math.round(total);
    }

    public void addProduct(Product p) {
        for (Row r : rows) {
            if (r.getProduct().getName().equals(p.getName())) {
                r.qty++;
                return;
            }
        }
        rows.add(new Row(p, 1));
    }

    public void removeProduct(String name) {
        Row toDelete = null;
        for (Row r : rows) {
            if (r.getProduct().getName().equals(name)) {
                if (r.getQty() > 1) {
                    r.qty--;
                    return;
                } else {
                    toDelete = r; // No concurrent modification!
                }
            }
        }
        rows.remove(toDelete);
    }

    // Simple solution for now (use by Mail)
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Row r : rows) {
            b.append(r.product.getName()).append(" ").append(r.qty).
                    append(" ").append(r.getCost()).append("\n");
        }
        b.append("Total ").append(getTotal());
        return b.toString();
    }
}
