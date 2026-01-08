package com.school.secondhand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.secondhand.entity.User;
import org.apache.ibatis.annotations.Mapper;

// 单独放在UserMapper.java文件中
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 无需手写SQL，BaseMapper已包含所有CRUD方法
}