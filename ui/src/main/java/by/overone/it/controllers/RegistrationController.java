package by.overone.it.controllers;

import by.overone.it.service.UserService;
import by.overone.it.service.ValidationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.List;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
    private UserService userService;
    private ValidationService validationService;

    @Autowired
    public RegistrationController(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }


    @PostMapping(value = "/finish-registration")
    public String checkInputData(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        if (telephone.isEmpty()) {
            telephone = null;
        }
        if (address.isEmpty()) {
            address = null;
        }

        List<String> messages = validationService.registrationValidation(
                email, password, repassword, firstName, secondName, telephone
        );

        if (messages.isEmpty()) {
            userService.addUser(firstName, secondName, email, address, telephone, password);
            LOGGER.info("Успешная регистрация");
            return "redirect:/login";
        } else {
            LOGGER.error("Ошибка ввода данных");
            request.setAttribute("exception", messages.get(0));
            return "register-page";
        }
    }

    @GetMapping(value = "/registration")
    public String showLoginPage() {
        LOGGER.info("Вход на страницу регистрации");
        return "register-page";
    }
}
