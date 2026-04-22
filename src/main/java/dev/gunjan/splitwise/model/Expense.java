package dev.gunjan.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @ManyToOne
    private User addedBy; // expense owner - who added the expense
    @OneToMany
    private List<UserExpense> userExpenses;



}
