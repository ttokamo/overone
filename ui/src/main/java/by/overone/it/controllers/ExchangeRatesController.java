package by.overone.it.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userId")
public class ExchangeRatesController {
    private static final Logger LOGGER = Logger.getLogger(ExchangeRatesController.class);

    @GetMapping("/exchange-rates")
    public String showExchangeRates(Model model) throws Exception {
        LOGGER.info("Вход на страницу курсов валют");
        model.addAttribute("thisIsExchangeRates", true);
        model.addAttribute("rates", "Курсы валют ушли, но обещали вернуться");
        return "home-page";
    }
}
