package onlineshopping.model;

import java.io.Serializable;
import onlineshopping.dto.Cart;

/**
 * Created by @author Muhammed Alsaied On Oct 17, 2018
 * muhammadalsaied96@gmail.com
 */
public class UserModel implements Serializable {

    private long id;
    private String username;
    private String email;
    private String Role;
    private Cart cart;

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", username=" + username + ", email=" + email + ", Role=" + Role + ", cart=" + cart + '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return Role;
    }

    public Cart getCart() {
        return cart;
    }
}
