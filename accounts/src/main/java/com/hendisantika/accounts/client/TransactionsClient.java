package com.hendisantika.accounts.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 06:58
 */
@Service
public class TransactionsClient {
    @Value("${create.transaction.service.url}")
    private String transactionsServiceUrl;

    public String createTransaction(String accountId, int amount) throws TransactionsClientException {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format(transactionsServiceUrl, accountId, amount);
        try {
            return restTemplate.postForObject(url, null, String.class);
        } catch (RestClientException e) {
            throw new TransactionsClientException("Transaction could not be created for account id: " + accountId, e);
        }
    }
}