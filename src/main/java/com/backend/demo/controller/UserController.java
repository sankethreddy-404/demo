package com.backend.demo.controller;
import com.backend.demo.dto.APIResponse;
import com.backend.demo.dto.PageResponseDTO;
import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.dto.UserResponseDTO;
import com.backend.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@Tag(name="Users",description="User management APIs")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<APIResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO response=userService.createUser(dto);
        APIResponse<UserResponseDTO> apiResponse=new APIResponse<>(LocalDateTime.now(), HttpStatus.CREATED.value(),"User added successfully",response);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/bulk")
    public ResponseEntity<APIResponse<List<UserResponseDTO>>> createUsersBulk(@Valid @RequestBody List<@Valid UserRequestDTO> dto){
        List<UserResponseDTO> users=userService.createUsersBulk(dto);
        APIResponse<List<UserResponseDTO>> response=new APIResponse<>(LocalDateTime.now(),HttpStatus.CREATED.value(),"Bulk users added successfully",users);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<APIResponse<PageResponseDTO<UserResponseDTO>>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue="5") int size,
                                                                        @RequestParam(defaultValue = "id") String sortBy,
                                                                        @RequestParam(defaultValue = "asc") String sortDir,
                                                                        @RequestParam (required = false) String keyword) {
        PageResponseDTO<UserResponseDTO> response=userService.getAllUsers(page,size,sortBy,sortDir,keyword);
        APIResponse<PageResponseDTO<UserResponseDTO>> apiResponse=new APIResponse<>(LocalDateTime.now(),HttpStatus.OK.value(),"All users fetched successfully",response);
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<APIResponse<UserResponseDTO>> getUserById(@PathVariable int id) {
        UserResponseDTO responseList= userService.getUserById(id);
        APIResponse<UserResponseDTO> response=new APIResponse<>(LocalDateTime.now(),HttpStatus.OK.value(),"user by id fetched successfully",responseList);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<APIResponse<UserResponseDTO>> updateUser(
            @PathVariable int id,
            @RequestBody UserRequestDTO dto) {
        UserResponseDTO responseList=userService.updateUser(id,dto);
        APIResponse<UserResponseDTO> response=new APIResponse<>(LocalDateTime.now(),HttpStatus.OK.value(),"User updated successfully",responseList);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<APIResponse<String>> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        APIResponse<String> apiResponse=new APIResponse<>(LocalDateTime.now(),HttpStatus.OK.value(),"User Deleted Successfully",null);
        return ResponseEntity.ok(apiResponse);
    }


}