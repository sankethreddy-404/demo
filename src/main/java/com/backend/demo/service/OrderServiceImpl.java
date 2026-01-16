package com.backend.demo.service;

import com.backend.demo.dto.OrderRequestDTO;
import com.backend.demo.dto.OrderResponseDTO;
import com.backend.demo.dto.PageResponseDTO;
import com.backend.demo.entity.Order;
import com.backend.demo.entity.User;
import com.backend.demo.exception.UserNotFoundException;
import com.backend.demo.mapper.OrderMapper;
import com.backend.demo.repository.OrderRepository;
import com.backend.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    public OrderServiceImpl(OrderRepository orderRepository,UserRepository userRepository,OrderMapper orderMapper){
        this.orderRepository=orderRepository;
        this.userRepository=userRepository;
        this.orderMapper=orderMapper;
    }
    @Override
    public OrderResponseDTO createOrder(int userId, OrderRequestDTO dto){
        User user=userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
        Order order=orderMapper.toEntity(dto,user);
        Order savedOrder=orderRepository.save(order);
        return orderMapper.toResponseDTO(savedOrder);
    }
    @Override
    public PageResponseDTO<OrderResponseDTO> getOrdersByUserId(int userId, int page, int size, String sortBy, String sortDir,String keyword,Integer minPrice,Integer maxPrice){
        validateUserExists(userId);
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Order> orderPage=orderRepository.searchOrdersByUser(userId,keyword,minPrice,maxPrice,pageable);
        List<OrderResponseDTO> orderDTOs=orderPage.getContent().stream().map(orderMapper::toResponseDTO).toList();
        PageResponseDTO<OrderResponseDTO> response = new PageResponseDTO<>();
        response.setContent(orderDTOs);
        response.setPageNumber(orderPage.getNumber());
        response.setPageSize(orderPage.getSize());
        response.setTotalElements(orderPage.getTotalElements());
        response.setTotalPages(orderPage.getTotalPages());
        response.setLast(orderPage.isLast());
        return response;
    }
    private void validateUserExists(int userId){
        userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user not found with id:"+userId));
    }
}
