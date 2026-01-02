package com.backend.demo.service;

import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.model.User;
import com.backend.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public List<User> createUsers(List<User> newUsers){
        return userRepository.saveAll(newUsers);
    }
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User getUserById(int id){
       return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found with id:"+id));
    }
    @Override
    public User updateUser(int id,User updateduser){
        User existingUser=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id:" +id));
        existingUser.setName(updateduser.getName());
        existingUser.setEmail(updateduser.getEmail());
        return userRepository.save(existingUser);

    }
    @Override
    public void deleteUser(int id){
        User user=userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));
        userRepository.delete(user);
    }
}
