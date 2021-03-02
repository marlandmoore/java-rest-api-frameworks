package com.app.user.controller;

import java.util.List;

import com.app.user.dao.UserDAO;
import com.app.user.model.User;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.retry.annotation.CircuitBreaker;

@Controller("/user")
public class UserController {

    private UserDAO userDao = new UserDAO();

    @Get("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        User user = userDao.getUser(Integer.valueOf(id));
        return user;
    }

    @Get("/users")
    @CircuitBreaker(attempts = "5")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Post("/create")
    public String createUser(@Body User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @Put("/update")
    public String updateUser(@Body User user) {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @Delete("/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        try {
            userDao.deleteUser(id);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
