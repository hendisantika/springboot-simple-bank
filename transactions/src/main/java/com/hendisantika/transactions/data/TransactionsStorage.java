package com.hendisantika.transactions.data;

import com.hendisantika.transactions.dto.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:18
 */
public interface TransactionsStorage {
    /**
     * Adds transaction for given account
     *
     * @param accountId Account ID
     * @param amount    Transaction amount
     * @return ID of created transaction
     */
    String addTransaction(String accountId, int amount);

    /**
     * Gets transasctions for given account
     *
     * @param accountId Account ID
     * @return Optional <code>List</code> of <code>Transaction</code> instances
     */
    Optional<List<Transaction>> getTransactions(String accountId);
}