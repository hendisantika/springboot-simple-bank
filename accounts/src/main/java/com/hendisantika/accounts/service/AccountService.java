package com.hendisantika.accounts.service;

import com.hendisantika.accounts.dto.Account;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 06:59
 */
public interface AccountService {
    /**
     * Adds new account for given <code>customerId</code> with given <code>name</code> and <code>initialCredit</code>.
     *
     * @param customerId    Customer id.
     * @param name          Account user name.
     * @param initialCredit Initial credit. Can be both positive and negative.
     * @return Created account id.
     */
    String addAccount(String customerId, String name, int initialCredit) throws AccountsException;

    /**
     * Gets accounts for given <code>customerId</code>.
     *
     * @param customerId Customer id
     * @return List of accounts. Empty list if there are no accounts for given <code>customerId</code>.
     */
    List<Account> getAccounts(String customerId);
}