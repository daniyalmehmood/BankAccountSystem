package com.example.BankSystem.Service;

import com.example.BankSystem.Model.Account;
import com.example.BankSystem.Model.Transaction;
import com.example.BankSystem.Repository.AccountRepository;
import com.example.BankSystem.Repository.TransactionRepository;
import com.example.BankSystem.RequestObject.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    public String createTransaction(TransactionRequest transactionRequest){
        Transaction transaction=new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        Integer id=accountRepository.getAccountByAccountNumber(transactionRequest.getAccountNumber());
        Account account=accountRepository.findById(id).get();
        transaction.setIsActive(account.getIsActive()); // if account is active then transaction is active
        transaction.setAccount(account);
        Double transactionAmount= transactionRequest.getAmount();
        Double accountBalance=account.getBalance();
        Double newBalance=accountBalance-transactionAmount;
        account.setBalance(newBalance);
        accountRepository.save(account);
        transactionRepository.save(transaction);
        return "Transaction done successfully";

    }
}
