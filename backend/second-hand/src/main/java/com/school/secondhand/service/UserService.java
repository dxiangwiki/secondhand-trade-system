// UserService.java
package com.school.secondhand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.school.secondhand.entity.User;

public interface UserService extends IService<User> {
    // 登录方法：用户名+密码 → 返回用户信息
    User login(String username, String password);
    // 注册方法：用户对象 → 返回是否成功
    boolean register(User user);
}




