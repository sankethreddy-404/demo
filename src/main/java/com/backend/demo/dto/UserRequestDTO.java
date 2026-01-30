package com.backend.demo.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email(message ="Invalid email format")
    @NotBlank(message="Email cannot be empty")
    private  String email;
    @NotBlank(message="password cannot be empty")
    private String password;

    public @NotBlank(message = "Role cannot be empty") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Role cannot be empty") String role) {
        this.role = role;
    }

    @NotBlank(message="Role cannot be empty")
    private String role;
    public @NotBlank(message = "password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password cannot be empty") String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
