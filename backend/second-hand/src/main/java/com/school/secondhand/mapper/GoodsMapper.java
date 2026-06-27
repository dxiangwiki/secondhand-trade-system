package com.school.secondhand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.secondhand.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    // 无需手写任何SQL，BaseMapper已包含：
    // insert(新增)、deleteById(删除)、updateById(修改)、selectById(查单个)、selectList(查列表)等方法
}