package com.school.secondhand.controller;

import com.school.secondhand.entity.Goods;
import com.school.secondhand.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin // 解决跨域
@RequestMapping("/goods") // 接口前缀：/goods
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 1. 发布商品：POST http://localhost:8080/api/goods/publish
    @PostMapping("/publish")
    public Map<String, Object> publishGoods(@RequestBody Goods goods) {
        Map<String, Object> result = new HashMap<>();
        boolean success = goodsService.publishGoods(goods);
        result.put("success", success);
        result.put("msg", success ? "发布成功" : "发布失败（参数缺失）");
        return result;
    }

    // 2. 查询用户发布的商品：GET http://localhost:8080/api/goods/user/1
    @GetMapping("/user/{userId}")
    public Map<String, Object> getGoodsByUserId(@PathVariable Long userId) {
        Map<String, Object> result = new HashMap<>();
        List<Goods> goodsList = goodsService.getGoodsByUserId(userId);
        result.put("success", true);
        result.put("data", goodsList);
        return result;
    }

    // 3. 查询所有在售商品：GET http://localhost:8080/api/goods/onSale
    @GetMapping("/onSale")
    public Map<String, Object> getOnSaleGoods() {
        Map<String, Object> result = new HashMap<>();
        List<Goods> goodsList = goodsService.getOnSaleGoods();
        result.put("success", true);
        result.put("data", goodsList);
        return result;
    }
}