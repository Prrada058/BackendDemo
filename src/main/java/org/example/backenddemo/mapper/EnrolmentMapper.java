package org.example.backenddemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backenddemo.entity.Enrolment;

import java.util.List;

@Mapper
public interface EnrolmentMapper extends BaseMapper<Enrolment> {

    @Select("select * from enrolment where stu_code = #{stuCode}")
    List<Enrolment> selectByStuCode(int stuCode);


}
