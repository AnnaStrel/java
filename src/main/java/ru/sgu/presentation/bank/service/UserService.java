package ru.sgu.presentation.bank.service;

import ru.sgu.presentation.bank.dao.UserDao;
import ru.sgu.presentation.bank.error.InvalidLoginOrPasswordException;
import ru.sgu.presentation.bank.error.UserNotFoundException;
import ru.sgu.presentation.bank.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

public class UserService {

    private UserDao userDao;

    private MessageDigest messageDigest;

    public UserService(UserDao userDao) throws NoSuchAlgorithmException {
        this.userDao = userDao;
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public Set<User> getAll() throws SQLException {
        return userDao.getAll();
    }

    public void register(User user) throws SQLException {
        String password = user.getPassword();
        messageDigest.update(password.getBytes());
        String encryptedPassword = new String(messageDigest.digest());
        user.setPassword(encryptedPassword);
        userDao.addUser(user);
    }

    public User login(String login, String password) throws Exception {
        messageDigest.update(password.getBytes());
        String encryptedPassword = new String(messageDigest.digest());
        User user = userDao.getUserByLoginOrPhone(login);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("Пользователь с таким логином или паролем не найден");
        }
        if (!encryptedPassword.equals(user.getPassword())) {
            throw new InvalidLoginOrPasswordException("Неверный логин или пароль");
        }
        return user;
    }

    public User getUserByPhone(String phone) throws SQLException {
        return userDao.getUserByPhone(phone);
    }

}
