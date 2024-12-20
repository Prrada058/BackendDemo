package org.example.backenddemo.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.backenddemo.entity.Account;
import org.example.backenddemo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/signup")
    public String createAccount(Account account) {
        try {
            int i = accountMapper.insert(account);
            if (i > 0) {
                return "注册成功";
            } else {
                return "注册失败";
            }
        } catch (DataIntegrityViolationException ex) {
            // 判断是否是违反唯一约束的异常
            if (ex.getCause() instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException sqlEx = (SQLIntegrityConstraintViolationException) ex.getCause();
                // 检查错误信息中是否包含违反唯一约束的提示
                if (sqlEx.getMessage().contains("ACC_NAME_UNIQUE")) {
                    return "用户名已存在";
                }
            }
            return "数据库约束违规";
        } catch (Exception ex) {
            return "系统错误: " + ex.getMessage();
        }
    }
// todo 先查询查重还是直接 catch 异常


    @PostMapping("/login")
    public String login(@RequestParam("accName") String accName, @RequestParam("accPassword") String accPassword) {
        String password = accountMapper.getPasswordByUsername(accName);
//        System.out.println("数据库中的" + password);
//        System.out.println("输入的密码" + accPassword);
        if (password == null) {
            return "错误的用户名";
        } else {
            if (password.equals(accPassword)) {
                return "登录成功";
            } else {
                return "错误的密码";
            }
        }
    }


    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String accName, @RequestParam String passwordBefore,@RequestParam String accPassword) {
        String password = accountMapper.getPasswordByUsername(accName);
        if (password == null) {
            return "错误的用户名";
        } else {
            if (password.equals(passwordBefore)) {

                UpdateWrapper<Account> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("acc_name", accName)  // 条件：用户名
                        .set("acc_password", accPassword); // 更新密码
                int i = accountMapper.update(null, updateWrapper);
                return "密码修改成功";
            } else {
                return "错误的密码";
            }
        }
    }
}
