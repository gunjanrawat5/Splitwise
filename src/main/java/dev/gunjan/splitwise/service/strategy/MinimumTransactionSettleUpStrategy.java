package dev.gunjan.splitwise.service.strategy;

import dev.gunjan.splitwise.constant.UserExpenseType;
import dev.gunjan.splitwise.dto.SettleUpTransactionResponseDTO;
import dev.gunjan.splitwise.model.Expense;
import dev.gunjan.splitwise.model.Group;
import dev.gunjan.splitwise.model.User;
import dev.gunjan.splitwise.model.UserExpense;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumTransactionSettleUpStrategy implements SettleUpStrategy{


    @Override
    public SettleUpTransactionResponseDTO settleUp(Group group) {
        HashMap<User,Integer> finalAmountPerUser = new HashMap<>();
        List<Expense> expenses = group.getExpenses();
        for(Expense expense: expenses){
            for(UserExpense userExpense: expense.getUserExpenses()){
                if(finalAmountPerUser.containsKey(userExpense.getUser())){
                    int currentAmount = finalAmountPerUser.get(userExpense.getUser());
                    if(userExpense.getUserExpenseType().equals(UserExpenseType.HAS_PAID)){
                        currentAmount += userExpense.getAmount();
                    } else{
                        currentAmount-= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(),currentAmount);
                } else{
                    int currentAmount = 0;
                    if(userExpense.getUserExpenseType().equals(UserExpenseType.HAS_PAID)){
                        currentAmount += userExpense.getAmount();
                    } else{
                        currentAmount-= userExpense.getAmount();
                    }
                    finalAmountPerUser.put(userExpense.getUser(),currentAmount);
                }
            }
        }


        return null;
    }
}
