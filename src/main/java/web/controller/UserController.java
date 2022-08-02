package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
@GetMapping("/")
    public String showPageUser(Model model) {
        String showtext = "Это новая страница с юзерами!";
        model.addAttribute("welcometext", showtext);
        return "index";
    }
}
