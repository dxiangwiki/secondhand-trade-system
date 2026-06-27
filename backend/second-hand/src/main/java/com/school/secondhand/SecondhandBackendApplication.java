package com.school.secondhand;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.school.secondhand.mapper") // 扫描mapper
public class SecondhandBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondhandBackendApplication.class, args);
    }
}