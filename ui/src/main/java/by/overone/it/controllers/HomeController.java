package by.overone.it.controllers;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userId")
public class HomeController {
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String showHomePage(@PathVariable("id") String id, Model model) {
        LOGGER.info("Вход на страницу профиля");
        User user = userService.getUserById(id);
        model.addAttribute("thisIsProfile", true);
        model.addAttribute("user", user);
        return "home-page";
    }
}
