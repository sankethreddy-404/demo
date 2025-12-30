package com.backend.demo.service;

import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    private List<User> users=new ArrayList<>();
    private int nextid=1;
    public List<User> createUsers(List<User> newusers){
        for(User user:newusers){
            user.setId(nextid++);
            users.add(user);
        }
        return users;
    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserById(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        throw new UserNotFoundException("User not found with id:" + id);

    }
    public User updateUser(int id,User updateduser){
        for(User user:users){
            if(user.getId()==id){
                user.setName(updateduser.getName());
                user.setEmail(updateduser.getEmail());
                return user;
            }
        }
        throw new UserNotFoundException("User not found with id:" + id);

    }
    public void deleteUser(int id){
        User userToDelete=null;

        for(User user:users){
            if(user.getId()==id){
                userToDelete=user;
                break;
            }
        }
        if(userToDelete!=null){
            users.remove(userToDelete);
            return;
        }
        throw new UserNotFoundException("User not found with id:"+id);
    }




}
