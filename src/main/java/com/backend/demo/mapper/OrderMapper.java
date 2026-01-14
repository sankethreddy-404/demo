package com.backend.demo.mapper;

import com.backend.demo.dto.OrderRequestDTO;
import com.backend.demo.dto.OrderResponseDTO;
import com.backend.demo.entity.Order;
import com.backend.demo.entity.User;
import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequestDTO dto, User user){

        Order order=new Order();
        order.setProductName(dto.getProductName());
        order.setPrice(dto.getPrice());
        order.setUser(user);
        return order;
    }
    public OrderResponseDTO toResponseDTO(Order order){
        OrderResponseDTO dto=new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setProductName(order.getProductName());
        dto.setPrice(order.getPrice());
        dto.setUserId(order.getUser().getId());
        return dto;
    }
}
