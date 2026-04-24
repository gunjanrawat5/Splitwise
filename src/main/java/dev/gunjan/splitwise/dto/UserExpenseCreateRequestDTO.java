package dev.gunjan.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseCreateRequestDTO {
    private int userId;
    private double amount;
    private int expenseType;
}
