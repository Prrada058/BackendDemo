package org.example.backenddemo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenProvider {

    private static final String SECRET_KEY  = "123456789";

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 设置主题（通常是用户名或用户ID）
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 设置过期时间，1小时
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用 HS256 算法签名
                .compact(); // 生成 Token
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token); // 解析 Token 并验证签名
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 从 Token 中提取用户名
    public static String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public static String getTimeFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getIssuedAt().toString();
    }

}
