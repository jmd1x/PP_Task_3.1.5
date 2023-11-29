package ru.kata.spring.boot_security.demo.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UsersService usersService;

    private UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String infoForUser(Model model, Principal principal) {
        model.addAttribute("user", usersService.findByUsername(principal.getName()));
        return "show_for_user";
    }
}
