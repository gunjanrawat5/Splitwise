package dev.gunjan.splitwise.service;

import dev.gunjan.splitwise.dto.ExpenseCreateRequestDTO;
import dev.gunjan.splitwise.dto.UserExpenseCreateRequestDTO;
import dev.gunjan.splitwise.model.Expense;
import dev.gunjan.splitwise.model.UserExpense;
import dev.gunjan.splitwise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private GroupService groupService;

    public Expense createExpense(ExpenseCreateRequestDTO requestDTO, int groupId){
        Expense expense = new Expense();
        expense.setAmount(requestDTO.getAmount());
        expense.setDescription(requestDTO.getDescription());
        expense.setAddedBy(userService.findById(requestDTO.getExpenseAddedById()));
        List<UserExpense> userExpenses = new ArrayList<>();
        for(UserExpenseCreateRequestDTO dtos : requestDTO.getUserExpenses()){
            userExpenses.add(userExpenseService.createUserExpense(dtos));
        }
        expense.setUserExpenses(userExpenses);
        Expense savedExpense = expenseRepository.save(expense);
        groupService.addExpenseToGroup(expense,groupId);
        return savedExpense;
    }
}
