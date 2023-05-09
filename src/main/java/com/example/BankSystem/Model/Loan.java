package com.example.BankSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class Loan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double amount;
    Double interestRate;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customer; // many Loan to one customer


}
