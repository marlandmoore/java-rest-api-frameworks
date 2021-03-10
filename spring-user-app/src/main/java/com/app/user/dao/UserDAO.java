package com.app.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.app.user.model.User;

public class UserDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=passw0rd&ssl=false";
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void addUser(User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into users (firstname, lastname, email) values (?,?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.execute();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public User getUser(Integer userId) {
        User user = new User();
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select * from users where user_id=?";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setFirstname(rs.getString("user_id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
            } catch (Exception e) {
                // do nothing
            }
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select * from users";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setFirstname(rs.getString("user_id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }

        } catch (SQLException e) {

        } finally {
            try {
                con.close();
            } catch (Exception e) {

            }
        }

        return list;
    }

    public void updateUser(User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update users set firstname=?, lastname=?, email=? where user_id=?";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getUser_id());
            ps.execute();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser(Integer userId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from users where user_id=?";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.execute();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}