package dev.gunjan.splitwise.controller;

import dev.gunjan.splitwise.dto.ExpenseCreateRequestDTO;
import dev.gunjan.splitwise.model.Expense;
import dev.gunjan.splitwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @PostMapping("/expense/{groupId}")
    public ResponseEntity<Expense> createExpenseInGroup(@RequestBody ExpenseCreateRequestDTO requestDTO, @PathVariable("groupId") int groupId){
        return  ResponseEntity.ok(expenseService.createExpense(requestDTO, groupId));
    }

}
