package com.att.tdp.bisbis10.order;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.dish.DishRepository;
import com.att.tdp.bisbis10.exception.DishNotFoundException;
import com.att.tdp.bisbis10.exception.RestaurantNotFoundException;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public Order addOrder(OrderDTO orderDTO) {
        Restaurant restaurant = restaurantRepository.findById(orderDTO.getRestaurantId())
                                                    .orElseThrow(() -> new RestaurantNotFoundException(orderDTO.getRestaurantId()));
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();

        order.setRestaurant(restaurant);
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            Dish dish = dishRepository.findById(orderItemDTO.getDishId())
                                      .orElseThrow(() -> new DishNotFoundException(orderItemDTO.getDishId(), orderDTO.getRestaurantId()));

            orderItem.setDish(dish);
            orderItem.setAmount(orderItemDTO.getAmount());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        return order;
    }
}
