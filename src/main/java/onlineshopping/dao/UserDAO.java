package onlineshopping.dao;

import java.util.List;
import onlineshopping.dto.Address;
import onlineshopping.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by @author Muhammed Alsaied On Oct 3, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository("userDAO")
@Transactional
public class UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public boolean insert(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Long count() {
        try {
            long count = (long) sessionFactory.getCurrentSession().createQuery("select count(*) from User").uniqueResult();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(User user) {
        try {
            sessionFactory.getCurrentSession().delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByEmail(String email) {
        try {
            return sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByUsername(String username) {
        try {
            return sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().persist(address);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Address> listAddresses(User user) {
        try {
            return sessionFactory.getCurrentSession().createQuery("from Address where user=:user", Address.class)
                    .setParameter("user", user).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
