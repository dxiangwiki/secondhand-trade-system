package com.school.secondhand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.secondhand.entity.Goods;
import com.school.secondhand.mapper.GoodsMapper;
import com.school.secondhand.service.GoodsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    public boolean publishGoods(Goods goods) {
        // 判空校验
        if (goods == null || goods.getTitle() == null || goods.getPrice() == null || goods.getUserId() == null) {
            return false;
        }
        // 默认设置商品状态为“在售”
        goods.setStatus(0);
        // 保存商品（IService自带的save方法）
        return this.save(goods);
    }

    @Override
    public List<Goods> getGoodsByUserId(Long userId) {
        // 条件查询：根据userId查商品
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.orderByDesc("create_time"); // 按发布时间降序
        return this.list(queryWrapper);
    }

    @Override
    public List<Goods> getOnSaleGoods() {
        // 条件查询：状态为0（在售）的商品
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        queryWrapper.orderByDesc("create_time");
        return this.list(queryWrapper);
    }
}