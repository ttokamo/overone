package by.overone.it.dao;

import by.overone.it.config.TestDaoConfiguration;
import by.overone.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.io.Serializable;

import static org.junit.Assert.*;

@ContextConfiguration(classes = TestDaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("webappSessionFactory")
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void addUser() {
        User user = new User();
        user.setEmail("add-test@gmail.com");

        Serializable id = userDao.addUser(user);

        Query<User> query = sessionFactory.getCurrentSession().createQuery(
                "from User where email =: paramEmail", User.class
        );
        query.setParameter("paramEmail", "add-test@gmail.com");
        User anotherUser = query.list().get(0);

        assertEquals(id, anotherUser.getId());
    }

    @Test
    @Transactional
    public void getUserByEmailAndPassword() {
        User user = new User();
        String email = "get-user-by-email-and-password@gmail.com";
        String password = "123";
        user.setEmail(email);
        user.setPassword(password);

        userDao.addUser(user);
        User anotherUser = userDao.getUserByEmailAndPassword(email, password).get(0);

        assertEquals(user.getId(), anotherUser.getId());
        assertEquals(user.getEmail(), anotherUser.getEmail());
        assertEquals(user.getPassword(), anotherUser.getPassword());
    }

    @Test
    public void getUserByEmail() {
        User user = new User();
        String email = "get-user-by-email@Gmail.com";
        user.setEmail(email);

        userDao.addUser(user);
        User anotherUser = userDao.getUserByEmail(email).get(0);

        assertEquals(user.getId(), anotherUser.getId());
        assertEquals(user.getEmail(), anotherUser.getEmail());
    }

    @Test
    public void getUserById() {
        User user = new User();

        Serializable id = userDao.addUser(user);
        User anotherUser = userDao.getUserById((String) id);

        assertEquals(id, anotherUser.getId());
    }
}