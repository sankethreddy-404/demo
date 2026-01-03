package com.backend.demo.repository;

import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
