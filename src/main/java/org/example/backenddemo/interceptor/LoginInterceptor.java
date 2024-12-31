package org.example.backenddemo.interceptor;

import org.example.backenddemo.security.JwtTokenProvider;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        boolean i = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
                if (cookie.getName().equals("accountToken")) {
                    i = JwtTokenProvider.validateToken(cookie.getValue());
                }
            }
        }


//        String token = request.getParameter("token");
//        boolean i = JwtTokenProvider.validateToken(token);
        if (i) {
            System.out.println("成功通过拦截器");
        } else {
            System.out.println("被拦截");
        }
        return i;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandle: 请求后拦截");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AfterCompletion: 请求完成后的处理");
    }
}
