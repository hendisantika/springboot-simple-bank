package com.hendisantika.dataviewer.client;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:33
 */
public class TransactionsClientException extends Exception {
    public TransactionsClientException(String message) {
        super(message);
    }

    public TransactionsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}