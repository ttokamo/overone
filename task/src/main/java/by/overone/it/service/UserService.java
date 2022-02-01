package by.overone.it.service;

import by.overone.it.pojo.User;
import by.overone.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private User user;

    @Autowired
    private UserRepository userRepository;

    public void saveUser(
            String firstName,
            String secondName,
            String email,
            String address,
            String telephone,
            String password
    ) {
       user.setFirstName(firstName);
       user.setSecondName(secondName);
       user.setEmail(email);
       user.setAddress(address);
       user.setTelephone(telephone);
       user.setPassword(password);
       user.setCreateDate(LocalDateTime.now());
       saveUser(user);
    }

    private void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

}
