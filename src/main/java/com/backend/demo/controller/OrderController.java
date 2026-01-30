package com.backend.demo.controller;

import com.backend.demo.dto.*;
import com.backend.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@Tag(name="Orders",description="Order management APIs")
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    private static final Logger log= LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/users/{userId}")
    public ResponseEntity<APIResponse<OrderResponseDTO>> createOrder(@PathVariable int userId,@Valid @RequestBody OrderRequestDTO dto){
        log.info("Get /orders/users/{} called",userId);
        OrderResponseDTO response= orderService.createOrder(userId,dto);
        APIResponse<OrderResponseDTO> apiResponse=new APIResponse<>(LocalDateTime.now(),201,"Order created successfully",response);
        return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @Operation(summary="Get orders by user",description="Fetch orders of a user search,price filtering ,pagination and sorting")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
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

        log.info("GET /orders/users/{} called with page={},size={}, sortBy={}, sortDir={}",userId,page,size,sortBy,sortDir);
        PageResponseDTO<OrderResponseDTO> pageResponse=orderService.getOrdersByUserId(userId,page,size,sortBy,sortDir,keyword,minPrice,maxPrice);
        APIResponse<PageResponseDTO<OrderResponseDTO>> apiResponse= new APIResponse<>(LocalDateTime.now(),200,"Orders fetched successfully",pageResponse);
        return  ResponseEntity.ok(apiResponse);
    }
}
