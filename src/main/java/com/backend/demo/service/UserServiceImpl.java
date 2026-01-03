package com.backend.demo.service;

import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.model.User;
import com.backend.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserResponseDTO createUser(UserRequestDTO dto){
        User user=new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        User savedUser=userRepository.save(user);

        return mapToResponseDTO(savedUser);
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> users=userRepository.findAll();
        List<UserResponseDTO> response=new ArrayList<>();
        for(User user:users){
            UserResponseDTO dto=new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            response.add(dto);
        }
        return response;
    }
    @Override
    public UserResponseDTO getUserById(int id){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found with id:"+id));
        return mapToResponseDTO(user);
    }
    @Override
    public UserResponseDTO updateUser(int id,UserRequestDTO dto){
        User existingUser=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id:" +id));
        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        User updateUser=userRepository.save(existingUser);
        return mapToResponseDTO(updateUser);

    }
    @Override
    public void  deleteUser(int id){
        User user=userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));
        userRepository.delete(user);
    }
    private UserResponseDTO mapToResponseDTO(User user){
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
