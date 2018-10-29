package onlineshopping.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import onlineshopping.dao.CategoryDAO;
import onlineshopping.dao.ProductDAO;
import onlineshopping.dto.Product;
import onlineshopping.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by @author Muhammed Alsaied On Jul 22, 2018
 * muhammadalsaied96@gmail.com
 */
@Controller
public class MainController {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("page");
        view.addObject("listProducts", true);
        view.addObject("title", "home");
        return view;
    }

    @RequestMapping(value = "contact")
    public ModelAndView contact() {
        ModelAndView view = new ModelAndView("page");
        view.addObject("contact", true);
        view.addObject("title", "Contact us");
        return view;
    }

    @RequestMapping(value = "login")
    public ModelAndView login(@RequestParam(name = "error" ,required = false) String error) {
        ModelAndView view = new ModelAndView("page");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            if(error != null){
                view.addObject("message","Username and password are incorrect");
            }
            view.addObject("login", true);
            view.addObject("title", "login");
        } else {
            view.addObject("home", true);
            view.addObject("title", "home");
        }
        return view;
    }

    @RequestMapping(value = "about")
    public ModelAndView about() {
        ModelAndView view = new ModelAndView("page");
        view.addObject("about", true);
        view.addObject("title", "About us");
        return view;
    }

    @RequestMapping({"list/all", "list", "all"})
    public ModelAndView listProducts() {
        ModelAndView view = new ModelAndView("page");
        view.addObject("listProducts", true);
        view.addObject("title", "All products");
        System.out.println();
        view.addObject("products", productDAO.listLastAddedActiveProducts(10));
        return view;
    }

    @RequestMapping({"list/{id}", "category/{id}"})
    public ModelAndView listCategory(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("page");
        view.addObject("listCategory", true);
        Category c = categoryDAO.get(id);
        view.addObject("title", c.getName());
        view.addObject("products", productDAO.listActiveProductsFromCategory(id));
        return view;

    }

    @RequestMapping({"view/{id}", "product/{id}"})
    public ModelAndView viewProduct(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("page");
        view.addObject("viewProduct", true);
        Product c = productDAO.get(id);
        view.addObject("title", c.getName());
        view.addObject("product", productDAO.get(id));
        return view;
    }

    @RequestMapping(value = "error")
    public ModelAndView viewProduct() {
        ModelAndView view = new ModelAndView("page");
        view.addObject("error", true);
        view.addObject("title", "Error!");
        return view;
    }

    @ModelAttribute("categories")
    public List<Category> bindCategories() {
        return categoryDAO.listActiveCategories();
    }

}
