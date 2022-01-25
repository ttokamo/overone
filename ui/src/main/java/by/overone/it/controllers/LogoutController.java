package by.overone.it.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userId")
public class LogoutController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @GetMapping(value = "/logout")
    public View logout(HttpSession httpsession, SessionStatus status) {
        LOGGER.info("Завершение сессии");
        RedirectView redirectView = new RedirectView("/ui/login");
        redirectView.setExposeModelAttributes(false);
        status.setComplete();
        httpsession.invalidate();
        return redirectView;
    }
}
