package onlineshopping.controllers;

import javax.servlet.http.HttpSession;
import onlineshopping.dao.UserDAO;
import onlineshopping.dto.User;
import onlineshopping.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by @author Muhammed Alsaied On Oct 17, 2018
 * muhammadalsaied96@gmail.com
 */
@ControllerAdvice
public class GlobalController {

    @Autowired
    UserDAO userDAO;

    @ModelAttribute("userModel")
    public UserModel getUserModel(HttpSession httpSession) {
        UserModel userModel = (UserModel) httpSession.getAttribute("userModel");

        if (userModel == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userDAO.getByEmail(authentication.getName());
            if (user != null) {
                userModel = new UserModel();
                userModel.setId(user.getId());
                userModel.setEmail(user.getEmail());
                userModel.setUsername(user.getUsername());
                userModel.setRole(user.getRole());
                if (userModel.getRole().equals("user")) {
                    userModel.setCart(user.getCart());
                }
                httpSession.setAttribute("userModel", userModel);
            }
        }

        return userModel;
    }

}
