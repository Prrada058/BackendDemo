package org.example.backenddemo.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.backenddemo.dto.LoginRequest;
import org.example.backenddemo.entity.Account;
import org.example.backenddemo.mapper.AccountMapper;
import org.example.backenddemo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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


    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // 从 JSON 中提取数据
        String accName = request.getAccName();
        String accPassword = request.getAccPassword();
        String accToken = request.getAccToken();

        if (accToken != null && !accToken.isEmpty()) {
            if (JwtTokenProvider.validateToken(accToken)) {
                System.out.println("token登录成功");
                return ResponseEntity.ok("token登录成功");
            } else {
                return ResponseEntity.status(401).body("错误 token");
            }
        } else {
            String password = accountMapper.getPasswordByUsername(accName);
            if (password == null) {
                return ResponseEntity.status(401).body("错误的用户名");
            } else {
                if (password.equals(accPassword)) {
                    String token = JwtTokenProvider.generateToken(accName);
                    System.out.println("登录成功返回 token");
                    return ResponseEntity.ok(token);
                } else {
                    return ResponseEntity.status(401).body("错误的密码");
                }
            }
        }
    }


    @PostMapping("/account/changePassword")
    public String changePassword(@RequestParam String accName, @RequestParam String passwordBefore, @RequestParam String accPassword) {
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

    @GetMapping("/account/list")
    public List<Account> query() {
        List<Account> accounts = accountMapper.selectList(null);
        return accounts;
    }

//    @PostMapping("/accProfilePhoto")
//    public String accProfilePhoto(String accountName, MultipartFile accProfilePhoto) throws IOException {
//        System.out.println(accProfilePhoto.isEmpty());
//        return FilesController.up(accProfilePhoto);
//
//    }

}
