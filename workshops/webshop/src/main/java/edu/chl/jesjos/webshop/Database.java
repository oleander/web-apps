/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.webshop;

import edu.chl.jesjos.webshop.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Emulating a simple database
 * @author hajo
 */
public class Database {

    private static final Set<User> users = new HashSet<User>();
    private static final Set<Product> products = new HashSet<Product>();

    static {
        products.add(new Product("Berries", 12.20));
        products.add(new Product("Apples", 13.30));
        products.add(new Product("Bananas", 14.40));
        products.add(new Product("Pears", 15.50));
    }

    // Will not add users with same login
    public static boolean addUser(String login, String passwd) {
        return users.add(new User(login, passwd));
    }

    public static void removeUser(String login) {
        users.remove(new User(login, ""));
    }

    public static User getUser(String login, String passwd) {
        for (User u : users) {
            if (u.getLogin().equals(login)
                    && u.getPasswd().equals(passwd)) {
                return u;
            }
        }
        return null;
    }

    public static Product getProduct(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }
}
