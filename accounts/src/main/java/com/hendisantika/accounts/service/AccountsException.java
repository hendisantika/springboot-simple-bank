package com.hendisantika.accounts.service;

import com.hendisantika.accounts.client.TransactionsClientException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 06:59
 */
public class AccountsException extends Exception {
    public AccountsException(String s, TransactionsClientException e) {
        super(s, e);
    }
}