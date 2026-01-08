package com.school.secondhand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBoot核心注解：标记启动类
@SpringBootApplication
// MyBatis扫描Mapper接口（必须加，否则找不到Mapper）
@MapperScan("com.school.secondhand.mapper")
public class SecondhandBackendApplication {

    public static void main(String[] args) {
        // 启动SpringBoot项目
        SpringApplication.run(SecondhandBackendApplication.class, args);
    }

}