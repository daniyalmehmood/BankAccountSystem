package com.example.BankSystem.Service;

import com.example.BankSystem.Model.Account;
import com.example.BankSystem.Model.Customer;
import com.example.BankSystem.Repository.AccountRepository;
import com.example.BankSystem.Repository.CustomerRepository;
import com.example.BankSystem.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service


public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;
    public void addAccount(AccountRequest account) {
        Double interestVariable = 2.5; // variable for interest
        Account accountInfo = new Account();
        accountInfo.setAccountNumber(account.getAccountNumber());
        accountInfo.setBalance(account.getBalance());
        accountInfo.setInterest(account.getBalance() * interestVariable); // balance * interest Variable to get the profit
        Integer id = accountRepository.findIdByPhoneNumber(account.getPhone()); // find ID by unique variable (Phone)
        Customer customerId = customerRepository.findById(id).get() ;
        accountInfo.setCustomer(customerId);
        accountInfo.setIsActive(account.getIsActive());
        accountRepository.save(accountInfo);

    }

    public double getBalanceForAccount(Integer id) {
     return accountRepository.getBalanceForAccount(id);

    }

    public String makeMonthlyStatement(Integer accountId) {
        Account account = accountRepository.findById(accountId).get();
        Customer customer = account.getCustomer();
        LocalDate localDate = LocalDate.now();
        LocalDate statementDate = LocalDate.of(localDate.getYear(), localDate.getMonth(),1);

        String statementOfAccount = "Monthly Statement Of Account :"+account.getAccountNumber()+
                "\n Customer Name :"+customer.getName() +
                "\n Customer Email :"+customer.getEmail()+
                "\n Customer Phone :"+customer.getPhone()+
                "\n Date"+"\t"+localDate.getYear()+"\t"+localDate.getMonth()+"\t"+localDate.getDayOfMonth()+
                "\n Account Balance :"+account.getBalance();

        return statementOfAccount;
    }
}
