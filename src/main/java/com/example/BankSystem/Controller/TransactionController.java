package com.example.BankSystem.Controller;

import com.example.BankSystem.RequestObject.AccountRequest;
import com.example.BankSystem.RequestObject.TransactionRequest;
import com.example.BankSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping(value = "makeTransaction", method = RequestMethod.POST)
    public String makeTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
            return "Transaction made Successfully";
        } catch (Exception e) {
            return "Transaction Failed";
        }
    }

}
