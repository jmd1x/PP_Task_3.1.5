package ru.kata.spring.boot_security.demo.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
    private final UsersService usersService;

    @Autowired
    public AdminRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> showAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable("id") int id) {
        return new ResponseEntity<>(usersService.show(id), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        usersService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> edit(@RequestBody User user, @PathVariable("id") int id) {
        usersService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
