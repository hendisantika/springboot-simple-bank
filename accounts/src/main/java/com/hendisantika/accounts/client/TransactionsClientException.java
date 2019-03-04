package com.hendisantika.accounts.client;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 06:58
 */
public class TransactionsClientException extends Exception {
    public TransactionsClientException(String message) {
        super(message);
    }

    public TransactionsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}