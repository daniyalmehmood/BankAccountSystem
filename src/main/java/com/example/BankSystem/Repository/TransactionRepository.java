package com.example.BankSystem.Repository;

import com.example.BankSystem.Model.Account;
import com.example.BankSystem.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccount(Account account); // get the Transaction list from account
}
