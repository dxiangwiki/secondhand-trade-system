// 在controller包下新建TestController.java
package com.school.secondhand.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // 解决跨域
public class TestController {
    @GetMapping("/test/hello")
    public String hello() {
        return "后端接口正常！";
    }
}