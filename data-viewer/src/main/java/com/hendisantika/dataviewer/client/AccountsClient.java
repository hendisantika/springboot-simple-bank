package com.hendisantika.dataviewer.client;

import com.hendisantika.dataviewer.dto.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:32
 */
@Service
public class AccountsClient {
    @Value("${get.accounts.service.url}")
    private String getAccountsServiceUrl;

    public List<Account> getAccountsForCustomerId(String customerId) throws AccountsClientException {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format(getAccountsServiceUrl, customerId);
        try {
            return Arrays.asList(restTemplate.getForObject(url, Account[].class));
        } catch (RestClientException e) {
            throw new AccountsClientException("Accounts could not be loaded for customer id: " + customerId, e);
        }
    }
}