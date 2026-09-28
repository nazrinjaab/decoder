package com.example.demo.service;

import com.example.demo.client.UserServiceClient;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.entity.Order;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final UserServiceClient userServiceClient;

    private List<Order> orders = new ArrayList<>();

    public OrderService(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    public Order createOrder(Order order) {

        try {
            userServiceClient.getUserById(order.getUserId());

        } catch (FeignException.NotFound exception) {
            throw new UserNotFoundException(
                    "user with id" + order.getUserId() + "not found"
            );
        }

        order.setId((long) (orders.size() + 1));
        orders.add(order);

        return order;
    }
}