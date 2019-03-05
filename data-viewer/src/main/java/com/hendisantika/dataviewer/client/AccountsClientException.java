package com.hendisantika.dataviewer.client;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:32
 */
public class AccountsClientException extends Exception {
    public AccountsClientException(String message) {
        super(message);
    }

    public AccountsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}