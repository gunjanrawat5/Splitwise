package dev.gunjan.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "expense_id")
    private List<UserExpense> userExpenses;



}
