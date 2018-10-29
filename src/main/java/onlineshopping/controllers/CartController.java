package onlineshopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by @author Muhammed Alsaied On Oct 18, 2018
 * muhammadalsaied96@gmail.com
 */
@Controller
@RequestMapping("cart")
public class CartController {

    @RequestMapping("/show")
    public ModelAndView showCart() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","cart");
        mv.addObject("viewCart","true");
        return mv;
    }
}
