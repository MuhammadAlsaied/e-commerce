package onlineshopping.dao;

import onlineshopping.dao.UserDAO;
import onlineshopping.dto.Address;
import onlineshopping.dto.User;
import onlineshopping.dto.Cart;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by @author Muhammed Alsaied On Oct 10, 2018
 * muhammadalsaied96@gmail.com
 */
public class UserTestCase {

    public static UserDAO userDAO;

    @BeforeClass
    public static void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("onlineshopping");
        userDAO = context.getBean("userDAO", UserDAO.class);

    }

    @Test
    public void test() {
        //add user
        User user = new User();
        user.setUsername("Muhammad Alsaied");
        user.setEnabled(true);
        user.setNumber("01098742294");
        user.setEmail("demo@example.com");
        assertEquals("Error in insrting user!", true, userDAO.insert(user));

        //add cart to user
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        //add address to user
        Address address = new Address();
        address.setCountry("Egypt");
        address.setState("Eldakahlia");
        address.setCity("Mynit Elnasr");
        address.setPostalCode("552264");
        address.setUser(user);
        user.addAddress(address);

        userDAO.update(user);
        User user1 = userDAO.getByEmail("demo@example.com");
        Assert.assertNotNull("User object is null", user1);
        assertEquals("Error in address information", "Mynit Elnasr", user1.getAddresses().get(0).getCity());
        assertEquals("Error deleting user!", true, userDAO.delete(user1));
    }
}
