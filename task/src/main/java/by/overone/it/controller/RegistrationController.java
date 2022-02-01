package by.overone.it.controller;

import by.overone.it.service.UserService;
import by.overone.it.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@SessionAttributes("userId")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private ValidationService validationService;

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
            userService.saveUser(firstName, secondName, email, address, telephone, password);
            return "redirect:/login";
        } else {
            request.setAttribute("exception", messages.get(0));
            return "register-page";
        }
    }

    @GetMapping(value = "/registration")
    public ModelAndView showLoginPage() {
        return new ModelAndView("register-page");
    }
}
