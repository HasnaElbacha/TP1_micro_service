package org.enset.bankaccountservice.services;

import org.enset.bankaccountservice.dto.BankAccountRequestDTO;
import org.enset.bankaccountservice.dto.BankAccountResponseDTO;
import org.enset.bankaccountservice.entities.BankAccount;
import org.enset.bankaccountservice.mappers.AccountMapper;
import org.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper  accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }


    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
