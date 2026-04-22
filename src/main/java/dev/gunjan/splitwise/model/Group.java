package dev.gunjan.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User createdBy;
    private double totalAmountSpend;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses; // record of money spent -> who paid how much and who owes how much
    @OneToMany
    private List<Transaction> transactions; // who needs to pay whom to clear debts(settle up!)

}
