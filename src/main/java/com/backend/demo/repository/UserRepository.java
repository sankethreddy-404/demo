package com.backend.demo.repository;

import com.backend.demo.dto.UserRequestDTO;
import com.backend.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Page<User> findByNameContainingOrEmailContaining(String name,String email,Pageable pageable);
}
