package dev.gunjan.splitwise.model;

import jakarta.persistence.*;
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
    @JoinColumn(name = "group_id")
    private List<Expense> expenses; // record of money spent -> who paid how much and who owes how much
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Transaction> transactions; // who needs to pay whom to clear debts(settle up!)
    private boolean isAllSettlementDone;
}
