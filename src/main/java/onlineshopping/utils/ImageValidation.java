package onlineshopping.utils;

import onlineshopping.dto.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by @author Muhammed Alsaied On Oct 6, 2018
 * muhammadalsaied96@gmail.com
 */
public class ImageValidation implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Product.class.equals(klass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        if (product.getImage().getOriginalFilename().isEmpty()
                || product.getImage() == null) {
            errors.rejectValue("image", "", "Please select an image!");
            return;
        }
        String contentType = product.getImage().getContentType();
        if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType) && !"image/gif".equals(contentType)) {
            errors.rejectValue("image", "", "Please select a valid image file!");
            return;
        }
    }

}
