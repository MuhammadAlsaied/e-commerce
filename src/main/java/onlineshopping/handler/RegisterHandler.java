package onlineshopping.handler;

import onlineshopping.dao.UserDAO;
import onlineshopping.dto.Address;
import onlineshopping.dto.Cart;
import onlineshopping.dto.User;
import onlineshopping.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by @author Muhammed Alsaied On Oct 13, 2018
 * muhammadalsaied96@gmail.com
 */
@Component
public class RegisterHandler {

    @Autowired
    UserDAO userDao;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public RegisterModel init() {
        return new RegisterModel();
    }

    public boolean addUser(RegisterModel registerModel) {
        User user = registerModel.getUser();
        Address address = registerModel.getAddress();
        user.addAddress(address);
        address.setUser(user);
        user.setEnabled(true);
        Cart cart = new Cart();
        cart.setTotal(0);
        cart.setUser(user);
        user.setCart(cart);
        user.setRole("user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.insert(user);
        return true;
    }

    public boolean validate(User user, MessageContext errors) {
        boolean result = true;
        if (userDao.getByEmail(user.getEmail()) != null) {
            errors.addMessage(new MessageBuilder().error().source("email")
                    .defaultText("This email is already taken").build());
            result = false;
        }
        if (userDao.getByUsername(user.getUsername()) != null) {
            errors.addMessage(new MessageBuilder().error().source("username")
                    .defaultText("This username is already taken").build());
            result = false;
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.addMessage(new MessageBuilder().error().source("confirmPassword")
                    .defaultText("Does not match password").build());
            result = false;
        }

        return result;
    }
}
