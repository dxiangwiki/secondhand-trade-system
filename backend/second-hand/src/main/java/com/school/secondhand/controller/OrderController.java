package com.school.secondhand.controller;

import com.school.secondhand.entity.Order;
import com.school.secondhand.service.OrderService;
import com.school.secondhand.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单：POST http://localhost:8080/api/order/create?goodsId=1&userId=1
    @PostMapping("/create")
    public Result<?> createOrder(@RequestParam Long goodsId, @RequestParam Long userId) {
        boolean success = orderService.createOrder(goodsId, userId);
        if (success) {
            return Result.success("创建订单成功");
        }
        return Result.error("创建订单失败（商品不存在/已售出）");
    }

    // 修改订单状态：PUT http://localhost:8080/api/order/status?orderId=1&status=1
    @PutMapping("/status")
    public Result<?> updateOrderStatus(@RequestParam Long orderId, @RequestParam Integer status) {
        boolean success = orderService.updateOrderStatus(orderId, status);
        if (success) {
            return Result.success("修改订单状态成功");
        }
        return Result.error("修改订单状态失败");
    }

    // 查询用户订单：GET http://localhost:8080/api/order/user/1
    @GetMapping("/user/{userId}")
    public Result<List<Order>> getOrderByUserId(@PathVariable Long userId) {
        List<Order> orderList = orderService.getOrderByUserId(userId);
        return Result.success(orderList);
    }
}