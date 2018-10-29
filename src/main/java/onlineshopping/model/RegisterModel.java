package onlineshopping.model;

import java.io.Serializable;
import onlineshopping.dto.Address;
import onlineshopping.dto.User;
import org.springframework.context.annotation.Bean;

/**
 * Created by @author Muhammed Alsaied On Oct 13, 2018
 * muhammadalsaied96@gmail.com
 */
public class RegisterModel implements Serializable{

    private User user;
    private Address address;

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

}
