package by.overone.it.dao;

import by.overone.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class UserDao {

    @Autowired
    @Qualifier("webappSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public Serializable addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = null;
        id = session.save(user);
        return id;
    }

    public List<User> getUserByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("" +
                "from User where email =: paramEmail and password =: paramPassword", User.class
        );
        query.setParameter("paramEmail", email);
        query.setParameter("paramPassword", password);
        return query.list();
    }

    public List<User> getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("" +
                "from User where email =: paramEmail", User.class
        );
        query.setParameter("paramEmail", email);
        return query.list();
    }

    public User getUserById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
