package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;
import java.util.Set;

public interface UsersService extends UserDetailsService {
    public List<User> findAll();

    public User show(int id);

    public void save(User user);

    public void addUser(User user, String userRole, String adminRole);

    public void update(int id, User updatedUser);

    public void delete(int id);

    public User findByUsername(String username);

    public Set<Role> getAllRoles();
}
