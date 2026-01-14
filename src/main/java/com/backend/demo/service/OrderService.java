package com.backend.demo.service;

import com.backend.demo.dto.OrderRequestDTO;
import com.backend.demo.dto.OrderResponseDTO;
import com.backend.demo.dto.PageResponseDTO;


public interface OrderService {
    public OrderResponseDTO createOrder(int userId, OrderRequestDTO dto);
    public PageResponseDTO<OrderResponseDTO> getOrdersByUserId(int userId, int page, int size, String sortBy, String sortDir);
}
