package com.backend.demo.repository;

import com.backend.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order,Integer> {
    Page<Order> findByUser_Id(int userId, Pageable pageable);


}
