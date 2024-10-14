package org.enset.bankaccountservice;

import org.enset.bankaccountservice.entities.BankAccount;
import org.enset.bankaccountservice.entities.Customer;
import org.enset.bankaccountservice.enums.AccountType;
import org.enset.bankaccountservice.repositories.BankAccountRepository;
import org.enset.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {

            Stream.of("Meriame", "Hanane", "Razane", "Yasmine").forEach(c -> {
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);


                for (int i = 0; i < 2; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(Math.random() * 90000 + 10000)
                            .createAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }

}
