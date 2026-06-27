package com.school.secondhand.controller;

import com.school.secondhand.entity.Order;
import com.school.secondhand.service.OrderService;
import com.school.secondhand.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单：前端传JSON实体，不能用@RequestParam接收
    @PostMapping("/create")
    public Result<?> createOrder(@RequestBody Order order) {
        boolean success = orderService.createOrder(order.getGoodsId(), order.getUserId());
        if (success) {
            return Result.success("创建订单成功");
        }
        return Result.error("创建订单失败（商品不存在/已售出）");
    }

    // 修改订单状态
    @PutMapping("/status")
    public Result<?> updateOrderStatus(@RequestParam Long orderId, @RequestParam Integer status) {
        boolean success = orderService.updateOrderStatus(orderId, status);
        if (success) {
            return Result.success("修改订单状态成功");
        }
        return Result.error("修改订单状态失败");
    }

    // 查询用户订单
    @GetMapping("/user/{userId}")
    public Result<List<Order>> getOrderByUserId(@PathVariable Long userId) {
        List<Order> orderList = orderService.getOrderByUserId(userId);
        return Result.success(orderList);
    }
}