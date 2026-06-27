package com.school.secondhand.utils; // 包路径必须和UserServiceImpl的包对应

import org.springframework.util.DigestUtils;

public class PasswordUtil {
    // 密码加密（MD5）
    public static String encrypt(String password) {
        if (password == null || password.trim().isEmpty()) {
            return "";
        }
        return DigestUtils.md5DigestAsHex(password.trim().getBytes());
    }

    // 密码校验（明文和密文对比）
    public static boolean check(String rawPwd, String encryptPwd) {
        return encrypt(rawPwd).equals(encryptPwd);
    }
}