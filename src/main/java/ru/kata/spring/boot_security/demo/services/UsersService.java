package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UsersService extends UserDetailsService {
    public List<User> findAll();

    public User show(int id);

    public void save(User user);

    public void addUser(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);

    public User findByUsername(String username);
}
