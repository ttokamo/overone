package by.overone.it.service;

import by.overone.it.dao.UserDao;
import by.overone.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(
            String firstName,
            String secondName,
            String email,
            String address,
            String telephone,
            String password
    ) {
      User user = new User();
      user.setFirstName(firstName);
      user.setSecondName(secondName);
      user.setEmail(email);
      user.setAddress(address);
      user.setTelephone(telephone);
      user.setPassword(password);
      user.setCreateDate(LocalDateTime.now());
      addUser(user);
    }

    public List<User> getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }

    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    private void addUser(User user) {
        userDao.addUser(user);
    }
}
