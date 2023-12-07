package ru.kata.spring.boot_security.demo.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UsersService usersService;

    private AdminController(UsersService usersService) {
        this.usersService = usersService;
    }

    //    @GetMapping("/users")
//    public String index(Model model) {
//        model.addAttribute("users", usersService.findAll());
//        return "admin_panel";
//    }
    @GetMapping()
    public String index(Model model, Principal principal) {
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("user", usersService.findByUsername(principal.getName()));
        return "admin_bootstrap";
    }

    @GetMapping("/")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", usersService.show(id));
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "redirect:/admin";
    }

    @PostMapping()
    public String create(@ModelAttribute User user) {
        usersService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", usersService.show(id));
        return "redirect:/admin";
    }

    @PatchMapping()
    public String update(@ModelAttribute User user, @RequestParam("id") int id) {
        usersService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        usersService.delete(id);
        return "redirect:/admin";
    }

}
