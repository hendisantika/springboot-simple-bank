package com.hendisantika.transactions.service;

import com.hendisantika.transactions.dto.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:20
 */
public interface TransactionsService {
    /**
     * Adds new transaction for given <code>accountId</code> with given <code>amount</code>.
     *
     * @param accountId Account id.
     * @param amount    Amount. Can be both positive and negative.
     * @return Created transaction id.
     */
    String addTransaction(String accountId, int amount);

    /**
     * Gets last <code>limit</code> transactions for given <code>accountId</code>.
     * If <code>limit</code> is less than 1, all transactions for for given <code>accountId</code> will be returned.
     *
     * @param accountId Account id
     * @param limit     Amount of last transaction to be returned.
     * @return List of transactions. Empty list if there are no transactions for given <code>accountId</code>.
     */
    List<Transaction> getTransactions(String accountId, int limit);
}