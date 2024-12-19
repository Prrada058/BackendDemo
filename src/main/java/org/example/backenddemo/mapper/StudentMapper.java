package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.backenddemo.entity.Student;
import java.util.List;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {
//    @Select("select * from student")
//    public List<Student> find();


    @Select("select * from student")
    @Results(
            {
                @Result(column = "stu_code", property = "stuCode"),
                @Result(column = "stu_fname", property = "stuFname"),
                @Result(column = "stu_lname", property = "stuLname"),
                @Result(column = "stu_code", property = "enrolments", javaType = List.class, many=@Many(select = "org.example.backenddemo.mapper.EnrolmentMapper.selectByStuCode"))
    }
    )
    List<Student> selectAllsStudentEnrollment();
}
