package onlineshopping.dao;

import java.util.List;
import onlineshopping.dto.Category;
import onlineshopping.dto.Product;
import onlineshopping.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by @author Muhammed Alsaied On Oct 3, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository("productDAO")
@Transactional
public class ProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Product> list() {
        return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).list();
    }

    public boolean insert(Product product) {
        try {
            sessionFactory.getCurrentSession().save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Long count() {
        try {
            long count = (long) sessionFactory.getCurrentSession().createQuery("select count(*) from Product").uniqueResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Product product) {
        try {
            sessionFactory.getCurrentSession().update(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Product product) {
        try {
            sessionFactory.getCurrentSession().delete(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Product get(long id) {
        try {
            return sessionFactory.getCurrentSession().get(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> listActiveProducts() {
        return sessionFactory.getCurrentSession().createQuery("from Product where active = true", Product.class).list();
    }

    public List<Product> listActiveProductsFromCategory(int categoryId) {
        return sessionFactory.getCurrentSession().
                createQuery("from Product where active = true and categoryId= :categoryId", Product.class)
                .setParameter("categoryId", categoryId).list();
    }

    public List<Product> listInactiveProductsFromCategory(int categoryId) {
        return sessionFactory.getCurrentSession().
                createQuery("from Product where active = false and categoryId= :categoryId", Product.class)
                .setParameter("categoryId", categoryId).list();
    }

    public List<Product> listInactiveProduct() {
        return sessionFactory.getCurrentSession().createQuery("from Product where active = false", Product.class).list();
    }

    public List<Product> listLastAddedActiveProducts(int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product where active = true order by id desc", Product.class)
                .setFirstResult(0).setMaxResults(count).list();

    }

    public List<Product> listLastAddedActiveProductsInCategory(int count, int categoryId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product where active = true and categoryId=:categoryId order by id", Product.class)
                .setParameter("categoryId", categoryId)
                .setFirstResult(0).setMaxResults(count).list();

    }

}
