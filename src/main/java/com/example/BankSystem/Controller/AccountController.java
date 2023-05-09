package com.example.BankSystem.Controller;

import com.example.BankSystem.Model.Account;
import com.example.BankSystem.Model.Customer;
import com.example.BankSystem.RequestObject.AccountRequest;
import com.example.BankSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody AccountRequest account) {
        try {
            accountService.addAccount(account);
            return "Account added Successfully";
        } catch (Exception e) {
            return "Account added Failed";
        }


    } @RequestMapping(value = "getBalanceForAccount", method = RequestMethod.GET)
    public double getBalanceForAccount(@RequestParam Integer id) {
    return accountService.getBalanceForAccount(id);
    }






}
