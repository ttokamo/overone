package by.overone.it.dao;

import by.overone.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

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

        try {
            id = session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
