package ru.sgu.presentation.bank.service;

import ru.sgu.presentation.bank.dao.TransferDao;
import ru.sgu.presentation.bank.model.Account;
import ru.sgu.presentation.bank.model.Transfer;
import ru.sgu.presentation.bank.model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;

public class TransferService {

    private TransferDao transferDao;

    private AccountService accountService;

    public TransferService(TransferDao transferDao) throws NoSuchAlgorithmException {
        this.transferDao = transferDao;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Set<Transfer> getAll() throws SQLException {
        return transferDao.getAll();
    }

    public Set<Transfer> getAllByUser(User user) throws SQLException {
        LinkedList<UUID> uuidList = new LinkedList<>();
        Set<Account> accounts = accountService.getAllByUserId(user.getId());
        for (Account account : accounts) {
            uuidList.addLast(account.getId());
        }
        return transferDao.getAllByUUID(uuidList);
    }

    public void addTransfer(Transfer transfer) throws SQLException {
        transferDao.addTransfer(transfer);
    }

}
