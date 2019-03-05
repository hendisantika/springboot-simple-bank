package com.hendisantika.transactions.controller;

import com.hendisantika.transactions.dto.Transaction;
import com.hendisantika.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-simple-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-05
 * Time: 07:21
 */
@RestController
@RequestMapping(value = "/transactions")
public class TransactionsRestController {
    @Autowired
    private TransactionsService transactionsService;


    @RequestMapping(method = RequestMethod.POST)
    public String addTransaction(@RequestParam("accountId") String accountId, @RequestParam("amount") Integer amount) {
        return transactionsService.addTransaction(accountId, amount);
    }

    @RequestMapping(value = "{accountId}/{limit}", method = RequestMethod.GET)
    public List<Transaction> getTansactions(@PathVariable String accountId, @PathVariable Integer limit) {
        return transactionsService.getTransactions(accountId, limit == null ? -1 : limit);
    }
}