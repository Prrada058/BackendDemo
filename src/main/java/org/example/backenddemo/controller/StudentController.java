package org.example.backenddemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.backenddemo.entity.Student;
import org.example.backenddemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/student")
    public List query() {
        List<Student> list = studentMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/student")
    public String insert(Student student) {
        int i = studentMapper.insert(student);
        if (i > 0) {
            return "插入成功";
        }else {
            return "插入失败";
        }
    }


    //根据pk 删除
    @PostMapping("/studentD1")
    public String delete(@RequestParam int id) {
        int i = studentMapper.deleteById(id);
        if (i > 0) {
            return "成功删除" + i + "条记录";
        }else {
            return "删除失败";
        }
    }

    // 删除性别为 "男" 的学生
//    @PostMapping("/studentD2")
//    public String wrapperDelete() {
//        QueryWrapper<Student> wrapper = new QueryWrapper<>();
//        wrapper.eq("stuGender", "M");
//        int i = studentMapper.delete(wrapper);
//        if (i > 0) {
//            return "成功删除" + i + "条记录";
//        }else {
//            return "删除失败";
//        }
//    }

    @PostMapping("/studentUpdate")
    public String update(Student student) {
        int i = studentMapper.updateById(student);
        if (i > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

}
