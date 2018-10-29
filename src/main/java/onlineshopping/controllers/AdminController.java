package onlineshopping.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import onlineshopping.dao.CategoryDAO;
import onlineshopping.dao.ProductDAO;
import onlineshopping.dto.Category;
import onlineshopping.dto.Product;
import onlineshopping.utils.ImageValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by @author Muhammed Alsaied On Oct 4, 2018
 * muhammadalsaied96@gmail.com
 */
@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/json/list/all")
    @ResponseBody
    public List<Product> allProducts() {
        return productDAO.list();
    }

    @RequestMapping(value = {"product",""}, method = RequestMethod.GET)
    public ModelAndView manageProduct() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("manageProduct", true);
        modelAndView.addObject("title", "Manage products");
        Product p = new Product();
        modelAndView.addObject("product", p);
        return modelAndView;
    }

    @RequestMapping(value = {"product/{id}"}, method = RequestMethod.GET)
    public ModelAndView UPDATEProduct(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("manageProduct", true);
        modelAndView.addObject("title", "Manage products");

        Product p = productDAO.get(id);
        modelAndView.addObject("product", p);
        return modelAndView;
    }

    @RequestMapping(value = "category/add", method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request, Model model) {
        String catName = request.getParameter("cat-name");
        String catDescription = request.getParameter("cat-description");
        categoryDAO.insert(new Category(catName, catDescription));
        return "redirect:/admin-panel/product";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ModelAndView manageProduct(@Valid @ModelAttribute("product") Product product, BindingResult results, Model model,
            HttpServletRequest request) {
        model.addAttribute("manageProduct", true);
        model.addAttribute("title", "Manage products");
        if (product.getId() == null || !product.getImage().getOriginalFilename().isEmpty()) {
            new ImageValidation().validate(product, results);
        }
        if (results.hasErrors()) {
            return new ModelAndView("page");
        }
        if (!product.getImage().getOriginalFilename().isEmpty()) {
            if (product.getImageURL().isEmpty()) {
                product.setImageURL(UUID.randomUUID().toString() + ".jpg");
            }
            MultipartFile image = product.getImage();
            try {
                image.transferTo(new File(request.getSession().getServletContext().getRealPath("/assets/images/") + product.getImageURL()));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (product.getId() == null) {
            product.setViews(0);
            product.setActive(true);
            product.setPurchases(0);
            productDAO.insert(product);
            model.addAttribute("message", "product added successfully");
        } else {
            model.addAttribute("message", "product Updated successfully");
            productDAO.update(product);

        }
        model.addAttribute("product", new Product());
        return new ModelAndView("page");
    }

    @RequestMapping(value = "product/{id}/activation", method = RequestMethod.GET)
    @ResponseBody
    public String manageProductActivation(@PathVariable("id") long id) {
        Product product = productDAO.get(id);
        product.setActive(!product.isActive());
        productDAO.update(product);
        return product.isActive() ? "Product has been activated" : "product has been deactivated";
    }

    @ModelAttribute("admin")
    public boolean setAdminViewAsTrue() {
        return true;
    }

    @ModelAttribute("categories")
    public List<Category> bindCategories() {
        return categoryDAO.listActiveCategories();
    }
}
