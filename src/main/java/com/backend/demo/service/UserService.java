package com.backend.demo.service;


import com.backend.demo.dto.PageResponseDTO;
import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.model.User;

import java.util.List;

public interface UserService {
    public UserResponseDTO createUser(UserRequestDTO user);
    public PageResponseDTO<UserResponseDTO> getAllUsers(int page, int size, String soryBy, String sortDir,String nameOrEmail);
    public UserResponseDTO getUserById(int id);
    public UserResponseDTO updateUser(int id,UserRequestDTO updateduser);
    public void  deleteUser(int id);

}
