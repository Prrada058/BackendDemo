package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backenddemo.entity.Student;
import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
//    @Select("select * from student")
//    public List<Student> find();
}
