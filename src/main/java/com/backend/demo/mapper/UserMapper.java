package com.backend.demo.mapper;

import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.entity.User;
import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.repository.UserRepository;

public class UserMapper {
    public static User toEntity(UserRequestDTO dto){
        User user=new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
    public static UserResponseDTO toResponseDTO(User user){
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
    public static void updateEntity(User user,UserRequestDTO dto){
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
    }

}
