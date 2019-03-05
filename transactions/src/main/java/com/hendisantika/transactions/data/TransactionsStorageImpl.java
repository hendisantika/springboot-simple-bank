package com.hendisantika.transactions.data;

import com.hendisantika.transactions.dto.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:19
 */
@Repository
@Scope("singleton")
public final class TransactionsStorageImpl implements TransactionsStorage {
    private final Map<String, List<Transaction>> data = new HashMap<>();

    @Override
    public synchronized String addTransaction(String accountId, int amount) {
        Transaction transaction = new Transaction(accountId, amount);
        if (!data.containsKey(accountId)) {
            data.put(accountId, new ArrayList<>());
            data.get(accountId).add(transaction);
        } else {
            data.get(accountId).add(transaction);
        }

        return transaction.getId();
    }

    @Override
    public synchronized Optional<List<Transaction>> getTransactions(String accountId) {
        if (!data.containsKey(accountId)) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(data.get(accountId)));
    }
}