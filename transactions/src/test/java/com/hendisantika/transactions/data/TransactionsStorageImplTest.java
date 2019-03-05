package com.hendisantika.transactions.data;

import com.hendisantika.transactions.dto.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:22
 */
public class TransactionsStorageImplTest {
    @Test
    public void testAddGet() {
        TransactionsStorage transactionsStorage = new TransactionsStorageImpl();
        String transaction11Id = transactionsStorage.addTransaction("Account1", 150);
        String transaction21Id = transactionsStorage.addTransaction("Account2", 70);
        String transaction12Id = transactionsStorage.addTransaction("Account1", 80);

        Optional<List<Transaction>> result = transactionsStorage.getTransactions("Account1");

        assertEquals(2, result.get().size());
        assertEquals(transaction11Id, result.get().get(0).getId());
        assertEquals(150, result.get().get(0).getAmount());
        assertEquals(transaction12Id, result.get().get(1).getId());
        assertEquals(80, result.get().get(1).getAmount());

        assertEquals(Optional.empty(), transactionsStorage.getTransactions("XXX"));
    }
}