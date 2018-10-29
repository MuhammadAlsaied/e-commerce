package onlineshopping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by @author Muhammed Alsaied On Jul 24, 2018
 * muhammadalsaied96@gmail.com
 */
@Entity
@Table(name = "category")
public class Category {

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }



    @Column(name = "is_active")
    private boolean active = true;

   
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


  

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

   
    public void setActive(boolean active) {
        this.active = active;
    }

}
