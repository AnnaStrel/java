package ru.sgu.presentation.bank.dao;

import ru.sgu.presentation.bank.model.AccCodeType;
import ru.sgu.presentation.bank.model.Account;
import ru.sgu.presentation.bank.model.Transfer;
import ru.sgu.presentation.bank.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

public class TransferDao extends Dao {

    private AccountDao accountDao;

    public TransferDao(AccountDao accountDao) throws SQLException {
        super();
        this.accountDao = accountDao;
    }

    public Set<Transfer> getAll() throws SQLException {
        Set<Transfer> transfers = new HashSet<Transfer>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id, from_uuid, to_uuid, amout, date, acc_code, balance_before, balance_after FROM transfers"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            UUID from = (UUID) resultSet.getObject(2);
            UUID to = (UUID) resultSet.getObject(3);
            BigDecimal amount = resultSet.getBigDecimal(4);
            Date date = resultSet.getDate(5);
            Account accountFrom = accountDao.getByUUID(from);
            Account accountTo = accountDao.getByUUID(to);
            AccCodeType accCodeType = AccCodeType.values()[resultSet.getInt(6)];
            BigDecimal balanceBefore = resultSet.getBigDecimal(7);
            BigDecimal balanceAfter = resultSet.getBigDecimal(8);
            Transfer transfer = new Transfer(
                    id,
                    accountFrom,
                    accountTo,
                    amount,
                    date,
                    accCodeType,
                    balanceBefore,
                    balanceAfter
            );
            transfers.add(transfer);
        }
        resultSet.close();
        preparedStatement.close();
        return transfers;
    }

    public Set<Transfer> getAllByUUID(List<UUID> uuidList) throws SQLException {
        Set<Transfer> transfers = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        builder.append("?,".repeat(uuidList.size()));
        String params = builder.deleteCharAt(builder.length() - 1).toString();
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        "SELECT id, from_uuid, to_uuid, amount, date, acc_code, balance_before, balance_after " +
                                "FROM transfers WHERE to_uuid IN (%s) OR from_uuid IN (%s)",
                        params,
                        params
                )
        );
        int index = 1;
        for (Object object : uuidList) {
            preparedStatement.setObject(index, object);
            preparedStatement.setObject(index + uuidList.size(), object);
            index++;
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            UUID from = (UUID) resultSet.getObject(2);
            UUID to = (UUID) resultSet.getObject(3);
            BigDecimal amount = resultSet.getBigDecimal(4);
            Date date = resultSet.getDate(5);
            Account accountFrom = accountDao.getByUUID(from);
            Account accountTo = accountDao.getByUUID(to);
            AccCodeType accCodeType = AccCodeType.values()[resultSet.getInt(6)];
            BigDecimal balanceBefore = resultSet.getBigDecimal(7);
            BigDecimal balanceAfter = resultSet.getBigDecimal(8);
            Transfer transfer = new Transfer(
                    id,
                    accountFrom,
                    accountTo,
                    amount,
                    date,
                    accCodeType,
                    balanceBefore,
                    balanceAfter
            );
            transfers.add(transfer);
        }
        resultSet.close();
        preparedStatement.close();
        return transfers;
    }

    public void addTransfer(Transfer transfer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO transfers(from_uuid, to_uuid, amount, date, acc_code, balance_before, balance_after) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)"
        );
        preparedStatement.setObject(1, transfer.getFrom().getId());
        preparedStatement.setObject(2, transfer.getTo().getId());
        preparedStatement.setBigDecimal(3, transfer.getAmount());
        preparedStatement.setTimestamp(4, new Timestamp(transfer.getDate().getTime()));
        preparedStatement.setInt(5, transfer.getAccCodeType().ordinal());
        preparedStatement.setBigDecimal(6, transfer.getBalanceBefore());
        preparedStatement.setBigDecimal(7, transfer.getBalanceAfter());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
