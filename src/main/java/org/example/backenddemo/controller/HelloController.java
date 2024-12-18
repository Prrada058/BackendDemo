package org.example.backenddemo.controller;

import io.swagger.annotations.ApiOperation;
import org.example.backenddemo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * http://localhost:8080/getTest1?name=zhangsan
     */
    @ApiOperation("获取用户")
    @GetMapping("/getTest1")
    public String getTest1(String name) {
        System.out.println("get name: " + name);
        return "Hello " + name;
    }

    /**
     * http://localhost:8080/getTest2?username=zhangsan
     * 限制非空
     */
    @GetMapping("/getTest2")
    public String getTest2(@RequestParam("username") String name) {
        System.out.println("get name: " + name);
        return "Hello " + name;
    }

    /**
     * http://localhost:8080/getTest3?name=zhangsan&password=123456
     */
    @GetMapping(value = "/getTest3")
    public String getTest3(User user) {
        System.out.println(user);
        return "get the user:" + user.getName() + "|" + user.getPassword();
    }

    /**
     * http://localhost:8080/getTest4
     * JSON:
     * {
     *     "name":"zhangsan",
     *     "password":"123456"
     * }
     */
    @GetMapping(value = "/getTest4")
    public String getTest4(@RequestBody User user) {
        System.out.println(user);
        return "get the user:" + user.getName() + "|" + user.getPassword();
    }

    /**
     * http://localhost:8080/getTest5/zhangsan
     */
    @GetMapping("/getTest5/{name}")
    public String getTest5(@PathVariable String name) {
        return "get your name" + name;
    }

    /**
     * http://localhost:8080/postTest1
     * from-data
     * name:zhangsan
     * password:123456
     */
    @PostMapping(value = "/postTest1")
    public String postTest1(User user) {
        System.out.println(user);
        return "get the user:" + user.getName() + "|" + user.getPassword();
    }
}
