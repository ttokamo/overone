package by.overone.it.controllers;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@SessionAttributes({"userId"})
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/finish-login")
    public String finishLogin(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        List<User> userList = userService.getUserByEmailAndPassword(email, password);

        if (userList.isEmpty()) {
            LOGGER.error("Ошибка ввода данных");
            model.addAttribute("exception", "Неверно введены данные");
            return "login-page";
        } else {
            LOGGER.info("Успешный вход в аккаунт");
            String id = userList.get(0).getId();
            model.addAttribute("userId", id);
            return "redirect:/exchange-rates";
        }
    }

    @GetMapping(value = {"/", "/login"})
    public String showLoginPage() {
        LOGGER.info("Вход на страницу авторизации");
        return "login-page";
    }
}
