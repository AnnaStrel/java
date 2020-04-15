package ru.sgu.presentation.bank.dao;

import ru.sgu.presentation.bank.model.AccCodeType;
import ru.sgu.presentation.bank.model.Account;
import ru.sgu.presentation.bank.model.User;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AccountDao extends Dao {

    private UserDao userDao;

    public AccountDao(UserDao userDao) throws SQLException {
        super();
        this.userDao = userDao;
    }

    public Set<Account> getAll() throws SQLException {
        Set<Account> accounts = new HashSet<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, user_id, amount, acc_code FROM accounts"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            UUID id  = (UUID) resultSet.getObject(1);
            long userId = resultSet.getLong(2);
            BigDecimal amount = resultSet.getBigDecimal(3);
            AccCodeType accCodeType = AccCodeType.values()[resultSet.getInt(4)];
            User user = userDao.getUserById(userId);
            Account account = new Account(id, user, amount, accCodeType);
            accounts.add(account);
        }
        resultSet.close();
        preparedStatement.close();
        return accounts;
    }

    public Account getByUUID(UUID uuid) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, user_id, amount, acc_code FROM accounts WHERE id = ?"
        );
        preparedStatement.setObject(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = null;
        if (resultSet.next()) {
            long userId = resultSet.getLong(2);
            BigDecimal amount = resultSet.getBigDecimal(3);
            AccCodeType accCodeType = AccCodeType.values()[resultSet.getInt(4)];
            User user = userDao.getUserById(userId);
            account = new Account(uuid, user, amount, accCodeType);
        }
        resultSet.close();
        preparedStatement.close();
        return account;
    }

    public void add(Account account) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO accounts(id, user_id, amount, acc_code) VALUES(?, ?, ?, ?)"
        );
        preparedStatement.setObject(1, account.getId());
        preparedStatement.setLong(2, account.getUser().getId());
        preparedStatement.setBigDecimal(3, account.getAmount());
        preparedStatement.setInt(4, account.getAccCode().ordinal());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public boolean existsByUserId(long userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM accounts WHERE user_id = ?"
        );
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        return result;
    }

    public void updateAmount(UUID uuid, BigDecimal amount) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE accounts SET amount = ? WHERE id = ?"
        );
        preparedStatement.setBigDecimal(1, amount);
        preparedStatement.setObject(2, uuid);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Set<Account> getAllByUserId(long userId) throws SQLException {
        Set<Account> accounts = new HashSet<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, user_id, amount, acc_code FROM accounts WHERE user_id = ?"
        );
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            UUID id  = (UUID) resultSet.getObject(1);
            BigDecimal amount = resultSet.getBigDecimal(3);
            AccCodeType accCodeType = AccCodeType.values()[resultSet.getInt(4)];
            User user = userDao.getUserById(userId);
            Account account = new Account(id, user, amount, accCodeType);
            accounts.add(account);
        }
        resultSet.close();
        preparedStatement.close();
        return accounts;
    }

}
