package by.overone.it.controllers;

import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/finish-registration")
    public String checkInputData(
            @RequestParam("firstName") String firstName,
            @RequestParam("secondName") String secondName,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("telephone") String telephone,
            @RequestParam("password") String password
    ){
        userService.addUser(firstName, secondName, email, address, telephone, password);
        return "redirect:/login";
    }

    @GetMapping(value = "/registration")
    public String showLoginPage() {
        return "register-page";
    }
}
