package com.example.BankSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double balance;
    Integer accountNumber;
    Double interest;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customer; // many account to one customer


}
