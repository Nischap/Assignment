package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDao userDao) {
        return new ResponseEntity<>(userService.addUser(userDao), CREATED);
    }

    @GetMapping("/get/{userName}")
    public ResponseEntity<UserDao> getUser(@PathVariable String userName) throws NotFoundException {
        return new ResponseEntity<>(userService.getUser(userName), OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDao userDao) throws NotFoundException {
        return new ResponseEntity<>(userService.updateUser(userDao), OK);
    }

    @DeleteMapping("/delete/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName) throws NotFoundException {
        return new ResponseEntity<>(userService.deleteUser(userName), OK);
    }
}
