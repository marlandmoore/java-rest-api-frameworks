package com.app.user.controller;

import java.util.List;

import com.app.user.dao.UserDAO;
import com.app.user.model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserDAO userDao = new UserDAO();

    @GetMapping("/users")
    @CrossOrigin(methods = RequestMethod.GET)
    public List<User> getUsers() {
        try {
            return userDao.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    @CrossOrigin(methods = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        return userDao.getUser(id);
    }

    @PutMapping("/update")
    @CrossOrigin(methods = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @PostMapping("/create")
    @CrossOrigin(methods = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @DeleteMapping("/{id}/delete")
    @CrossOrigin(methods = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        try {
            userDao.deleteUser(id);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
