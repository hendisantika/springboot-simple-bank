package com.hendisantika.transactions.service;

import com.hendisantika.transactions.data.TransactionsStorage;
import com.hendisantika.transactions.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:21
 */
@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsStorage transactionsStorage;

    @Override
    public String addTransaction(String accountId, int amount) {
        return transactionsStorage.addTransaction(accountId, amount);
    }

    @Override
    public List<Transaction> getTransactions(String accountId, int limit) {
        Optional<List<Transaction>> transactions = transactionsStorage.getTransactions(accountId);
        if (!transactions.isPresent()) {
            return new ArrayList<>();
        }

        List<Transaction> transactionsList = transactions.get();

        if (limit <= 0) {
            return transactionsList;
        }

        return transactionsList.subList(Math.max(transactionsList.size() - limit, 0), transactionsList.size());
    }
}