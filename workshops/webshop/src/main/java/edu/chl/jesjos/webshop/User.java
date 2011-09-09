/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.jesjos.webshop;

/**
 * A user of the system (customer)
 * @author hajo
 */
public class User {
    // Login unique
    private final String login;
    private final String passwd;
    // TODO private final String email;

    public User(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }
}
