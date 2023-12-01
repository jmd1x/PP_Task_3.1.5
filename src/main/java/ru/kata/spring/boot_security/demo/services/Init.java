package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class Init {
    final
    UsersService usersService;

    public Init(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostConstruct
    public void init() {
        User user = new User("user", "user",
                "Ivan", "Petrov", 24);
        User admin = new User("admin", "admin",
                "Sergey", "Ivanov", 32);
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        user.setRoles(Collections.singleton(userRole));
        admin.setRoles(Collections.singleton(adminRole));
        usersService.save(user);
        usersService.save(admin);
    }
}
