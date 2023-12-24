package ru.kata.spring.boot_security.demo.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UsersService usersService;

    public UserRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<User> showInfo(Principal principal){
        User user = usersService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
