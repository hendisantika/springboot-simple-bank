package com.hendisantika.accounts.data;

import com.hendisantika.accounts.dto.Account;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 06:56
 */
public interface AccountsStorage {
    /**
     * Add new account for given Customer
     *
     * @param customerId Customer ID
     * @param name       Account name
     * @return
     */
    String addAccount(String customerId, String name);

    /**
     * Deletes account
     *
     * @param customerId Customer ID
     * @param accountId  Account ID
     */
    void deleteAccount(String customerId, String accountId);

    /**
     * Gets accounts for given customer
     *
     * @param customerId Customer ID
     * @return Optional <code>List</code> of <code>Account</code> instances.
     */
    Optional<List<Account>> getAccounts(String customerId);
}
