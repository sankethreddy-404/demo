package com.backend.demo.service;

import com.backend.demo.dto.PageResponseDTO;
import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.entity.User;
import com.backend.demo.mapper.UserMapper;
import com.backend.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public UserResponseDTO createUser(UserRequestDTO dto){
        User user= UserMapper.toEntity(dto,passwordEncoder);

        User savedUser=userRepository.save(user);
        return UserMapper.toResponseDTO(savedUser);
    }
    @Override
    public List<UserResponseDTO> createUsersBulk(List<UserRequestDTO> users){
        List<User> entities=new ArrayList<>();
        for(UserRequestDTO dto:users){
            entities.add(UserMapper.toEntity(dto,passwordEncoder));
        }
        List<User> savedUsers=userRepository.saveAll(entities);
        List<UserResponseDTO> response=new ArrayList<>();
        for(User user:savedUsers){
            response.add(UserMapper.toResponseDTO(user));
        }
        return response;
    }
    @Override
    public PageResponseDTO<UserResponseDTO> getAllUsers(int page, int size, String sortBy, String sortDir,String keyword) {
        Sort sort=sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<User> usersPage;

        if(keyword!=null && !keyword.trim().isEmpty()){
            usersPage=userRepository.findByNameContainingOrEmailContaining(keyword.trim(),keyword.trim(),pageable);
        }
        else {
            usersPage = userRepository.findAll(pageable);
        }
        List<UserResponseDTO> responseList=new ArrayList<>();
        for(User user: usersPage.getContent()){
            responseList.add(UserMapper.toResponseDTO(user));
        }
        PageResponseDTO<UserResponseDTO> response= new PageResponseDTO<>();
        response.setContent(responseList);
        response.setPageNumber(usersPage.getNumber());
        response.setPageSize(usersPage.getSize());
        response.setTotalElements(usersPage.getTotalElements());
        response.setTotalPages(usersPage.getTotalPages());
        response.setLast(usersPage.isLast());
        return response;
    }
    @Override
    public UserResponseDTO getUserById(int id){
        User user=getUserOrThrow(id);
        return UserMapper.toResponseDTO(user);
    }
    @Override
    public UserResponseDTO updateUser(int id,UserRequestDTO dto){
        User existingUser=getUserOrThrow(id);
        UserMapper.updateEntity(existingUser,dto);
        User updateUser=userRepository.save(existingUser);
        return UserMapper.toResponseDTO(updateUser);
    }
    @Override
    public void  deleteUser(int id){
        User user=getUserOrThrow(id);
        userRepository.delete(user);
    }
    private User getUserOrThrow(int id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: "+id));
    }


}
