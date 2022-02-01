package by.overone.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userId")
public class ExchangeRatesController {

    @GetMapping("/exchange-rates")
    public String showExchangeRates(Model model) throws Exception {
        model.addAttribute("thisIsExchangeRates", true);
        model.addAttribute("rates", "Курсы валют ушли, но обещали вернуться");
        return "home-page";
    }
}
