package ru.sgu.presentation.bank.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Account {

    private UUID id;

    private User user;

    private BigDecimal amount;

    private AccCodeType accCode;

    public Account() {
    }

    public Account(User user, BigDecimal amount, AccCodeType accCode) {
        this.user = user;
        this.amount = amount;
        this.accCode = accCode;
    }

    public Account(UUID id, User user, BigDecimal amount, AccCodeType accCode) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.accCode = accCode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccCodeType getAccCode() {
        return accCode;
    }

    public void setAccCode(AccCodeType accCode) {
        this.accCode = accCode;
    }

    @Override
    public String toString() {
        return String.format(
                "UUID: %s\nБаланс: %f\nВалюта: %s",
                this.id.toString(),
                this.amount.doubleValue(),
                this.accCode.toString()
        );
    }

}