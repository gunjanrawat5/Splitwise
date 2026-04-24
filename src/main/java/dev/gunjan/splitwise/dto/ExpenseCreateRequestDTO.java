package dev.gunjan.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExpenseCreateRequestDTO {
    private String description;
    private double amount;
    private int expenseAddedById;
    private List<UserExpenseCreateRequestDTO> userExpenses;

}
