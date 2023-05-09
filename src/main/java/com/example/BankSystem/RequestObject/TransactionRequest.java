package com.example.BankSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TransactionRequest {

    private Double amount;

    private Integer accountNumber;
    private String isActive;

}
