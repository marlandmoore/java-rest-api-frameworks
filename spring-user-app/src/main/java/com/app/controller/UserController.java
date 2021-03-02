package com.app.controller;

import org.springframework.web.bind.annotation.RestController;
import com.app.dao.UserDAO;

@RestController("/user")
public class UserController {

    private UserDAO userDao = new UserDAO();

    @Get("/user/{id}")
    public User getUserById(@PathVariable("id") String id) {
        User user = userDao.getUser(Integer.valueOf(id));
        return user;
    }

    @Get("/users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Post("/user/create")
    public String createUser(@Body @Valid User user) {
        UserDAO userDao = new UserDAO();

        return "success";
    }

    @Put("/user/{id}/update/")
    public String updateUser(@PathVariable("id") String id, @Body @Valid User user) {

        return "success";
    }

    @Delete("/user/{id}/delete")
    public String deleteUser(@PathVariable("id") String id, @Body @Valid User user) {

        return "success";
    }
}
