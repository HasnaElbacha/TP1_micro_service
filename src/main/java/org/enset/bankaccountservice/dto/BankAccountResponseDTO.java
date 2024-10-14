package org.enset.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.enset.bankaccountservice.enums.AccountType;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.enset.bankaccountservice.enums.AccountType;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor  @Builder
public class BankAccountResponseDTO {

    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
