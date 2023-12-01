package ru.kata.spring.boot_security.demo.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UsersService usersService;

    private AdminController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "admin_panel";
    }
//    @GetMapping("/users")
//    public String index(Model model) {
//        model.addAttribute("users", usersService.findAll());
//        return "test";
//    }

    @GetMapping("/users/")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", usersService.show(id));
        return "show";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute User user) {
        usersService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", usersService.show(id));
        return "edit";
    }

    @PatchMapping("/users")
    public String update(@ModelAttribute User user, @RequestParam("id") int id) {
        usersService.update(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users")
    public String delete(@RequestParam("id") int id) {
        usersService.delete(id);
        return "redirect:/admin/users";
    }

}
