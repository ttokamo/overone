package by.overone.it.controller;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userId")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String showHomePage(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("thisIsProfile", true);
        model.addAttribute("user", user);
        return "home-page";
    }
}
