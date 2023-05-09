package com.example.BankSystem.Repository;

import com.example.BankSystem.Model.Account;
import com.example.BankSystem.Model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}
