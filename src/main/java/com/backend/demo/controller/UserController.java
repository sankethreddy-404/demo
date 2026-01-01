package com.backend.demo.controller;
import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.model.User;
import com.backend.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping
    public ResponseEntity<List<UserResponseDTO>> createUsers(
           @RequestBody @Valid List<@Valid UserRequestDTO> requestDTOs) {
        List<User> users = new ArrayList<>();

        for (UserRequestDTO dto : requestDTOs) {
            User user = new User();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            users.add(user);
        }

        List<User> savedUsers = userService.createUsers(users);


        List<UserResponseDTO> response = new ArrayList<>();

        for (User user : savedUsers) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            response.add(dto);
        }


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable int id,
            @RequestBody UserRequestDTO requestDTO) {

        User updatedUser = new User();
        updatedUser.setName(requestDTO.getName());
        updatedUser.setEmail(requestDTO.getEmail());


        User user = userService.updateUser(id, updatedUser);


        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());


        return ResponseEntity.ok(responseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser ( @PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {


        List<User> users = userService.getAllUsers();

        List<UserResponseDTO> response = new ArrayList<>();

        for (User user : users) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            response.add(dto);
        }

        // 3. Return response
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable int id) {


        User user = userService.getUserById(id);


        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return ResponseEntity.ok(dto);
    }
    private User convertToUser(UserRequestDTO dto){
        User user=new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
    private UserResponseDTO convertToResponseDTO(User user){
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }



}
