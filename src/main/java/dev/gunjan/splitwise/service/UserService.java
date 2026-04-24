package dev.gunjan.splitwise.service;

import dev.gunjan.splitwise.exception.UserNotFoundException;
import dev.gunjan.splitwise.model.User;
import dev.gunjan.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User with given id not found")
        );
    }





}
