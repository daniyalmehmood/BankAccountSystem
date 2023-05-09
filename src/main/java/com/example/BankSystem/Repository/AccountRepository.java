package com.example.BankSystem.Repository;

import com.example.BankSystem.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT id FROM customer WHERE phone = :phone", nativeQuery = true)
    Integer findIdByPhoneNumber(@Param("phone") String phone);

    @Query(value = "Select a.balance From Account a WHERE a.id = :id")
    Double getBalanceForAccount(@Param("id") Integer id);

    @Query(value = " select id from account where account_number=:accountNumber",nativeQuery = true)
    Integer getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    @Query(value = "Select a From Account a WHERE a.customer.id = :id")
    List<Account> getCustomerAccountInformation(@Param("id") Integer customerId);
}
