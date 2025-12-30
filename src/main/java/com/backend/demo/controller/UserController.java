package com.backend.demo.controller;
import com.backend.demo.model.User;
import com.backend.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users ){
        List<User> createdUsers=userService.createUsers(users);
        return new ResponseEntity<>(createdUsers,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User updatedUser) {
        User user=userService.updateUser(id,updatedUser);

        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser ( @PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


}
