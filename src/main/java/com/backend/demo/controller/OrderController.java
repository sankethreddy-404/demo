package com.backend.demo.controller;

import com.backend.demo.dto.*;
import com.backend.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<APIResponse<OrderResponseDTO>> createOrder(@PathVariable int userId, @RequestBody OrderRequestDTO dto){
        OrderResponseDTO response= orderService.createOrder(userId,dto);
        APIResponse<OrderResponseDTO> apiResponse=new APIResponse<>(LocalDateTime.now(),201,"Order created successfully",response);
        return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<APIResponse<PageResponseDTO<OrderResponseDTO>>> getAllOrders(@PathVariable int userId,
                                                                                    @RequestParam (defaultValue ="0") int page,
                                                                                    @RequestParam(defaultValue = "5") int size,
                                                                                    @RequestParam(defaultValue="id")String sortBy,
                                                                                    @RequestParam(defaultValue = "asc") String sortDir,
                                                                                    @RequestParam(required = false) String keyword,
                                                                                    @RequestParam(required = false) Integer minPrice,
                                                                                    @RequestParam(required = false) Integer maxPrice
                                                                                    ){
        PageResponseDTO<OrderResponseDTO> pageResponse=orderService.getOrdersByUserId(userId,page,size,sortBy,sortDir,keyword,minPrice,maxPrice);
        APIResponse<PageResponseDTO<OrderResponseDTO>> apiResponse= new APIResponse<>(LocalDateTime.now(),200,"Orders fetched successfully",pageResponse);
        return  ResponseEntity.ok(apiResponse);
    }
}
