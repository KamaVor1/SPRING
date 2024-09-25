package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS user_table (
                id SERIAL PRIMARY KEY,
                first_name TEXT,
                last_name TEXT,
                age SMALLINT
                )
                """;
        try (var connection = Util.open();
             var statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE IF EXISTS user_table
                """;
        try (var connection = Util.open();
             var statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = """
                INSERT INTO user_table (first_name,last_name,age) VALUES (?, ?, ?)
                """;
        try (var connection = Util.open();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeUserById(long id) {
        String sql = """
                DELETE FROM user_table
                WHERE id = ?
                """;
        try (var connection = Util.open();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = """
                SELECT * FROM user_table 
                """;
        try (var connection = Util.open();
             var statement = connection.prepareStatement(sql)) {
            List<User>  list = new ArrayList<>();
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        String sql = """
                DELETE FROM user_table
                """;
        try (var connection = Util.open();
             var statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
