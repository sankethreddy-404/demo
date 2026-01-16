package com.backend.demo.repository;

import com.backend.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Page<User> findByNameContainingOrEmailContaining(String name,String email,Pageable pageable);

}
