package dev.gunjan.splitwise.model;

import dev.gunjan.splitwise.constant.UserExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
    private double amount;
}
