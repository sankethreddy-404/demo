package com.backend.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrderRequestDTO {
    private int userId;
    @NotBlank(message="Product name cannot be blank")
    @Size(min=3,max=50,message="Product name must be between 2 and 50 characters")
    private String productName;
    @NotNull(message="price is required")
    @Min(value=1,message="price should be greater than 0")
    private int price;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
