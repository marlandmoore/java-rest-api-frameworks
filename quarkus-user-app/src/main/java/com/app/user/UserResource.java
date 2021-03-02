package com.app.user;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.user.dao.UserDAO;
import com.app.user.model.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserDAO userDao = new UserDAO();

    @GET
    @Path("/users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Integer userId) {
        return userDao.getUser(userId);
    }

    @POST
    @Path("/create")
    public String createUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @PUT
    @Path("/update")
    public String updateUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @DELETE
    @Path("/{id}/delete")
    public String deleteUser(@PathParam("id") Integer userId) {
        try {
            userDao.deleteUser(userId);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
