package org.example.backenddemo.controller;

import org.example.backenddemo.entity.Account;
import org.example.backenddemo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/signup")
    public String createAccount(Account account) {
        int i = accountMapper.insert(account);
        if (i > 0) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    // todo 登录api区分密码错误还是用户名不存在

    @PostMapping("login")
    public String login(@RequestParam("accName") String accName, @RequestParam("accPassword") String accPassword) {
        String password = accountMapper.getPasswordByUsername(accName);
        System.out.println("数据库中的"+password);
        System.out.println("输入的密码"+accPassword);
        if (password != null && password.equals(accPassword)){
            return "login success";
        }else {
            return "login failed";
        }
    }

    // todo 增加修改密码
}
