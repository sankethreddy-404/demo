package com.backend.demo.controller;
import com.backend.demo.dto.APIResponse;
import com.backend.demo.dto.PageResponseDTO;
import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<APIResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO response=userService.createUser(dto);
        APIResponse<UserResponseDTO> apiResponse=new APIResponse<>(LocalDateTime.now(), HttpStatus.CREATED.value(),"User created successfully",response);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PostMapping("/bulk")
    public ResponseEntity<APIResponse<List<UserResponseDTO>>> createUsersBulk(@Valid @RequestBody List<UserRequestDTO> dto){
        List<UserResponseDTO> users=userService.createUsersBulk(dto);
        APIResponse<List<UserResponseDTO>> response=new APIResponse<>(LocalDateTime.now(),HttpStatus.CREATED.value(),"created bulk users successfully",users);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<APIResponse<PageResponseDTO<UserResponseDTO>>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue="5") int size,
                                                                        @RequestParam(defaultValue = "id") String sortBy,
                                                                        @RequestParam(defaultValue = "asc") String sortDir,
                                                                        @RequestParam (required = false) String keyword) {
        PageResponseDTO<UserResponseDTO> response=userService.getAllUsers(page,size,sortBy,sortDir,keyword);
        APIResponse<PageResponseDTO<UserResponseDTO>> apiResponse=new APIResponse<>(LocalDateTime.now(),HttpStatus.CREATED.value(),"users fetch successfully",response);
        return ResponseEntity.ok(apiResponse);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable int id,
            @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}