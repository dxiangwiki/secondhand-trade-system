package com.school.secondhand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// 对应数据库goods表
@TableName("goods")
public class Goods {
    @TableId(type = IdType.AUTO)
    private Long id;         // 商品ID
    private String title;    // 商品标题
    private BigDecimal price; // 商品价格（用BigDecimal避免浮点精度问题）
    private String description; // 商品描述
    private String imageUrl; // 商品图片URL（驼峰命名，对应数据库image_url）
    private Long userId;     // 发布用户ID
    private Integer status;  // 商品状态
    private LocalDateTime createTime; // 发布时间

    // 手动生成所有get/set方法（复制User类的格式，替换字段名即可）
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}