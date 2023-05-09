package com.example.BankSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// Request Class is to get everything you want,
// and put it in one class (it communicates with user Input)
@Getter
@Setter
@Data
public class AccountRequest {

    Double balance;
    Integer accountNumber;
    String phone;
    String isActive;

}
