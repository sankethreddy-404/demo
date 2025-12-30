package com.backend.demo.service;


import com.backend.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> createUsers(List<User> users);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User updateUser(int id,User updateduser);
    public void deleteUser(int id);

}
