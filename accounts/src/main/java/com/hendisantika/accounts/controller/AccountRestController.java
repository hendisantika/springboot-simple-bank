package com.hendisantika.accounts.controller;

import com.hendisantika.accounts.dto.Account;
import com.hendisantika.accounts.service.AccountService;
import com.hendisantika.accounts.service.AccountsException;
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
 * Time: 07:02
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public String createAccount(@RequestParam("customerId") String customerId,
                                @RequestParam("name") String name,
                                @RequestParam("initialCredit") Integer initialCredit) throws AccountsException {
        return accountService.addAccount(customerId, name, initialCredit == null ? 0 : initialCredit);
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public List<Account> getAccounts(@PathVariable String customerId) {
        return accountService.getAccounts(customerId);
    }
}