package org.enset.bankaccountservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany (mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY )  //concerne seulement RESTE et pour GraphQL rien ne se change
    private List<BankAccount> bankAccounts;

}
