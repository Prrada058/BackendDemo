package org.example.backenddemo;

import org.example.backenddemo.security.JwtTokenProvider;

public class test {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyjzdWIiOiJ0ZXN0MSIsImlhdCI6MTczNTAwMjY2MiwiZXhwIjoxNzM1MDA2MjYyfQ.cTqbb62jWQBKpfmnDx8oc3Z0zoS65daCRjc9Nyukr2M";
        System.out.println(JwtTokenProvider.validateToken(token));
        System.out.println(JwtTokenProvider.getUsernameFromToken(token));
        System.out.println(JwtTokenProvider.getTimeFromToken(token));
    }
}
