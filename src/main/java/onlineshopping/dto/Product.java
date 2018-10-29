package onlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by @author Muhammed Alsaied On Oct 3, 2018
 * muhammadalsaied96@gmail.com
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name field can not be blank!")
    private String name;

    @NotBlank(message = "Brand field can not be blank!")
    private String brand;

    @NotBlank(message = "description brand field can not be blank!")
    private String description;

    @Min(value = 1, message = "Product price can not be lees than 1 EGP!")
    private double price;

    private int quantity;

    private boolean active;

    @JsonIgnore
    private long purchases;

    @JsonIgnore
    private long views;

    @Column(name = "category_id")
    @JsonIgnore
    private int categoryId;

    @Transient
    MultipartFile image;

   
 
    @Column(name = "image_url")
    private String imageURL ;

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    public MultipartFile getImage() {
        return image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String formattedPrice() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("EN", "EG"));
        String p = formatter.format(price);
        return p;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isActive() {
        return active;
    }

    public long getPurchases() {
        return purchases;
    }

    public long getViews() {
        return views;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPurchases(long purchases) {
        this.purchases = purchases;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }
}
