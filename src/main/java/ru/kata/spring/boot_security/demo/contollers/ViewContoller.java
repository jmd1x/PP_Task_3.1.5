package ru.kata.spring.boot_security.demo.contollers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.entities.User;

@Controller
public class ViewContoller {
    @GetMapping("/")
    public String login() {
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String adminPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User admin = (User) authentication.getPrincipal();
        model.addAttribute("admin", admin);
        return "admin_bootstrap";
    }

    @GetMapping("/user")
    public String userPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "user_bootstrap";
    }
}
