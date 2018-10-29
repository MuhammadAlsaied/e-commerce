package onlineshopping.dao;

import java.util.ArrayList;
import java.util.List;
import onlineshopping.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by @author Muhammed Alsaied On Jul 24, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDAO {

    static List<Category> categories = new ArrayList();
    @Autowired
    SessionFactory sessionFactory;

    public List<Category> listActiveCategories() {
        return sessionFactory.getCurrentSession().createQuery("from Category where active = true", Category.class).list();
    }

    public List<Category> listInactiveCategories() {
        return sessionFactory.getCurrentSession().createQuery("from Category where active = false", Category.class).list();
    }

    public List<Category> List() {
        return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
    }
    
    public boolean insert(Category category) {
        try {
            sessionFactory.getCurrentSession().save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Long count() {
        try {
            long count =(long) sessionFactory.getCurrentSession().createQuery("select count(*) from Category").uniqueResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Category category) {
        try {
            sessionFactory.getCurrentSession().delete(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Category get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
