package com.school.secondhand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.school.secondhand.entity.Order;
import java.util.List;

public interface OrderService extends IService<Order> {
    // 创建订单
    boolean createOrder(Long goodsId, Long userId);
    // 修改订单状态
    boolean updateOrderStatus(Long orderId, Integer status);
    // 查询用户所有订单
    List<Order> getOrderByUserId(Long userId);
}