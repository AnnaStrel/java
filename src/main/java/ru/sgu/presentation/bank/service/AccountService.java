package ru.sgu.presentation.bank.service;

import ru.sgu.presentation.bank.dao.AccountDao;
import ru.sgu.presentation.bank.dao.UserDao;
import ru.sgu.presentation.bank.error.*;
import ru.sgu.presentation.bank.model.AccCodeType;
import ru.sgu.presentation.bank.model.Account;
import ru.sgu.presentation.bank.model.Transfer;
import ru.sgu.presentation.bank.model.User;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;

public class AccountService {

    private final Map<AccCodeType, Double> currency = new HashMap<>();

    private AccountDao accountDao;

    private TransferService transferService;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
        currency.put(AccCodeType.RUB, 1.);
        currency.put(AccCodeType.USD, 60.);
        currency.put(AccCodeType.EUR, 70.);
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    public Set<Account> getAll() throws SQLException {
        return accountDao.getAll();
    }

    public Set<Account> getAllByUserId(long userId) throws SQLException {
        return accountDao.getAllByUserId(userId);
    }

    public boolean existsByUserId(long userId) throws SQLException {
        return accountDao.existsByUserId(userId);
    }

    public void create(Account account) throws SQLException {
//        if (existsByUserId(account.getUser().getId())) {
//            throw new AccountExistsException("У данного пользователя уже зарегистрирован аккаунт");
//        }
        UUID uuid = UUID.randomUUID();
        account.setId(uuid);
        accountDao.add(account);
    }

    public void replenish(UUID uuid, BigDecimal amount) throws SQLException {
        Account account = accountDao.getByUUID(uuid);
        if (Objects.isNull(account)) {
            throw new AccountNotFoundException("Аккаунт с таким UUID не найден");
        }
        BigDecimal balance = account.getAmount();
        BigDecimal newBalance = balance.add(amount);
        accountDao.updateAmount(uuid, newBalance);
    }

    public void transfer(User fromUser, UUID fromUUID, UUID toUUID, BigDecimal amount) throws SQLException {
        Account from = accountDao.getByUUID(fromUUID);
        Account to = accountDao.getByUUID(toUUID);
        if (fromUser.getId() != from.getUser().getId()) {
            throw new AccountNotFoundException("Вы не можете перевести средства с чужого счета");
        }
        if (Objects.isNull(from) || Objects.isNull(to)) {
            throw new AccountNotFoundException("Аккаунт с таким UUID не найден");
        }
        if (to.getId().equals(from.getId())) {
            throw new SelfTransferException("Нельзя осуществлять перевод между одинаковыми аккаунтами");
        }
        BigDecimal fromBalance = from.getAmount();
        if (fromBalance.subtract(amount).doubleValue() < 0) {
            throw new NotEnoughBalanceException("На вашем счету недостаточно средств");
        }
        BigDecimal newFromBalance = fromBalance.subtract(amount);
        BigDecimal toBalance = to.getAmount();
        BigDecimal transferSum = BigDecimal.valueOf(currency.get(from.getAccCode()) / currency.get(to.getAccCode())).multiply(amount);
        BigDecimal newToBalance = toBalance.add(transferSum);
        accountDao.updateAmount(fromUUID, newFromBalance);
        accountDao.updateAmount(toUUID, newToBalance);
        Transfer transfer = new Transfer(from, to, amount, new Date(), to.getAccCode(), fromBalance, newFromBalance);
        transferService.addTransfer(transfer);
    }

}
