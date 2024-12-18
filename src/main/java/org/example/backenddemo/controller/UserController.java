package org.example.backenddemo.controller;

import org.example.backenddemo.entity.Student;
import org.example.backenddemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/user")
    public String query() {
        List<Student> list = studentMapper.find();
        System.out.println(list);
        return "user";
    }
}
