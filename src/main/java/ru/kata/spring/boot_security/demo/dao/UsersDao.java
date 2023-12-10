package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UsersDao {
    public List<User> findAll();

    public User show(int id);

    public void save(User user);

    public void update(User updatedUser);

    public void delete(int id);

    public User findByUsername(String username);
}
