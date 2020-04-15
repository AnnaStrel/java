package ru.sgu.presentation.bank.dao;

import ru.sgu.presentation.bank.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDao extends Dao {

    public UserDao() throws SQLException {
        super();
    }

    public Set<User> getAll() throws SQLException {
        Set<User> users = new HashSet<User>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, login, password, address, phone FROM users"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            String address = resultSet.getString(4);
            String phone = resultSet.getString(5);
            User user = new User(id, login, password, address, phone);
            users.add(user);
        }
        resultSet.close();
        preparedStatement.close();
        return users;
    }

    public User getUserById(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, login, password, address, phone FROM users WHERE id = ?"
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            String address = resultSet.getString(4);
            String phone = resultSet.getString(5);
            user = new User(id, login, password, address, phone);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public User getUserByLoginOrPhone(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, login, password, address, phone FROM users WHERE login LIKE ? OR phone LIKE ?"
        );
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String password = resultSet.getString(3);
            String address = resultSet.getString(4);
            String phone = resultSet.getString(5);
            user = new User(id, login, password, address, phone);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public User getUserByPhone(String phone) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, login, password, address, phone FROM users WHERE phone LIKE ?"
        );
        preparedStatement.setString(1, phone);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String login = resultSet.getString(2);
            String password = resultSet.getString(3);
            String address = resultSet.getString(4);
            user = new User(id, login, password, address, phone);
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users(login, password, address, phone) VALUES(?, ?, ?, ?)"
        );
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getAddress());
        preparedStatement.setString(4, user.getPhone());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
