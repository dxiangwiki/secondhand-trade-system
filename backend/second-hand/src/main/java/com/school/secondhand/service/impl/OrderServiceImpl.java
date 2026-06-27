package com.school.secondhand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.secondhand.entity.Goods;
import com.school.secondhand.entity.Order;
import com.school.secondhand.mapper.OrderMapper;
import com.school.secondhand.service.GoodsService;
import com.school.secondhand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private GoodsService goodsService;

    @Override
    public boolean createOrder(Long goodsId, Long userId) {
        // 1. 校验商品是否存在且在售
        Goods goods = goodsService.getById(goodsId);
        if (goods == null || goods.getStatus() != 0) {
            return false;
        }
        // 2. 构建订单
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setUserId(userId);
        order.setSellerId(goods.getUserId());
        order.setPrice(goods.getPrice());
        order.setStatus(0); // 待付款
        // 3. 保存订单
        boolean saveFlag = this.save(order);
        if (saveFlag) {
            // 4. 商品标记为已售出
            goods.setStatus(1);
            goodsService.updateById(goods);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrderStatus(Long orderId, Integer status) {
        Order order = this.getById(orderId);
        if (order == null) {
            return false;
        }
        order.setStatus(status);
        return this.updateById(order);
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.orderByDesc("create_time");
        return this.list(queryWrapper);
    }
}