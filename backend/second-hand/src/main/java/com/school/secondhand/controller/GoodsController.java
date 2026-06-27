package com.school.secondhand.controller;

import com.school.secondhand.entity.Goods;
import com.school.secondhand.service.GoodsService;
import com.school.secondhand.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.school.secondhand.service.GoodsService;
@RestController
@RequestMapping("/goods")
public class GoodsController {

    // 漏掉了这段注入代码，补上就解决报错
    @Autowired
    private GoodsService goodsService;

    // 发布商品
    @PostMapping("/publish")
    public Result<?> publishGoods(@RequestBody Goods goods) {
        boolean success = goodsService.publishGoods(goods);
        if (success) {
            return Result.success("发布成功");
        } else {
            return Result.error("发布失败（参数缺失）");
        }
    }

    // 查询用户发布商品
    @GetMapping("/user/{userId}")
    public Result<List<Goods>> getGoodsByUserId(@PathVariable Long userId) {
        List<Goods> goodsList = goodsService.getGoodsByUserId(userId);
        return Result.success(goodsList);
    }

    // 查询所有在售商品
    @GetMapping("/onSale")
    public Result<List<Goods>> getOnSaleGoods() {
        List<Goods> goodsList = goodsService.getOnSaleGoods();
        return Result.success(goodsList);
    }
}