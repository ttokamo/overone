package by.overone.it.validation;

import by.overone.it.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationValidation {

    @Autowired
    private UserDao userDao;

    public List<String> checkCanUserRegister(
            String email,
            String password,
            String repassword,
            String firstName,
            String secondName,
            String telephone
    ) {
        List<String> message = new ArrayList<>();

        if (firstName.isEmpty()) {
            message.add("Введите имя");
        } else if (secondName.isEmpty()) {
            message.add("Введите фамилию");
        } else if (!RegexValidation.checkEmailFormat(email)) {
            message.add("Неверный формат почты");
        } else if (!RegexValidation.checkTelephoneFormat(telephone)) {
            message.add("Неверный формат номера телефона");
        } else if (!RegexValidation.checkPasswordFormat(password)) {
            message.add("Неверный формат пароля");
        } else {
            if (!userDao.getUserByEmail(email).isEmpty()) {
                message.add("Пользователь с такой почтой уже существует");
            } else if (!password.equals(repassword)) {
                message.add("Пароли не совпадают");
            }
        }
        return message;
    }
}
