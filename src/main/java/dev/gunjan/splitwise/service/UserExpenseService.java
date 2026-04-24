package dev.gunjan.splitwise.service;

import dev.gunjan.splitwise.constant.UserExpenseType;
import dev.gunjan.splitwise.dto.UserExpenseCreateRequestDTO;
import dev.gunjan.splitwise.model.UserExpense;
import dev.gunjan.splitwise.repository.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpenseService {
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    private UserService userService;

    public UserExpense createUserExpense(UserExpenseCreateRequestDTO requestDTO){
        UserExpense userExpense = new UserExpense();
        userExpense.setAmount(requestDTO.getAmount());
        userExpense.setUser(userService.findById(requestDTO.getUserId()));
        if(requestDTO.getExpenseType()==1){
            userExpense.setUserExpenseType(UserExpenseType.HAS_PAID);
        }
        else{
            userExpense.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        }
        return userExpenseRepository.save(userExpense);
    }
}
