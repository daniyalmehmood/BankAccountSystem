package com.example.BankSystem.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer creditCardNumber;
    Double payment;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customer; // many account to one customer

}
