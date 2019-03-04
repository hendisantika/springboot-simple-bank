package com.hendisantika.accounts.data;

import com.hendisantika.accounts.dto.Account;
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
 * Time: 06:57
 */
@Repository
@Scope("singleton")
public final class AccountsStorageImpl implements AccountsStorage {
    private final Map<String, List<Account>> data = new HashMap<>();

    public synchronized String addAccount(String customerId, String name) {
        Account account = new Account(customerId, name);
        if (!data.containsKey(customerId)) {
            data.put(customerId, new ArrayList<>());
            data.get(customerId).add(account);
        } else {
            data.get(customerId).add(account);
        }

        return account.getId();
    }

    public synchronized void deleteAccount(String customerId, String accountId) {
        if (data.containsKey(customerId)) {
            data.get(customerId).removeIf(account -> account.getId().equals(accountId));
        }
    }

    public synchronized Optional<List<Account>> getAccounts(String customerId) {
        if (!data.containsKey(customerId)) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(data.get(customerId)));
    }
}