package com.school.secondhand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.school.secondhand.entity.Goods;
import java.util.List;

public interface GoodsService extends IService<Goods> {
    // 自定义业务方法（根据需求加）
    boolean publishGoods(Goods goods); // 发布商品
    List<Goods> getGoodsByUserId(Long userId); // 查询用户发布的商品
    List<Goods> getOnSaleGoods(); // 查询所有在售商品
}