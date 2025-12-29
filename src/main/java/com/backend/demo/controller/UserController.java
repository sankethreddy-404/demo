package com.backend.demo.controller;
import com.backend.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    private List<User> users=new ArrayList<>();
    private int nextid=1;
    @PostMapping("/users")
    public ResponseEntity<List<User>> createuser(@RequestBody List<User> newusers ){

        for(User user:newusers){
            user.setId(nextid++);
            users.add(user);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateuser(@PathVariable int id,@RequestBody User updateduser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updateduser.getName());
                user.setEmail(updateduser.getEmail());
                return ResponseEntity.ok(user);
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteuser ( @PathVariable int id){
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    @GetMapping("/users")
    public List<User> getusers(){
        return users;
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getuserbyid(@PathVariable int id){
        for(User user:users){
            if(user.getId()==id){
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }


}
