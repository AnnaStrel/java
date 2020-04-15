package ru.sgu.presentation.bank.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transfer {

    private long id;

    private Account from;

    private Account to;

    private BigDecimal amount;

    private Date date;

    private AccCodeType accCodeType;

    private BigDecimal balanceBefore;

    private BigDecimal balanceAfter;

    public Transfer() {
    }

    public Transfer(
            Account from,
            Account to,
            BigDecimal amount,
            Date date,
            AccCodeType accCodeType,
            BigDecimal balanceBefore,
            BigDecimal balanceAfter
    ) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
        this.accCodeType = accCodeType;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }

    public Transfer(
            long id,
            Account from,
            Account to,
            BigDecimal amount,
            Date date,
            AccCodeType accCodeType,
            BigDecimal balanceBefore,
            BigDecimal balanceAfter
    ) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
        this.accCodeType = accCodeType;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccCodeType getAccCodeType() {
        return accCodeType;
    }

    public void setAccCodeType(AccCodeType accCodeType) {
        this.accCodeType = accCodeType;
    }

    public BigDecimal getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(BigDecimal balanceBefore) {
        this.balanceBefore = balanceBefore;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return String.format(
                "От кого: %s\nКому: %s\nСумма: %f\nДата: %s\n",
                this.from.getId().toString(),
                this.to.getId().toString(),
                this.amount.doubleValue(),
                new SimpleDateFormat("dd.MM.yyy HH:mm:ss").format(this.date.getTime())
        );
    }
}
