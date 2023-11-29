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
        // пароль = user
        User user = new User("user", "$2a$12$tCKfMwLeOuJx/by1y1wR0edFEl/8LQFc2a9q1o0qvLeDFMTSS9wfi",
                "Ivan", "Petrov", 24);
        // пароль = admin
        User admin = new User("admin", "$2a$12$arIn8gFEPzcr4O.Cpa.u4OlqT.HRwzNaz5Cu3XyYjiquzR4x8SmjG",
                "Sergey", "Ivanov", 32);
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        user.setRoles(Collections.singleton(userRole));
        admin.setRoles(Collections.singleton(adminRole));
        usersService.save(user);
        usersService.save(admin);
    }
}
