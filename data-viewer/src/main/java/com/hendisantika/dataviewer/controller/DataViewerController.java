package com.hendisantika.dataviewer.controller;

import com.hendisantika.dataviewer.client.AccountsClientException;
import com.hendisantika.dataviewer.client.TransactionsClientException;
import com.hendisantika.dataviewer.dto.Customer;
import com.hendisantika.dataviewer.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-06
 * Time: 06:14
 */
@RestController
@RequestMapping(value = "/data/")
public class DataViewerController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getDataForCustomerId(@PathVariable String customerId) throws AccountsClientException, TransactionsClientException {
        return dataService.getDataForCustomer(customerId);
    }
}