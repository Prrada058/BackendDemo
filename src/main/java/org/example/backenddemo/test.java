package org.example.backenddemo;

import org.example.backenddemo.security.JwtTokenProvider;

public class test {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJDaGFybGVzIFdpbGxpYW1zIiwiaWF0IjoxNzM0NzYyMzA0LCJleHAiOjE3MzQ3NjU5MDR9.JNkHumZuxPQj2cMo3jPwCQD614EfCmKkXzL7pfWtSQQ";
        System.out.println(JwtTokenProvider.validateToken(token));
        System.out.println(JwtTokenProvider.getUsernameFromToken(token));
        System.out.println(JwtTokenProvider.getTimeFromToken(token));
    }
}
