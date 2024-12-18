package org.example.backenddemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backenddemo.entity.Student;

import javax.management.Query;
import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from STUDENT")
    public List<Student> find();
}
