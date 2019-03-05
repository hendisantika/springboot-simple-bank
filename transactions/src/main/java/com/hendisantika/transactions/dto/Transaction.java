package com.hendisantika.transactions.dto;

import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:17
 */
public final class Transaction {
    private String id;

    private Date time;

    private String accountId;

    private int amount;

    public Transaction(String accountId, int amount) {
        this.id = UUID.randomUUID().toString();
        this.time = new Date();
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Date getTime() {
        return new Date(time.getTime());
    }

    public String getAccountId() {
        return accountId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        if (!id.equals(that.id)) return false;
        if (!time.equals(that.time)) return false;
        return accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + accountId.hashCode();
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
